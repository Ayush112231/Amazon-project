package AyushAmazon.jaimatadi;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductResult{  
	WebDriver driver;
	Actions act;
@FindBy(xpath="//input[@id='twotabsearchtextbox']") 
private WebElement product;  
@FindBy(xpath="//div[contains(@class,'s-result-item s-asin ')]") 
private List<WebElement> list;  
@FindBy(xpath="//input[@id='add-to-cart-button']") 
private WebElement add;

public ProductResult(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void searchProduct(String data1)
{
	product.sendKeys(data1); 
	product.sendKeys(Keys.ENTER); 
	 new WebDriverWait(driver, Duration.ofSeconds(10))
     .until(ExpectedConditions.visibilityOfAllElements(list)); 
	 product.clear();	
} 

public void clickProduct() throws IOException { 
    System.out.println("Products found: " + list.size());
    String mainWindow = driver.getWindowHandle();

    for (int i = 0; i < Math.min(list.size(), 3); i++) { // limit 3 products for demo
        list.get(i).click();

        
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(driver -> driver.getWindowHandles().size() > 1);

       
        Set<String> allWindows = driver.getWindowHandles();
        for (String win : allWindows) {
            if (!win.equals(mainWindow)) {
                driver.switchTo().window(win);
                break;
            }
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            add.click(); 
            
    
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }

        LocalTime currentTime = LocalTime.now(); 
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH-mm-ss"); 
    	String timeString = currentTime.format(formatter);
    	
        TakesScreenshot ts=(TakesScreenshot)driver; 
        File src=ts.getScreenshotAs(OutputType.FILE); 
        File des=new File("D:\\Screen\\"+timeString+".png"); 
        FileHandler.copy(src, des);
        driver.close();
        driver.switchTo().window(mainWindow);
        PageFactory.initElements(driver, this);
    }
}
}




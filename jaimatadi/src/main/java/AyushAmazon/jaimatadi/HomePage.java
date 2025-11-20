package AyushAmazon.jaimatadi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//a[@id='nav-logo-sprites']")
	WebElement logo1;
	@FindBy(xpath = "//a[text()='Mobiles']")
	WebElement navMobile;

	@FindBy(xpath = "//img[@alt='Amazon fashion']")
	WebElement amazonFashionImage;
	@FindBy(xpath = "//span[contains(text(),\"Men's Wonder-13)]")
	WebElement fashion;

	@FindBy(xpath = "//a[@id='nav-orders']")
	WebElement orderClick;

	@FindBy(xpath = "//a[h5[contains(text(),'Amazon Web Services')]]")
	WebElement foot;

	@FindBy(xpath = "//button[contains(@class,'nav-icon nav-arrow')]")
	WebElement lang;

	@FindBy(xpath = "//span[contains(text(),'Update location')]")
	WebElement deliv;
	@FindBy(xpath = "//input[@id='GLUXZipUpdateInput']")
	WebElement pin; 
	@FindBy(xpath="//input[text()='Apply']") 
	WebElement apply;

	private Actions act;
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
		PageFactory.initElements(driver, this);

	}

	public void logo() {
		act.click(logo1).perform();
		;
		String logoString = "https://www.amazon.in/ref=nav_logo";
		String logoCurrent = driver.getCurrentUrl();
		boolean b = logoString.equals(logoCurrent);
		System.out.println(b + " " + "logo is redirecting");
		driver.navigate().to("https://www.amazon.in");
		PageFactory.initElements(driver, this);
	}

	public void navigationBar() {
		act.click(navMobile).perform();
		String s = driver.getCurrentUrl();
		if (s.contains("mobile"))
			System.out.print("navMobile is Working");
		driver.navigate().to("https://www.amazon.in");
		PageFactory.initElements(driver, this);
	}

	/*
	 * public void promotional() { act.click(amazonFashionImage).perform(); String
	 * s1=fashion.getText(); if(s1.contains("shoes")) {
	 * System.out.print("fashion Page clickable"); }
	 * driver.navigate().to("https://www.amazon.in");
	 * PageFactory.initElements(driver, this); }
	 */

	public void returnAndOrders() {
		act.click(orderClick).perform();
		String s1 = driver.getCurrentUrl();
		if (s1.contains("order")) {
			System.out.println("OrderPage");
		}
		driver.navigate().to("https://www.amazon.in");
		PageFactory.initElements(driver, this);
	}

	
	  public void footer()
	  { act.click(foot).perform(); String
	  s1=driver.getCurrentUrl();
	  if(s1.contains("aws")) {
	  System.out.println("AWSPage"); }
	  driver.navigate().to("https://www.amazon.in");
	  PageFactory.initElements(driver, this);
	  
	  } 
	  public void language() { 
		  act.click(lang).perform(); 
		  String s1=driver.getCurrentUrl();
		  if(s1.contains("customer-preferences")) {
	  System.out.println("Language Working"); }
	  driver.navigate().to("https://www.amazon.in");
	  PageFactory.initElements(driver, this); } 
	  
	  public void deliver() {
	  act.click(deliv).perform();
	  pin.sendKeys("476001");  
	  act.click(apply).perform();
	  }
	 

}

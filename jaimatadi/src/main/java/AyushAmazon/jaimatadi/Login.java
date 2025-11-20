package AyushAmazon.jaimatadi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login{
	WebDriver driver;
	private Actions act;
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") 
	private WebElement login ;  
	@FindBy(xpath="//input[@id='ap_email_login']") 
	private WebElement email; 
	@FindBy(xpath="//input[@class='a-button-input']") 
	private WebElement continu; 
	@FindBy(xpath="//input[@id='ap_password']") 
	private WebElement password; 
	@FindBy(xpath="//input[@id='signInSubmit']")  
	private WebElement submit;
	
	public Login()
	{
		
	}
	public Login(WebDriver driver)
	{
		 this.driver=driver;
	    act=new Actions(driver);  
		PageFactory.initElements(driver, this);
		
		}	
	
	public void loginClick()
	{
		act.moveToElement(login).click().perform();
	}  
	public void fillEmail(String s)
	{
		act.click(email).perform();  
		email.sendKeys(s);
		act.click(continu).perform();
	} 
	public void pass(String pass)
	{
	act.click(password).perform();	  
	password.sendKeys(pass);
	act.click(submit).perform();
	}
	
} 
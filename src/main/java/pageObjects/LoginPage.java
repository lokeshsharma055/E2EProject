package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	private By userName= By.id("user_email");
	private By pswd= By.xpath("//*[@name=' password']");
	
	private By login= By.cssSelector("[value='Log In']");
	
	private By forgotPassword= By.cssSelector("[href*='password/new']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	public WebElement emailAddress()
	{
		return driver.findElement(userName);
	}
	
	public WebElement password()
	{
		return driver.findElement(pswd);
	}
	
	public WebElement getlogin()
	{
		return driver.findElement(login);
	}
	
	public ForgotPassword forgotpassword()
	{
	
		driver.findElement(forgotPassword).click();
		
		return new ForgotPassword(driver); 
		
	}

}

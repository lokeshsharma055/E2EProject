package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	
	public WebDriver driver;

	public static Logger log= 	LogManager.getLogger(HomePage.class.getName());	
	
	@BeforeTest
	public void initialise() throws IOException
	{
		driver= initializeDriver();
		log.info("Driver is intialized");
		
		driver.get(prop.getProperty("url"));
		
		log.info("Navigated to home page");
	}
	
	
	@Test(dataProvider="getData")
public void basePageNavigation(String userName, String password) throws IOException
{
	
	
	//Creating object for landing page locators
	
	LandingPage l=new LandingPage(driver);
	driver.get(prop.getProperty("url"));
	
	LoginPage lp= l.getLogin();
	
	//LoginPage lp= new LoginPage(driver);
	
	lp.emailAddress().sendKeys(userName);
	
	log.info("UserName entered successfully");
	
	lp.password().sendKeys(password);
	
	log.info("Password entered successfully");
	
	lp.getlogin().click();
	
	ForgotPassword fp = lp.forgotpassword();
	
	fp.getEmail().sendKeys("asdfgh");
	
	fp.getsendMeInstructions().click();
	
	log.info("clicked on sign in button");
	
	
}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		//Row stands for how many different data types test should run
		//Column stands for how many values per each test
		//driver= initializeDriver();
		
		Object[][] data= new Object[2][2];
		
		//0th row  
		
		data[0][0]= "nonrestricteduser@gmail.com";
		
		data[0][1]= "123456";
		
		
		//1st row
		
        data[1][0]= "Restricteduser@gmail.com";
		
		data[1][1]= "9999";
		
	  
		
		return data;
		
		
		
		
	}
	
	 @AfterTest
	 public void tearDown()
	 {
		 driver.close();
	 }
	

}

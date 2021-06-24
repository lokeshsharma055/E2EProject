package Academy;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class verifyNavigationBar extends base {
	
	public WebDriver driver;
	public static Logger log= 	LogManager.getLogger(verifyNavigationBar.class.getName());	
	@BeforeTest
	public void initialise() throws IOException
	{
		driver= initializeDriver();
		log.info("Driver is intialized");
		
		driver.get(prop.getProperty("url"));
		
		log.info("Navigated to home page");
	}
	
	@Test
	public void verifyBar() throws IOException
	{
		
		//Creating object for landing page locators
		
		LandingPage l=new LandingPage(driver);
		
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		
		log.info("Navigation bar is displayed");
		
		//Assert.assertFalse(condition);
		
		
	}
	
	 @AfterTest
	 public void tearDown()
	 {
		 driver.close();
	 }

}

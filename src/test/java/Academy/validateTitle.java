package Academy;

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

public class validateTitle extends base {
	
	public WebDriver driver;
	
	public static Logger log= 	LogManager.getLogger(validateTitle.class.getName());	
	
	@BeforeTest
	public void initialise() throws IOException
	{
		driver= initializeDriver();
		log.info("Driver is intialized");
		
		driver.get(prop.getProperty("url"));
		
		log.info("Navigated to home page");
		
		
	}
	
	
	@Test
	public void verifyTitle() throws IOException
	{
		
		LandingPage lp= new LandingPage(driver);
		
		
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES123");
		
		log.info("Successfully verified the title");
		
		//lp.getTitle().getText();
		
	}
	
	 @AfterTest
	 public void tearDown()
	 {
		 driver.close();
	 }

}

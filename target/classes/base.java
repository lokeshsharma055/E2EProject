package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop= new Properties();
		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
	    prop.load(fis);
	    
	  String browserName=  prop.getProperty("browser");
	 
	  
	  if(browserName.equals("chrome"))
	  {
		  
			//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			
			ChromeOptions options= new ChromeOptions();
			
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			
		    driver= new ChromeDriver(options);
		  
	  }
	  else if(browserName.equals("firefox"))
	  {
		  //System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver.exe");
		  
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
		  
		  driver=new FirefoxDriver();
	  }
	    
	  else if(browserName.equals("IE"))
	  {
		  
		  //System.setProperty("webdriver.IE.driver", "D:\\Selenium\\IEDriverServer.exe");
		  
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
		  
		   driver=new InternetExplorerDriver();
		  
	  }
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  return driver;
	    
	}
	
//	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
//	{
//		
//		TakesScreenshot ts= (TakesScreenshot) driver;
//		
//		File source= ts.getScreenshotAs(OutputType.FILE);
//		
//		String destinationFile= System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
//		
//		FileUtils.copyFile(source,new File(destinationFile));
//		
//		
//		
//		
//		
//		
//	}
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		//String png= System.currentTimeMillis()+ ".png";
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+formater.format(calendar.getTime())+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		
		return destinationFile;
	}

}

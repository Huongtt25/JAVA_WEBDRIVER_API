package selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class checkMT {
	 WebDriver driver;
 @BeforeClass
 public void beforeClass() {
//	driver= new FirefoxDriver();
	//chrome
//	System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe" );
//	driver= new ChromeDriver();
	// IE
	System.setProperty("webdriver.ie.driver",".\\driver\\IEDriverServer.exe" );
	driver= new InternetExplorerDriver();
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.guru99.com/");
	
	  }
 
  @Test
  public void TC_01_checkTitle() {
	  
	  String homepageTitle = driver.getTitle();
	  Assert.assertEquals("Meet Guru99 - Free Training Tutorials & Video for IT Courses", homepageTitle);
  }
  @Test
  public void TC_02_checkURL (){
	  
	  String homepageUrl= driver.getCurrentUrl();
	  Assert.assertEquals("https://www.guru99.com/",homepageUrl );
  }


  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}

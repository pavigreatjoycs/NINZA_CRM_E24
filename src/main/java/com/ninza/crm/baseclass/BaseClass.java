package com.ninza.crm.baseclass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import com.ninza.crm.generic.fileutility.ExcelFileUtility;
import com.ninza.crm.generic.fileutility.PropertyFileUtility;
import com.ninza.crm.generic.webdriverutility.JavaUtility;
import com.ninza.crm.generic.webdriverutility.WebDriverUtility;
import com.ninza.crm.objectrepository.HomePage;
import com.ninza.crm.objectrepository.LoginPage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;



public class BaseClass {
	
public WebDriver driver = null;
	
	public PropertyFileUtility plib = new PropertyFileUtility();
	public ExcelFileUtility elib = new ExcelFileUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public JavaUtility jlib=new JavaUtility();
	
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  System.out.println("login to the application");
	  String url = plib.toGetDataFromPropertiesFile("url");
		String username = plib.toGetDataFromPropertiesFile("username");
		String password = plib.toGetDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginIntoApp(url, username, password);
		System.out.println("Login");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("logout of the application");
	  HomePage hp = new HomePage(driver);
	  hp.logout();
  }

  @BeforeClass
  public void beforeClass() throws IOException {
	  System.setProperty("webdriver.edge.driver", "D:/Software/edgedriver_win64/msedgedriver.exe");
	  String browser = plib.toGetDataFromPropertiesFile("browser");
		if (browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("Edge"))
			driver = new EdgeDriver();
		else if (browser.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("Safari"))
			driver = new SafariDriver();
	  System.out.println("launch the browser");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  System.out.println("Close the browser");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Pre-condition for the parallel execution");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Post condition for the parallel execution");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Connect to database");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Disconnect database");
  }

}

package com.ninza.crm.baseclass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ninza.crm.generic.fileutility.ExcelFileUtility;
import com.ninza.crm.generic.fileutility.PropertyFileUtility;
import com.ninza.crm.generic.webdriverutility.JavaUtility;
import com.ninza.crm.generic.webdriverutility.WebDriverUtility;
import com.ninza.crm.objectrepository.HomePage;
import com.ninza.crm.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass2 {
	public WebDriver driver=null;
	public PropertyFileUtility plib = new PropertyFileUtility();
	public ExcelFileUtility elib = new ExcelFileUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public JavaUtility jlib = new JavaUtility();
	public static WebDriver sdriver =null;
	
  
  @BeforeMethod(groups= {"Smoke","Regression"})
  public void beforeMethod() throws IOException {
	  	System.out.println("Login");
	  	String URL = plib.toGetDataFromPropertiesFile("url");
		String USERNAME = plib.toGetDataFromPropertiesFile("username");
		String PASSWORD = plib.toGetDataFromPropertiesFile("password");
		
//		String URL = System.getProperty("url");
//		String USERNAME = System.getProperty("username");
//		String PASSWORD=System.getProperty("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginIntoApp(URL, USERNAME, PASSWORD);
  }

  @AfterMethod(groups= {"Smoke","Regression"})
  public void afterMethod() {
	  System.out.println("Logout");
	  HomePage hp =new HomePage(driver);
	  hp.logout();
  }

//  @Parameters("Browser")
  @BeforeClass(groups= {"Smoke","Regression"})
//  public void beforeClass(String BROWSER) throws IOException{
  public void beforeClass() throws IOException {
	  System.out.println("Launch the browser");
		System.setProperty("webdriver.edge.driver", "D:/Software/edgedriver_win64/msedgedriver.exe");
	  String BROWSER = plib.toGetDataFromPropertiesFile("browser");
//	  String BROWSER = System.getProperty("Browser");
	  
//		WebDriverManager.edgedriver().setup();
//		WebDriverManager.chromedriver().setup();
	  if(BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else if(BROWSER.equalsIgnoreCase("chrome")) {
			ChromeOptions settings = new ChromeOptions();
			Map<String,Object> prefs = new HashMap<String,Object>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(settings);
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
	  sdriver = driver;
  }

  @AfterClass(groups= {"Smoke","Regression"})
  public void afterClass() {
	  System.out.println("Close the browser");
	  driver.quit();
  }

  @BeforeTest(groups= {"Smoke","Regression"})
  public void beforeTest() {
	  System.out.println("Pre condition for parallel execution");
  }

  @AfterTest(groups= {"Smoke","Regression"})
  public void afterTest() {
	  System.out.println("Post condition for parallel execution");
  }

  @BeforeSuite(groups= {"Smoke","Regression"})
  public void beforeSuite() {
	  System.out.println("Db Connection");
  }

  @AfterSuite(groups= {"Smoke","Regression"})
  public void afterSuite() {
	  System.out.println("Close the DB connection");
  }

}

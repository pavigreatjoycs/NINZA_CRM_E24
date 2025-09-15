package com.ninza.crm.campaignstest;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ninza.crm.baseclass.BaseClass2;
import com.ninza.crm.generic.fileutility.ExcelFileUtility;
import com.ninza.crm.generic.fileutility.JsonFileUtility;
import com.ninza.crm.generic.fileutility.PropertyFileUtility;
import com.ninza.crm.generic.webdriverutility.JavaUtility;
import com.ninza.crm.generic.webdriverutility.WebDriverUtility;
import com.ninza.crm.objectrepository.CampaignsPage;
import com.ninza.crm.objectrepository.CreateCampaignsPage;
import com.ninza.crm.objectrepository.HomePage;
import com.ninza.crm.objectrepository.LoginPage;

@Listeners(com.ninza.crm.listenerutility.ListenerImplementation.class)
public class CreateCampaignTest extends BaseClass2	{

	@Test(groups = "Smoke")
	public void createCampaignWithMandatoryFieldsTest() throws IOException, InterruptedException {
		
		//Click on Campaigns link in Home page
		HomePage hp = new HomePage(driver);
		hp.getCampaignLink().click();
		
		//Click on Create Campaign button
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaign().click();
		
		Thread.sleep(2000);
		//Create Campaign with mandatory fields
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		String CAMPAIGN_NAME = elib.toReadTheDataFromExcel("Camp", 1, 1);
		ccp.getCampaignName().sendKeys(CAMPAIGN_NAME);
		String TARGET_SIZE = elib.toReadTheDataFromExcel("Camp", 1, 2);
		ccp.getTargetSize().clear();
		ccp.getTargetSize().sendKeys(TARGET_SIZE);
		
		
		//Click on Create Campaign button
		ccp.getCreateButton().click();
		
		//Verify the successful message
		WebElement toastMsg = hp.getToastMsg();
		wlib.waitForVisibilityOfElement(driver, toastMsg);
		
		String text = toastMsg.getText();
		System.out.println(text);
//		if(text.contains(CAMPAIGN_NAME)) {
//			System.out.println("Campaign created successfully.");
//		}else {
//			System.out.println("Campaign not created");
//		}
//		Assert.assertTrue(text.contains(CAMPAIGN_NAME));
		hp.getCloseToastMsgBtn().click();
		Assert.assertEquals(text, "Campaign "+ CAMPAIGN_NAME +" Successfully Added","Both are not equal" );
		
	}
	
	@Test(groups="Regression")
	public void CreateCampaignWithExpectedDateTest() throws IOException, ParseException, InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.getCampaignLink().click();
		
		//Click on Create Campaign button
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaign().click();
		
		//Campaign Name
		String CampaignName = elib.toReadTheDataFromExcel("Camp", 1, 1);
		String targetSize = elib.toReadTheDataFromExcel("Camp", 1, 2);
		
		//Create Campaign with Mandatory fields
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.getCampaignName().sendKeys(CampaignName);
		ccp.getTargetSize().clear();
		ccp.getTargetSize().sendKeys(targetSize);
		
		String expectedDate = jlib.getRequireDate(30);
		ccp.getExpectedCloseDate().sendKeys(expectedDate);
		
		//Create Campaign button
		ccp.getCreateButton().click();
		
		//
		//Verify the successful messsage
		WebElement toastMsg = hp.getToastMsg();
		wlib.waitForVisibilityOfElement(driver, toastMsg);
		
		String text = toastMsg.getText();
//		if(text.contains(CampaignName)) {
//			System.out.println("Campaign created successfully");
//		}else {
//			System.out.println("Campaign not created");
//		}
		System.out.println("control here");
		hp.getCloseToastMsgBtn().click();
		Assert.assertTrue(text.contains(CampaignName));
		
	}
}

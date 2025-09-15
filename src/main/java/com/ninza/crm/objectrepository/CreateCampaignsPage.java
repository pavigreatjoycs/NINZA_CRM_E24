package com.ninza.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignsPage {
	
	WebDriver driver;
	
	public CreateCampaignsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="campaignName")
	private WebElement campaignName;
	
	@FindBy(name="targetSize")
	private WebElement targetSize;
	
	@FindBy(name="campaignStatus")
	private WebElement campaignStatus;
	
	@FindBy(name = "expectedCloseDate")
	private WebElement expectedCloseDate;
	
	@FindBy(xpath ="//button[text()='Create Campaign']")
	private WebElement createButton;

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getTargetSize() {
		return targetSize;
	}

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCampaignStatus() {
		return campaignStatus;
	}

	public WebElement getCreateButton() {
		return createButton;
	}
	
	public void createCampaign(String campaignName, String targetSize) {
		HomePage hp = new HomePage(driver);
		hp.getCampaignLink().click();
		getCampaignName().sendKeys(campaignName);
		getTargetSize().sendKeys(targetSize);
	}
	
	

}

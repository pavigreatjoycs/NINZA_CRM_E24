package com.ninza.crm.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninza.crm.generic.webdriverutility.*;

public class HomePage {
	WebDriverUtility wlib = new WebDriverUtility();
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="Quotes")
	private WebElement quotesLink;
	
	@FindBy(linkText="Purchase Order")
	private WebElement purchaseOrderLink;
	 
	 @FindBy(xpath="//div[@role='alert']")
	 private WebElement toastMsg;
	  
	 @FindBy(xpath = "//button[@aria-label='close']")
	 private WebElement closeToastMsgBtn;
	 
	 @FindBy(className = "user-icon") 
	 private WebElement userIcon; 
	  
	 @FindBy(xpath = "//div[text()='Logout ']") 
	 private WebElement logoutBtn; 

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getQuotesLink() {
		return quotesLink;
	}

	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}

	
	public WebElement getToastMsg() {
		return toastMsg;
	}

	public WebElement getCloseToastMsgBtn() {
		return closeToastMsgBtn;
	}

	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	public void logout() { 
		wlib.mouseHoverOnWebElement(driver, userIcon); 
		wlib.clickOnWebElement(driver, logoutBtn); 
		}
	
}

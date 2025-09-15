package com.ninza.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void waitForVisibilityOfElement(WebDriver driver, WebElement we) {
		WebDriverWait ewait = new WebDriverWait(driver,Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOf(we));
	}
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameorid) {
		driver.switchTo().frame(nameorid);
	}
	
	public void switchToFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	public void select(WebElement we, int index) {
		Select select = new Select(we);
		select.selectByIndex(index);
	}
	
	public void select(WebElement we,String value) {
		Select select = new Select(we);
		select.selectByValue(value);
	}
	
	public void select(String text, WebElement element)
	{
		Select select = new Select(element);
		select.selectByContainsVisibleText(text);
	}
	
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String switchToAlertAndGetText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	public void switchToAlertAndSendKeys(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	
	public void mouseHoverOnWebElement(WebDriver driver, WebElement we) {
		Actions action = new Actions(driver);
		action.moveToElement(we).perform();
		}
	
	public void clickOnWebElement(WebDriver driver, WebElement we) {
		Actions action = new Actions(driver);
		action.moveToElement(we).click().perform();
	}
	
	public void switchToWindow(WebDriver driver) {
		String parent = driver.getWindowHandle();
		Set<String> allWindowIds = driver.getWindowHandles();
		allWindowIds.remove(parent);
		for(String id:allWindowIds) {
			driver.switchTo().window(id);
		}
	}
	
	public void doubleClickOnWebElement(WebDriver driver, WebElement we) {
		Actions action = new Actions(driver);
		action.doubleClick(we).perform();
	}
	
	public void RightClickOnWebElement(WebDriver driver, WebElement we) {
		Actions action = new Actions(driver);
		action.contextClick(we).perform();
	}
	
	public void passInput(WebDriver driver, WebElement element, String text) {
		Actions action = new Actions(driver);
		action.click(element).sendKeys(text).perform();
	}
	
	
	public void takeScreenshot(WebDriver driver, String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File("./errorshot/"+fileName+".png");
		FileHandler.copy(temp, perm);
	}
	
	public void toScrollBy(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
		
	}
}

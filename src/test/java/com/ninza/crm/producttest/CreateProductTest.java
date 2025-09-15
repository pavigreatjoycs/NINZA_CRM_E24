package com.ninza.crm.producttest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ninza.crm.baseclass.BaseClass2;
import com.ninza.crm.generic.fileutility.ExcelFileUtility;
import com.ninza.crm.generic.fileutility.PropertyFileUtility;
import com.ninza.crm.generic.webdriverutility.JavaUtility;
import com.ninza.crm.generic.webdriverutility.WebDriverUtility;
import com.ninza.crm.objectrepository.CreateProductsPage;
import com.ninza.crm.objectrepository.HomePage;
import com.ninza.crm.objectrepository.LoginPage;
import com.ninza.crm.objectrepository.ProductsPage;


public class CreateProductTest extends BaseClass2{

	@Test(groups= {"Smoke","Regression"})
	public void createProductWithMandatoryFieldTest() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();
		
		ProductsPage pp = new ProductsPage(driver);
		pp.getAddProductButton().click();
		Thread.sleep(2000);
		Random random = new Random();
		int rand = jlib.getRandomNumber();
		
		CreateProductsPage cpp = new CreateProductsPage(driver);
		cpp.getProductName().sendKeys(elib.toReadTheDataFromExcel("Product", 1, 1)+rand);
		
		cpp.getQuantity().clear();
		cpp.getQuantity().sendKeys(elib.toReadTheDataFromExcel("Product", 1, 2));
		
		cpp.getPrice().clear();
		cpp.getPrice().sendKeys(elib.toReadTheDataFromExcel("Product", 1, 3));
		
		wlib.select(cpp.getProductCategory(), 1);
		
		
		wlib.select(cpp.getVendorCategory(), 4);
		
		cpp.getAddProductButton().click();
		
		Thread.sleep(2000);
		
		WebElement toastMsg = hp.getToastMsg();
		wlib.waitForVisibilityOfElement(driver, toastMsg);
		
		String text = toastMsg.getText();
		elib.toWriteTheDataToExcelFile("Product", 1, 4, text);
		hp.getCloseToastMsgBtn().click();
		Assert.assertTrue(text.contains("Successfully Added"));
				
	}
}

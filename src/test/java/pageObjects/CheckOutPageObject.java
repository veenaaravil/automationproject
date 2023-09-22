package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablemethods.Base;

public class CheckOutPageObject extends Base {
	WebDriver driver;
	public CheckOutPageObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy (name = "message")public WebElement desc;
	@FindBy (xpath = "//a[text()='Place Order']")public WebElement placeOrderBtn;
	
	// Delivery address
	@FindBy(xpath = "//ul[@class='address item box']")public WebElement deliveryULTag;
	@FindBy (xpath = "//ul[@class='address alternate_item box']")public WebElement billingULTag;

	// Verify delivery address and billing address
	public void verifyDeliveryAndBillingAddress() {
		
		List<WebElement> liDelivery = deliveryULTag.findElements(By.tagName("li"));
		int deliverySize = liDelivery.size();
		
		for(int i=0;i<deliverySize;i++) {
			String username = "Mrs." + readDataFromExcel(15, 2, filePath, sheetNameTest) + " " + readDataFromExcel(15, 3, filePath, sheetNameTest);
			String company = readDataFromExcel(15, 4, filePath, sheetNameTest);
			String address = readDataFromExcel(15, 5, filePath, sheetNameTest);
			String address2 = readDataFromExcel(15, 6, filePath, sheetNameTest);
			String cityStatePostalCode = readDataFromExcel(15, 9, filePath, sheetNameTest) + " " + readDataFromExcel(15, 8, filePath, sheetNameTest) + " " + readDataFromExcel(15, 10, filePath, sheetNameTest);
			String country = readDataFromExcel(15, 7, filePath, sheetNameTest);
			String mobile = readDataFromExcel(15, 11, filePath, sheetNameTest);
			if(liDelivery.get(i).getText()== username) {
				System.out.println("Delivery username is correct");
			}
			if(liDelivery.get(i).getText()==company) {
				System.out.println("Delivery company name is correct");
				
			}
			if(liDelivery.get(i).getText()==address) {
				System.out.println("Delivery address is correct");
				
			}
			if(liDelivery.get(i).getText()==address2) {
				System.out.println("Delivery address2 is correct");
				
			}
			if(liDelivery.get(i).getText()==cityStatePostalCode) {
				System.out.println("Delivery city, state & postalcode is correct");
				
			}
			if(liDelivery.get(i).getText()==country) {
				System.out.println("Delivery country is correct");
				
			}
			if(liDelivery.get(i).getText()==mobile) {
				System.out.println("Delivery mobile is correct");
				
			}
		}
		
		// Verify Billing address
		
		List<WebElement> liBilling = billingULTag.findElements(By.tagName("li"));
		int billingSize = liDelivery.size();
		
		for(int i=0;i<billingSize;i++) {
			String username = "Mrs." + readDataFromExcel(15, 2, filePath, sheetNameTest) + " " + readDataFromExcel(15, 3, filePath, sheetNameTest);
			String company = readDataFromExcel(15, 4, filePath, sheetNameTest);
			String address = readDataFromExcel(15, 5, filePath, sheetNameTest);
			String address2 = readDataFromExcel(15, 6, filePath, sheetNameTest);
			String cityStatePostalCode = readDataFromExcel(15, 9, filePath, sheetNameTest) + " " + readDataFromExcel(15, 8, filePath, sheetNameTest) + " " + readDataFromExcel(15, 10, filePath, sheetNameTest);
			String country = readDataFromExcel(15, 7, filePath, sheetNameTest);
			String mobile = readDataFromExcel(15, 11, filePath, sheetNameTest);
			if(liBilling.get(i).getText()== username) {
				System.out.println("Delivery username is correct");
			}
			if(liBilling.get(i).getText()==company) {
				System.out.println("Delivery company name is correct");
				
			}
			if(liBilling.get(i).getText()==address) {
				System.out.println("Delivery address is correct");
				
			}
			if(liBilling.get(i).getText()==address2) {
				System.out.println("Delivery address2 is correct");
				
			}
			if(liBilling.get(i).getText()==cityStatePostalCode) {
				System.out.println("Delivery city, state & postalcode is correct");
				
			}
			if(liBilling.get(i).getText()==country) {
				System.out.println("Delivery country is correct");
				
			}
			if(liBilling.get(i).getText()==mobile) {
				System.out.println("Delivery mobile is correct");
				
			}
		}
	}
}

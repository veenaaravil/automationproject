package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assertions.AssertionClass;
import reusablemethods.Base;

public class ProductDetailsPageObject extends Base {
	
	WebDriver driver;
	public ProductDetailsPageObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	
	}
	
	// Import other required classes
	AssertionClass asc = new AssertionClass(Base.driver);
		
	@FindBy (id = "quantity")public WebElement quantity;
	@FindBy (xpath = "//button[@class='btn btn-default cart']") public WebElement addToCardBtn;
	
	// Review
	@FindBy (xpath = "//a[text()='Write Your Review']")public WebElement reviewTitle;
	@FindBy (id = "name")public WebElement name;
	@FindBy (id = "email")public WebElement email;
	@FindBy (id = "review")public WebElement review;
	@FindBy (id = "button-review")public WebElement submitBtn;
	@FindBy (xpath = "//span[text()='Thank you for your review.']")public WebElement thankyouForReview;
	
	// Verify Product Details
	@FindBy (xpath = "//div[@class='product-information']/h2")public WebElement prodName;
	@FindBy (xpath = "//div[@class='product-information']/p[contains(text(),'Category')]")public WebElement prodCategory;
	@FindBy (xpath = "//div[@class='product-information']/span/span")public WebElement prodPrice;
	@FindBy (xpath = "//b[contains(text(),'Availability')]/ancestor::p")public WebElement prodAvail;
	@FindBy (xpath = "//b[contains(text(),'Condition')]/ancestor::p")public WebElement prodCondition;
	@FindBy (xpath = "//b[contains(text(),'Brand')]/ancestor::p")public WebElement prodBrand;
	
	
	// Validate product details
	public void validateFirstProductDetails() {	
		String expectedProductName = "Blue Top";
		asc.innerTextEquals(prodName, expectedProductName);
			
		String expectedProductCategory = "Category: Women > Tops";
		asc.innerTextEquals(prodCategory, expectedProductCategory);
				
		String expectedProductPrice = "Rs. 500";
		asc.innerTextEquals(prodPrice, expectedProductPrice);
				
		String expectedProductAvailability = "Availability: In Stock";
		asc.innerTextEquals(prodAvail, expectedProductAvailability);
				
		String expectedProductCondition = "Condition: New";
		asc.innerTextEquals(prodCondition, expectedProductCondition);
				
		String expectedProductBrand = "Brand: Polo";
		asc.innerTextEquals(prodBrand, expectedProductBrand);	
	}
	// Submit review
	public void submitReview() {
		WebElement actualProdReview = reviewTitle;
		String expectedProdReview = "WRITE YOUR REVIEW";
		asc.innerTextEquals(actualProdReview, expectedProdReview);
		
		name.sendKeys(readDataFromExcel(39, 2, filePath, sheetNameTest));
		email.sendKeys(readDataFromExcel(39, 3, filePath, sheetNameTest));
		review.sendKeys(readDataFromExcel(39, 3, filePath, sheetNameTest));
		submitBtn.click();
		
		WebElement actualThankyouReview = thankyouForReview;
		String expectedThankyouReview = "Thank you for your review.";
		asc.innerTextEquals(actualThankyouReview, expectedThankyouReview);
	}
}

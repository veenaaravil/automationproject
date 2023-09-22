package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assertions.AssertionClass;
import reusablemethods.Base;

public class CartPageObject {
	
	WebDriver driver;
	public CartPageObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	
	}
	
	// Import other required classes
	AssertionClass asc = new AssertionClass(Base.driver);
	
	@FindBy (xpath = "//a[text()='Proceed To Checkout']")public WebElement proceedToCheckoutBtn;
	@FindBy (xpath = "//u[text()='Register / Login']")public WebElement regOrLoginBtn;
	
	// Quantity = 4
	@FindBy (xpath = "//button[@class='disabled' and text()='1']")public WebElement quantity4;

	// First product details in cart
	@FindBy (xpath = "//button[@class='disabled' and text()='1']")public List<WebElement> quantity;
	@FindBy (xpath = "//p[text()='Rs. 500']")public WebElement price;
	@FindBy (xpath = "//img[@src='get_product_picture/1']")public WebElement prodImage;
	@FindBy (xpath = "//p[text()='Women > Tops']")public WebElement prodCategory;
	@FindBy (xpath = "//a[text()='Blue Top']")public WebElement prodName;
	@FindBy (xpath = "//p[@class='cart_total_price' and text()='Rs. 500']")public WebElement totalPrice;
	@FindBy (xpath = "//a[@class='cart_quantity_delete' and @data-product-id='1']/i")public WebElement deleteItems;

	@FindBy (xpath = "//p[@class='text-center']")public WebElement emptyCart;
	// Second product details in cart
	
	@FindBy (xpath = "//p[text()='Rs. 400']")public WebElement secPrice;
	@FindBy (xpath = "//img[@src='get_product_picture/2']")public WebElement SecProdImage;
	@FindBy (xpath = "//p[text()='Men > Tshirts']")public WebElement secProdCategory;
	@FindBy (xpath = "//a[text()='Men Tshirt']")public WebElement secProdName;
	@FindBy (xpath = "//p[@class='cart_total_price' and text()='Rs. 400']")public WebElement secTotalPrice;
	@FindBy (xpath = "//a[@class='cart_quantity_delete' and @data-product-id='2']/i")public WebElement secDeleteItems;
	// Table info
	@FindBy (id = "cart_info_table")public WebElement table;
	@FindBy (xpath = "//table/tbody")public WebElement tbody;
	@FindBy (tagName = "tr")public By tr;
	
	// Search products and add to cart and verify products are present in cart after login
	@FindBy (xpath = "//a[text()='Summer White Top']")public WebElement prod1;
	@FindBy (xpath = "//a[text()='Sleeves Printed Top - White']")public WebElement prod2;
	@FindBy (xpath = "//a[text()='Printed Off Shoulder Top - White']")public WebElement prod3;

	// Verify products
	
	public void verifyProducts() {
		// Verify first product
		WebElement actualPrice = price;
		String expectedPrice = "Rs. 500";
		asc.innerTextEquals(actualPrice, expectedPrice);
				
		asc.elementAvailable(prodImage, true);
				
		WebElement actualProdCategory = prodCategory;
		String expectedProdCategory = "Women > Tops";
		asc.innerTextEquals(actualProdCategory, expectedProdCategory);
				
		WebElement actualProdName = prodName;
		String expectedProdName = "Blue Top";
		asc.innerTextEquals(actualProdName, expectedProdName);
				
		WebElement actualTotal = totalPrice;
		String expectedTotal = "Rs. 500";
		asc.innerTextEquals(actualTotal, expectedTotal);
				
		// Verify second product
		WebElement secondProdActualPrice = secPrice;
		String secondProdexpectedPrice = "Rs. 400";
		asc.innerTextEquals(secondProdActualPrice, secondProdexpectedPrice);
						
		asc.elementAvailable(SecProdImage, true);
						
		WebElement secondProdactualProdCategory = secProdCategory;
		String secondProdexpectedProdCategory = "Men > Tshirts";
		asc.innerTextEquals(secondProdactualProdCategory, secondProdexpectedProdCategory);
						
		WebElement secondProdactualProdName = secProdName;
		String secondProdexpectedProdName = "Men Tshirt";
		asc.innerTextEquals(secondProdactualProdName, secondProdexpectedProdName);
						
		WebElement secondProdactualTotal = secTotalPrice;
		String secondProdexpectedTotal = "Rs. 400";
		asc.innerTextEquals(secondProdactualTotal, secondProdexpectedTotal);
				
		for(WebElement data: quantity) {
			String expectedQuantity = "1";
			asc.innerTextEquals(data, expectedQuantity);
		}
	}
	
	public void verifyFirstProduct() {
		// Verify first product
		WebElement actualPrice = price;
		String expectedPrice = "Rs. 500";
		asc.innerTextEquals(actualPrice, expectedPrice);
						
		asc.elementAvailable(prodImage, true);
						
		WebElement actualProdCategory = prodCategory;
		String expectedProdCategory = "Women > Tops";
		asc.innerTextEquals(actualProdCategory, expectedProdCategory);
						
		WebElement actualProdName = prodName;
		String expectedProdName = "Blue Top";
		asc.innerTextEquals(actualProdName, expectedProdName);
						
		WebElement actualTotal = totalPrice;
		String expectedTotal = "Rs. 500";
		asc.innerTextEquals(actualTotal, expectedTotal);
	}
	
	

}


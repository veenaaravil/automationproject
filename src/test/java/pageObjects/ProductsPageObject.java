package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import assertions.AssertionClass;
import reusablemethods.Base;

public class ProductsPageObject {

	WebDriver driver;

	public ProductsPageObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	SignUpFormObject page3 = new SignUpFormObject(Base.driver);

	// Import other required classes
	AssertionClass asc = new AssertionClass(Base.driver);

	@FindBy(id = "search_product")
	public WebElement searchProdText;
	@FindBy(xpath = "//i[@class='fa fa-search']")
	public WebElement searchIcon;
	@FindBy(xpath = "//h2[text()='Searched Products']")
	public WebElement searchedProductsTitle;
	@FindBy(xpath = "//div[@class='product-overlay']/div/p[contains(text(),'Blue Top')]")
	public WebElement searchResults;

	// Add first and second product to cart

	@FindBy(xpath = "//a[@data-product-id='1']/preceding-sibling::img")
	public WebElement firstProdHover;
	@FindBy(xpath = "//div[@class='overlay-content']//a[@data-product-id='1']")
	public WebElement firstProdAddToCart;
	@FindBy(xpath = "//a[@data-product-id='2']/preceding-sibling::img")
	public WebElement secondProdHover;
	@FindBy(xpath = "//div[@class='overlay-content']//a[@data-product-id='2']")
	public WebElement secondProdAddToCart;

	@FindBy(xpath = "//button[text()='Continue Shopping']")
	public WebElement continueShoppingBtn;
	@FindBy(xpath = "//u[text()='View Cart']")
	public WebElement viewCartBtn;

	// All searched products
	@FindBy(xpath = "//img[@src='/get_product_picture/6']/following-sibling::p[text()='Summer White Top']")
	public WebElement summerWhiteTop;
	@FindBy(xpath = "//img[@src='/get_product_picture/11']/following-sibling::p[text()='Sleeves Printed Top - White']")
	public WebElement sleevelessPrintedTop;
	@FindBy(xpath = "//img[@src='/get_product_picture/15']/following-sibling::p[text()='Printed Off Shoulder Top - White']")
	public WebElement printedOffTop;

	// All searched products are added to list and add all elements into cart
	@FindBy(xpath = "//div[@class='product-overlay']")
	public List<WebElement> allProdHover;
	@FindBy(xpath = "//a[text()='Add to cart']")
	public WebElement addToCartBtn;
	@FindBy(xpath = "//a[@href='/product_details/1']")
	public WebElement prodDetailsBtn;
	@FindBy(xpath = "//h2[text()='All Products']")
	public WebElement allProductsTitle;

	// Brands
	@FindBy(xpath = "//h2[text()='Brands']")
	public WebElement brandText;
	@FindBy(xpath = "//a[@href='/brand_products/Polo']")
	public WebElement poloBrand;

	// Verify product page
	public void verifyProductPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.urlToBe("https://automationexercise.com/#google_vignette"));
		} catch (Exception e) {
			System.out.println(e);
		}
		String url = driver.getCurrentUrl();
		if (url.equals("https://automationexercise.com/#google_vignette") == true) {
			page3.closeGoogleAdd();
			page3.closeGoogleAddDismissBtn();
		}

		page3.closeAdd();
		// Verify all products page
		String expectedProdUrl = "https://automationexercise.com/products";
		asc.urlEquals(expectedProdUrl);

		String expectedProdTitle = "Automation Exercise - All Products";
		asc.titleEquals(expectedProdTitle);
	}

	// Search product page
	public void searchProducts(String prodName) {

		// Search products
		searchProdText.sendKeys(prodName);
		searchIcon.click();

		// Verify searched products
		String expectedSearchedProdText = "SEARCHED PRODUCTS";
		asc.innerTextEquals(searchedProductsTitle, expectedSearchedProdText);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(searchResults));
		asc.elementAvailable(searchResults, true);
		asc.elementEnabled(searchResults, true);
	}

	// Add first and second products to cart

	public void addFirstAndSecondProductsToCart() {
		// Add first product to cart
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Actions a = new Actions(driver);
		a.moveToElement(firstProdHover).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(firstProdAddToCart));
		firstProdAddToCart.click();
		wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn));
		continueShoppingBtn.click();

		// Add second product to cart
		a.moveToElement(secondProdHover).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(secondProdAddToCart));
		secondProdAddToCart.click();
		wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn));
		viewCartBtn.click();
	}

	public void addFirstProductToCart() {
		// Add first product to cart
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Actions a = new Actions(driver);
		a.moveToElement(firstProdHover).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(firstProdAddToCart));
		firstProdAddToCart.click();
		wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn));
		continueShoppingBtn.click();
	}

	public void verifySearchResults() {
		WebElement actualSummerWhite = summerWhiteTop;
		String expectedSummerWhite = "Summer White Top";
		asc.innerTextEquals(actualSummerWhite, expectedSummerWhite);

		WebElement actualsleevelessWhite = sleevelessPrintedTop;
		String expectedsleevelessWhite = "Sleeves Printed Top - White";
		asc.innerTextEquals(actualsleevelessWhite, expectedsleevelessWhite);

		WebElement actualprintedOffTop = printedOffTop;
		String expectedslprintedOffTop = "Printed Off Shoulder Top - White";
		asc.innerTextEquals(actualprintedOffTop, expectedslprintedOffTop);
	}

}

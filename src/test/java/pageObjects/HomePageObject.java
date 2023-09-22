package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import assertions.AssertionClass;
import reusablemethods.Base;

public class HomePageObject extends Base{
	
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	// Import other required classes
	AssertionClass asc = new AssertionClass(Base.driver);

	
	@FindBy (xpath = "//i[@class='fa fa-home']")public WebElement homeIcon;
	@FindBy (xpath = "//a[@href='/products']")public WebElement productLink;
	@FindBy (xpath = "//i[@class='fa fa-shopping-cart']/ancestor::a[@href='/view_cart']") public WebElement cartLink;
	@FindBy (xpath = "//a[@href='/contact_us']")public WebElement contactUsLink;
	@FindBy (xpath = "//i[@class='fa fa-list']/ancestor::a[@href='/test_cases']")public WebElement testcaseLink;
	@FindBy (xpath = "//a[@href='/login']")public WebElement loginLink;
	@FindBy (xpath = "//a[@href='/api_list']")public WebElement apiLink;
	@FindBy (xpath = "//a[@href='https://www.youtube.com/c/AutomationExercise']")public WebElement videoLink;


	// Images
	@FindBy (xpath = "//img[@src='/static/images/home/logo.png']")public WebElement autoExImage;
	@FindBy (xpath = "//img[@src='/static/images/home/girl2.jpg']/ancestor::div[@class='col-sm-6']/preceding-sibling::div//h2")public WebElement fullFledgeText;
	@FindBy (xpath = "//img[@src='/static/images/home/girl1.jpg']")public WebElement girl1Img;
	@FindBy (xpath = "//img[@src='/static/images/home/girl2.jpg']")public WebElement girl2Img;
	@FindBy (xpath = "//img[@src='/static/images/home/girl3.jpg']")public WebElement girl3Img;
	
	// Footer locators
	@FindBy (xpath = "//h2[text()='Subscription']")public WebElement subscription;
	@FindBy (id = "susbscribe_email")public WebElement subEmail;
	@FindBy (id = "subscribe")public WebElement subscribeBtn;
	@FindBy (xpath = "//div[text()='You have been successfully subscribed!']")public WebElement subscriptionAlert;
	
	// Scoll arrow
	@FindBy (xpath = "//a[@href='#slider-carousel']/i[@class='fa fa-angle-left']")public WebElement leftScroll;
	@FindBy (xpath = "//a[@href='#slider-carousel']/i[@class='fa fa-angle-right']")public WebElement rightScroll;
	@FindBy (xpath = "//i[@class='fa fa-angle-up']")public WebElement scrollArrow;

	// Products
	@FindBy (xpath = "//div[@class='features_items']//div[@class='productinfo text-center']//p[text()='Blue Top']")public WebElement hoverFirstProduct;
	@FindBy (xpath = "//div[@class='features_items']//div[@class='productinfo text-center']//p[text()='Men Tshirt']")public WebElement hoverSecondProduct;
	
	@FindBy (xpath = "//div[@class='features_items']//div[@class='productinfo text-center']//a[@data-product-id='1']")public WebElement addToCartFirstProd;
	@FindBy (xpath = "//div[@class='features_items']//div[@class='productinfo text-center']//a[@data-product-id='2']")public WebElement addToCartSecondProd;
	
	@FindBy (xpath = "//button[text()='Continue Shopping']")public WebElement continueShoppingBtn;
	@FindBy (xpath = "//u[text()='View Cart']")public WebElement viewCartBtn;
	@FindBy (xpath = "//a[@href='/product_details/1']")public WebElement prodDetailsBtn;

	// Recommended Items
	@FindBy (xpath = "//h2[text()='recommended items']")public WebElement recommendedTitle;
	@FindBy (xpath = "//div[@class='recommended_items']//div[@class='productinfo text-center']//a[@data-product-id='1']")public WebElement addToCartRecommendedProd;;
	
	
	// Category
	@FindBy (xpath = "//h2[text()='Category']")public WebElement category;
	@FindBy (xpath = "//a[@href='#Women']")public WebElement womenCategory;
	@FindBy (xpath = "//a[@href='/category_products/1' and text()='Dress ']")public WebElement womenSubCat;

	
	// Sub Titles
	@FindBy (xpath = "//h2[text()='Features Items']")public WebElement featured_items;
	@FindBy (xpath = "//h2[text()='Brands']")public WebElement brands;
	
	// Frame
	@FindBy (id = "aswift_0")public WebElement frameId0;
	// Add close button 
	@FindBy (css = "path[d='M3.25,3.25l8.5,8.5M11.75,3.25l-8.5,8.5']")public List<WebElement> addCloseBtn;

	
	// Header elements
	
	@FindBy(xpath = "//a[@href='/logout']") public WebElement logoutBtn;
	@FindBy(xpath = "//a[@href='/delete_account']")public WebElement deleteAccBtn;
	@FindBy(xpath = "//b[text()='Account Deleted!']")public WebElement deleteAccSuccess;
	@FindBy(xpath = "//a[contains(text(),' Logged in as ')]")public WebElement loggedinAsUser;
	
	// Validate home page
	public void validateHomePageAndNavigateToLoginPage() {
		// Validate homepage is sucessfully loaded.
		asc.elementAvailable(homeIcon, true);
		asc.elementEnabled(homeIcon, true);
				
		String expectedUrl = "https://automationexercise.com/";
		asc.urlEquals(expectedUrl);
				
		String expectedTitle = "Automation Exercise";
		asc.titleEquals(expectedTitle);
		loginLink.click();			
	}
	
	// Validate home page
	public void validateHomePage() {
		// Validate homepage is sucessfully loaded.
		asc.elementAvailable(homeIcon, true);
		asc.elementEnabled(homeIcon, true);
				
		String expectedUrl = "https://automationexercise.com/";
		asc.urlEquals(expectedUrl);
				
		String expectedTitle = "Automation Exercise";
		asc.titleEquals(expectedTitle);	
	}
	
	// Logged in as user validation
	public void loggedInAsUser() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(loggedinAsUser));
		String expectedloggedinAsUserText = "Logged in as Veena";
		asc.innerTextEquals(loggedinAsUser, expectedloggedinAsUserText);
	}
	// Delete account
	public void deleteAccount() {
		// Delete account	
		deleteAccBtn.click();
		String expectedDeleteAccText = "ACCOUNT DELETED!";
		asc.innerTextEquals(deleteAccSuccess, expectedDeleteAccText);	
	}
	
	public void submitSubscription() {
		WebElement actualSubscriptionText = subscription;
		String expectedSubscriptionText = "SUBSCRIPTION";
		asc.innerTextEquals(actualSubscriptionText, expectedSubscriptionText);
		
		subEmail.sendKeys(readDataFromExcel(3, 3,filePath, sheetNameTest));
		subscribeBtn.click();
		
		WebElement actualSubscriptionSuccess = subscriptionAlert;
		String expectedSubscriptionSuccess = "You have been successfully subscribed!";
		asc.innerTextEquals(actualSubscriptionSuccess, expectedSubscriptionSuccess);
	}
	
}

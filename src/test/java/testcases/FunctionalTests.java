package testcases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import assertions.AssertionClass;
import pageObjects.BrandDetailPageObject;
import pageObjects.CartPageObject;
import pageObjects.CategoryDetailPageObject;
import pageObjects.CheckOutPageObject;
import pageObjects.ContactUsPageObject;
import pageObjects.HomePageObject;
import pageObjects.PaymentConfirmationPageObject;
import pageObjects.PaymentPageObject;
import pageObjects.ProductDetailsPageObject;
import pageObjects.ProductsPageObject;
import pageObjects.SignUpAndLoginPageObject;
import pageObjects.SignUpFormObject;
import reusablemethods.Base;

public class FunctionalTests extends Base {

	/*
	 * Application : Automation Exercise Module: HomePage
	 * @author: Veena K 
	 * It has all the functional test cases
	 * It will cover all the functional test cases & UI test cases of home page
	 */

	// Import pageobject classes
	HomePageObject page1 = new HomePageObject(Base.driver);
	SignUpAndLoginPageObject page2 = new SignUpAndLoginPageObject(Base.driver);
	SignUpFormObject page3 = new SignUpFormObject(Base.driver);
	ContactUsPageObject page4 = new ContactUsPageObject(Base.driver);
	ProductsPageObject page5 = new ProductsPageObject(Base.driver);
	ProductDetailsPageObject page6 = new ProductDetailsPageObject(Base.driver);
	CartPageObject page7 = new CartPageObject(Base.driver);
	CheckOutPageObject page8 = new CheckOutPageObject(Base.driver);
	PaymentPageObject page9 = new PaymentPageObject(Base.driver);
	PaymentConfirmationPageObject page10 = new PaymentConfirmationPageObject(Base.driver);
	CategoryDetailPageObject page11 = new CategoryDetailPageObject(Base.driver);
	BrandDetailPageObject page12 = new BrandDetailPageObject(Base.driver);
	
	// Import other required classes
	AssertionClass asc = new AssertionClass(Base.driver);

	@BeforeTest
	public void setup() {
		launchApp();
	}

	@BeforeMethod
	public void setupBeforeMethod() {
		driver.navigate().to(readDataFromExcel(1, 1, filePath, sheetName));
		page3.closeAdd();
	}

	@Test(priority = 0, description = "Test Case 1: Register User")
	public void registerUser() {

		// Validate homepage is sucessfully loaded.
		page1.validateHomePageAndNavigateToLoginPage();
		page2.signUp(readDataFromExcel(3, 2, filePath, sheetNameTest),
				readDataFromExcel(3, 3, filePath, sheetNameTest));
		page3.submitSignUpForm();
		page1.loggedInAsUser();

		// Delete account
		page1.deleteAccount();
		page3.clickContinueBtn();
	}

	@Test(priority = 1, description = "Test Case 2: Login User with correct email and password")
	public void loginUserWithValidEmail() {

		// Validate homepage is sucessfully loaded.
		page1.validateHomePageAndNavigateToLoginPage();

		// Login with valid email and password
		page2.login(readDataFromExcel(3, 3, filePath, sheetNameTest), readDataFromExcel(9, 3, filePath, sheetNameTest));
		page1.loggedInAsUser();

		// Delete account
		page1.deleteAccount();
	}

	@Test(priority = 2, description = "Test Case 3: Login User with incorrect email and password")
	public void loginUserWithInvalidEmailAndPassword() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePageAndNavigateToLoginPage();

		// Login with invalid email and password
		page2.login(readDataFromExcel(20, 2, filePath, sheetNameTest),
				readDataFromExcel(20, 3, filePath, sheetNameTest));

		WebElement actualWrongEmail = page2.incorrectEmailOrPwd;
		String expectedWrongEmailText = "Your email or password is incorrect!";
		asc.innerTextEquals(actualWrongEmail, expectedWrongEmailText);
	}

	@Test(priority = 3, description = "Test Case 4: Logout User")
	public void logoutUser() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePageAndNavigateToLoginPage();

		// Login with valid email and password
		page2.login(readDataFromExcel(3, 3, filePath, sheetNameTest), readDataFromExcel(9, 3, filePath, sheetNameTest));
		page1.loggedInAsUser();

		// Logout user
		page1.logoutBtn.click();

		String loginUrl = "https://automationexercise.com/login";
		asc.urlEquals(loginUrl);
		String expectedLoginTitle = "Automation Exercise - Signup / Login";
		asc.titleEquals(expectedLoginTitle);
	}

	@Test(priority = 4, description = "Test Case 5: Register User with existing email")
	public void registerUserWithExistingEmail() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePageAndNavigateToLoginPage();
		page2.signUp(readDataFromExcel(3, 2, filePath, sheetNameTest),
				readDataFromExcel(3, 3, filePath, sheetNameTest));

		WebElement actualEmailExistingError = page2.existingEmailError;
		String expectedEmailExistingError = "Email Address already exist!";
		asc.innerTextEquals(actualEmailExistingError, expectedEmailExistingError);
	}

	@Test(priority = 5, description = "Test Case 6: Contact Us Form")
	public void submitContactUsForm() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePage();

		// Click on contactus page
		page1.contactUsLink.click();

		// Close adds
		page3.closeAdd();

		// Submit contactus form
		page4.submitContactUs();
		String url = driver.getCurrentUrl();
		if (url.equals("https://automationexercise.com/contact_us#google_vignette") == true) {
			page3.closeGoogleAdd();
			page3.closeGoogleAddDismissBtn();
		}
		page1.validateHomePage();

	}

	@Test(priority = 6, description = "Test Case 7: Verify Test Cases Page")
	public void validateTestCasePage() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePage();

		// Click on testcasepage link
		page1.testcaseLink.click();

		String url = driver.getCurrentUrl();
		if (url.equals("https://automationexercise.com/#google_vignette") == true) {
			page3.closeGoogleAdd();
			page3.closeGoogleAddDismissBtn();
		}

		String expectedTestCaseUrl = "https://automationexercise.com/test_cases";
		asc.urlEquals(expectedTestCaseUrl);

		String expectedTestCaseTitle = "Automation Practice Website for UI Testing - Test Cases";
		asc.titleEquals(expectedTestCaseTitle);
	}

	@Test(priority = 7, description = "Test Case 8: Verify All Products and product detail page")
	public void validateProductsAndProductDetailPage() throws Exception {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePage();

		// Click on products link
		page1.productLink.click();

		// Verify product page
		page5.verifyProductPage();

		// Scroll down till the first product view details button
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", page5.prodDetailsBtn);

		page5.prodDetailsBtn.click();

		page6.validateFirstProductDetails();

	}

	@Test(priority = 8, description = "Test Case 9: Search Product")
	public void searchProducts() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePage();

		// Click on products link
		page1.productLink.click();

		// Verify product page
		page5.verifyProductPage();

		// Search products and verify the results
		page5.searchProducts("blue top");

	}

	@Test(priority = 9, description = "Test Case 10: Verify Subscription in home page")
	public void verifySubscriptionInHome() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePage();
		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// Verify text "Subscription"
		page1.submitSubscription();

	}

	@Test(priority = 10, description = "Test Case 11: Verify Subscription in Cart page")
	public void verifySubscriptionInCartPage() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePage();

		// Click on cart page
		page1.cartLink.click();

		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// Verify text "Subscription"
		page1.submitSubscription();
	}

	@Test(priority = 11, description = "Test Case 12: Add Products in Cart")
	public void addProductsInCart() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePage();

		// Click on products link
		page1.productLink.click();

		// Verify Product page
		page5.verifyProductPage();

		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(100,500)");

		page3.closeAdd();
		// Add first product to cart
		page5.addFirstAndSecondProductsToCart();
		page3.closeAdd();

		page7.verifyProducts();
	}

	@Test(priority = 12, description = "Test Case 13: Verify Product quantity in Cart")
	public void verifyProductQuantityInCart() throws Exception {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePage();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		page3.closeAdd();
		String url = driver.getCurrentUrl();
		if (url.equals("https://automationexercise.com/#google_vignette") == true) {
			page3.closeGoogleAdd();
			page3.closeGoogleAddDismissBtn();
		}

		page1.prodDetailsBtn.click();
		page6.quantity.sendKeys("4");
		wait.until(ExpectedConditions.elementToBeClickable(page6.addToCardBtn));
		page6.addToCardBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(page5.viewCartBtn));
		page5.viewCartBtn.click();
		WebElement actualQ4 = page7.quantity4;
		String expectedQ4 = "4";
		asc.innerTextEquals(actualQ4, expectedQ4);
	}

	@Test(priority = 13, description = "Test Case 14: Place Order: Register while Checkout")
	public void placeOrderRegisterWhileCheckout() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePage();

		// Add first product to cart
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));

		page5.addFirstProductToCart();

		page1.cartLink.click();
		String expectedCartUrl = "https://automationexercise.com/view_cart";
		asc.urlEquals(expectedCartUrl);

		page7.proceedToCheckoutBtn.click();

		wait2.until(ExpectedConditions.elementToBeClickable(page7.regOrLoginBtn));
		page7.regOrLoginBtn.click();

		String email = getRandomEmail() + "@d3.com";
		page2.signUp(readDataFromExcel(3, 2, filePath, sheetNameTest), email);
		page3.submitSignUpForm();
		page1.loggedInAsUser();

		page1.cartLink.click();
		page7.proceedToCheckoutBtn.click();

		page8.desc.sendKeys("Proceed order");
		page8.placeOrderBtn.click();

		// Enter payment details
		page9.submitPayment();

		// Delete account
		page1.deleteAccount();
		page3.clickContinueBtn();
	}

	@Test(priority = 14, description = "Test Case 15: Place Order: Register before Checkout")
	public void placeOrderRegisterBeforeCheckout() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePageAndNavigateToLoginPage();

		String email = getRandomEmail() + "@d3.com";
		page2.signUp(readDataFromExcel(3, 2, filePath, sheetNameTest), email);
		page3.submitSignUpForm();
		page1.loggedInAsUser();

		// Add first product to cart
		page5.addFirstProductToCart();

		page1.cartLink.click();
		page7.proceedToCheckoutBtn.click();

		page8.desc.sendKeys("Proceed order");
		page8.placeOrderBtn.click();

		// Enter payment details
		page9.submitPayment();

		// Delete account
		page1.deleteAccount();
		page3.clickContinueBtn();

	}

	@Test(priority = 15, description = "Test Case 16: Place Order: Login before Checkout")
	public void placeOrderLoginBeforeCheckout() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePageAndNavigateToLoginPage();

		// Login with valid email and password
		page2.login(readDataFromExcel(3, 3, filePath, sheetNameTest), readDataFromExcel(9, 3, filePath, sheetNameTest));
		page1.loggedInAsUser();

		// Add first product to cart
		page5.addFirstProductToCart();

		page1.cartLink.click();
		page7.proceedToCheckoutBtn.click();

		page8.desc.sendKeys("Proceed order");
		page8.placeOrderBtn.click();

		// Enter payment details
		page9.submitPayment();

		// Delete account
		page1.deleteAccount();
		page3.clickContinueBtn();

	}

	@Test(priority = 16, description = "Test Case 17: Remove Products From Cart")
	public void removeProducstFromCart() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePage();

		page5.addFirstProductToCart();

		page1.cartLink.click();

		String cartUrl = "https://automationexercise.com/view_cart";
		asc.urlEquals(cartUrl);

		String expectedCartText = "Automation Exercise - Checkout";
		asc.titleEquals(expectedCartText);

		page7.deleteItems.click();
		driver.navigate().refresh();
		String expectedEmptyCartText = "Cart is empty! Click here to buy products.";
		asc.innerTextEquals(page7.emptyCart, expectedEmptyCartText);

	}

	@Test(priority = 17, description = "Test Case 18: View Category Products")
	public void viewCategoryProducts() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePage();

		WebElement categry = page1.category;
		asc.elementAvailable(categry, true);

		String expectedCategory = "CATEGORY";
		asc.innerTextEquals(categry, expectedCategory);

		page1.womenCategory.click();
		page1.womenSubCat.click();

		WebElement actualWomenCatTitle = page11.womenCatTitle;
		String expectedWomenCatTitle = "WOMEN - DRESS PRODUCTS";
		asc.innerTextEquals(actualWomenCatTitle, expectedWomenCatTitle);

		page11.menCategory.click();
		page11.menSubCat.click();

		WebElement actualmenCatTitle = page11.menCatTitle;
		String expectedmenCatTitle = "MEN - JEANS PRODUCTS";
		asc.innerTextEquals(actualmenCatTitle, expectedmenCatTitle);

	}

	@Test(priority = 18, description = "Test Case 19: View & Cart Brand Products")
	public void viewAndCartBrandProducts() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePage();

		page1.productLink.click();

		WebElement actualBrandTitle = page5.brandText;
		String expectedBrandTitle = "Brands";
		asc.innerTextEquals(actualBrandTitle, expectedBrandTitle);

		page5.poloBrand.click();

		WebElement actualPoloBrandTitle = page12.brandPoloTitle;
		String expectedPoloBrandTitle = "Brand - Polo Products";
		asc.innerTextEquals(actualPoloBrandTitle, expectedPoloBrandTitle);

		page12.madmeBrand.click();

		WebElement actualMadmeBrandTitle = page12.brandMadmeTitle;
		String expectedMadmeBrandTitle = "Brand - Madame Products";
		asc.innerTextEquals(actualMadmeBrandTitle, expectedMadmeBrandTitle);
	}

	@Test(priority = 19, description = "Test Case 20: Search Products and Verify Cart After Login")
	public void searchProductsAndVerifyCartAfterLogin(){
		// Validate homepage is sucessfully loaded.
		page1.validateHomePage();
		page1.productLink.click();
		// Verify product page
		page5.verifyProductPage();

		// Search products and verify the results
		page5.searchProducts("white");

		// Verify search results
		page5.verifySearchResults();

		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(100,500)");

		page3.closeAdd();

		// Add first product to cart
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		page5.addFirstProductToCart();

		for (WebElement data : page5.allProdHover) {
			Actions a = new Actions(driver);
			a.moveToElement(data).build().perform();
			wait.until(ExpectedConditions.elementToBeClickable(data));
			page5.addToCartBtn.click();
			if (page5.continueShoppingBtn.isDisplayed() == true) {
				wait.until(ExpectedConditions.elementToBeClickable(page5.continueShoppingBtn));
				page5.continueShoppingBtn.click();
			} else {
				page1.cartLink.click();
			}
			// Verify products are present in cart before login

			asc.elementAvailable(page7.prod1, true);
			asc.elementAvailable(page7.prod2, true);
			asc.elementAvailable(page7.prod3, true);
			page1.cartLink.click();
			page2.login(readDataFromExcel(3, 3, filePath, sheetNameTest),
					readDataFromExcel(9, 3, filePath, sheetNameTest));
			page1.cartLink.click();

			// Verify products are present in cart after login

			asc.elementAvailable(page7.prod1, true);
			asc.elementAvailable(page7.prod2, true);
			asc.elementAvailable(page7.prod3, true);
		}
	}

	@Test(priority = 20, description = "Test Case 21: Add review on product")
	public void addReviewOnProducts() throws Exception {
		// Validate products and product details
		validateProductsAndProductDetailPage();

		// Add review
		page6.submitReview();

	}

	@Test(priority = 21, description = "Test Case 22: Add to cart from Recommended items")
	public void addToCartFromRecommendedItems() {
		// Validate home page
		page1.validateHomePage();
		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(505,7583)");

		page3.closeAdd();

		WebElement actualRecommendedItems = page1.recommendedTitle;
		String expectedRecommendedItems = "RECOMMENDED ITEMS";
		asc.innerTextEquals(actualRecommendedItems, expectedRecommendedItems);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOf(page1.addToCartRecommendedProd));
		wait.until(ExpectedConditions.elementToBeClickable(page1.addToCartRecommendedProd));
		page1.addToCartRecommendedProd.click();
		wait.until(ExpectedConditions.elementToBeClickable(page5.viewCartBtn));
		page5.viewCartBtn.click();

		// Verify first product
		page7.verifyFirstProduct();
	}

	@Test(priority = 22, description = "Test Case 23: Verify address details in checkout page")
	public void verifyAddressInCheckoutPage() {
		// Validate home page
		page1.validateHomePageAndNavigateToLoginPage();

		String email = getRandomEmail() + "@d3.com";
		page2.signUp(readDataFromExcel(3, 2, filePath, sheetNameTest), email);
		page3.submitSignUpForm();
		page1.loggedInAsUser();

		// Add first product to cart
		page5.addFirstProductToCart();

		page1.cartLink.click();
		page7.proceedToCheckoutBtn.click();

		// Verify delivery address
		page8.verifyDeliveryAndBillingAddress();

		page8.desc.sendKeys("Proceed order");
		page8.placeOrderBtn.click();

		// Enter payment details
		page9.submitPayment();
		// Delete account
		page1.deleteAccount();
		page3.clickContinueBtn();

	}

	@Test(priority = 23, description = "Test Case 24: Download Invoice after purchase order")
	public void downloadInvoiceAfterPurchaseOrder() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePage();

		// Add first product to cart
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		page5.addFirstProductToCart();

		page1.cartLink.click();
		String expectedCartUrl = "https://automationexercise.com/view_cart";
		asc.urlEquals(expectedCartUrl);

		page7.proceedToCheckoutBtn.click();

		wait.until(ExpectedConditions.elementToBeClickable(page7.regOrLoginBtn));
		page7.regOrLoginBtn.click();

		String email = getRandomEmail() + "@d3.com";
		page2.signUp(readDataFromExcel(3, 2, filePath, sheetNameTest), email);
		page3.submitSignUpForm();
		page1.loggedInAsUser();

		page1.cartLink.click();
		page7.proceedToCheckoutBtn.click();

		page8.desc.sendKeys("Proceed order");
		page8.placeOrderBtn.click();

		// Enter payment details
		page9.submitPayment();

		page10.downloadInvoiceBtn.click();
		page10.continueBtn.click();

		// Delete account
		page1.deleteAccount();
		page3.clickContinueBtn();
	}

	@Test(priority = 24, description = "Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
	public void verifyScrollUpUsingArrowButtonAndScrollDown() {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePage();

		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// Verify text "Subscription"

		WebElement actualSubscriptionText = page1.subscription;
		String expectedSubscriptionText = "SUBSCRIPTION";
		asc.innerTextEquals(actualSubscriptionText, expectedSubscriptionText);

		page1.scrollArrow.click();

		WebElement actualfullFledgeText = page1.fullFledgeText;
		String expectedfullFledgeText = "Full-Fledged practice website for Automation Engineers";
		asc.innerTextEquals(actualfullFledgeText, expectedfullFledgeText);
		asc.elementAvailable(page1.fullFledgeText, true);

	}

	@Test(priority = 25, description = "Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality")
	public void verifyScrollUpWithoutArrowButtonAndScrollDown() throws Exception {
		// Validate homepage is sucessfully loaded.
		page1.validateHomePage();

		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// Verify text "Subscription"

		WebElement actualSubscriptionText = page1.subscription;
		String expectedSubscriptionText = "SUBSCRIPTION";
		asc.innerTextEquals(actualSubscriptionText, expectedSubscriptionText);

		// Scroll up
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

		WebElement actualfullFledgeText = page1.fullFledgeText;
		String expectedfullFledgeText = "Full-Fledged practice website for Automation Engineers";
		asc.innerTextEquals(actualfullFledgeText, expectedfullFledgeText);
		asc.elementAvailable(page1.fullFledgeText, true);

	}

	@AfterTest
	public void teardown() {
		closeApp();
	}

}

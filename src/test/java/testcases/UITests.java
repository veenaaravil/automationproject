package testcases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import assertions.AssertionClass;
import pageObjects.HomePageObject;
import reusablemethods.Base;

public class UITests extends Base {
	/*
	 * Application : Automation Exercise
	 * Module: HomePage
	 * @author: Veena K
	 * This test case will cover all the UI test scenarios for Home page
	 */
	
	// Import pageobject classes
	HomePageObject page1 = new HomePageObject(Base.driver);
	
	// Import other required classes
	AssertionClass asc = new AssertionClass(Base.driver);
	
	@BeforeTest
	public void setup() {
		launchApp();
	}
	
	@BeforeMethod
	public void setupBeforeMethod() {
		driver.navigate().to(readDataFromExcel(1, 1,filePath, sheetName));
	}
	
	@Test (priority = 0, description = "Test Case 1: Verify home page Logo")
	
	public void verifyLogo() {
		// Verify Home Page Logo
		
		WebElement actualLogo = page1.autoExImage;
		asc.elementAvailable(actualLogo, true);
		asc.elementEnabled(actualLogo, true);

	}
	
	@Test (priority = 1, description = "Test Case 2: Verify Fully Fledge Text")
	
	public void verifyFullFledgeText() {	
		// Verify Home Page Logo
		
		WebElement actualfullFledgeText = page1.fullFledgeText;
		String expectedfullFledgeText = "Full-Fledged practice website for Automation Engineers";
		asc.innerTextEquals(actualfullFledgeText, expectedfullFledgeText);
		asc.elementAvailable(page1.fullFledgeText, true);

	}
	
	@Test (priority = 2, description = "Test Case 3: Verify Left Arrow slider")
	
	public void verifyLeftArrow() {	
		// Verify Left Arrow
		
		WebElement actualRightScroll = page1.rightScroll;
		asc.elementAvailable(actualRightScroll, true);
		asc.elementEnabled(actualRightScroll, true);

	}
	@Test (priority = 3, description = "Test Case 4: Verify Right Arrow slider")
	
	public void verifyRightArrow() {	
		// Verify Left Arrow
		
		WebElement actualLeftScroll = page1.leftScroll;
		asc.elementAvailable(actualLeftScroll, true);
		asc.elementEnabled(actualLeftScroll, true);

	}
	
	@Test (priority = 4, description = "Test Case 5: Verify Girl Images")
	
	public void verifyGirlImages() {	
		// Verify Left Arrow
		
		// Verify first girl image
		WebElement secondGirlImg = page1.girl2Img;
		asc.elementAvailable(secondGirlImg, true);
		asc.elementEnabled(secondGirlImg, true);
		
		// Scroll to right
		page1.rightScroll.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		// Verify second girl image
		WebElement firstGirlImg = page1.girl1Img;
		wait.until(ExpectedConditions.visibilityOf(firstGirlImg));
		asc.elementAvailable(firstGirlImg, true);
		asc.elementEnabled(firstGirlImg, true);
				
		// Scroll to right
		page1.rightScroll.click();
				
		// Verify third girl image
		WebElement thirdGirlImg = page1.girl3Img;
		wait.until(ExpectedConditions.visibilityOf(thirdGirlImg));
		asc.elementAvailable(thirdGirlImg, true);
		asc.elementEnabled(thirdGirlImg, true);
		
	}
	
	@Test (priority = 5, description = "Test Case 6: Verify Subscription")
	public void verifySubscription(){

		//Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				
		// Verify text "Subscription"
				
		WebElement actualSubscriptionText = page1.subscription;
		String expectedSubscriptionText = "SUBSCRIPTION";
		asc.innerTextEquals(actualSubscriptionText, expectedSubscriptionText);
	
	}
	
	@Test (priority = 6, description = "Test Case 7: Verify Scroll Up Arrow")
	public void verifySrollUpArrow(){
		
		//Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		WebElement scrollUpArrow = page1.scrollArrow;
		asc.elementAvailable(scrollUpArrow, true);
		asc.elementEnabled(scrollUpArrow, true);		
	}
	
	@Test (priority = 7, description = "Test Case 8: Verify Headers")
	public void verifyHeaderElements(){
		
		// Products
		WebElement actualProductText = page1.productLink;
		String expectedProductText = " Products";
		asc.innerTextEquals(actualProductText, expectedProductText);
		asc.elementAvailable(actualProductText, true);
		asc.elementEnabled(actualProductText, true);
		
		// Cart
		WebElement actualCartText = page1.cartLink;
		String expectedCartText = "Cart";
		asc.innerTextEquals(actualCartText, expectedCartText);
		asc.elementAvailable(actualCartText, true);
		asc.elementEnabled(actualCartText, true);
		
		// Signup/Login
		WebElement actualLogin = page1.loginLink;
		String expectedLogin = "Signup / Login";
		asc.innerTextEquals(actualLogin, expectedLogin);
		asc.elementAvailable(actualLogin, true);
		asc.elementEnabled(actualLogin, true);
			
		// Test Cases
		WebElement actualTestCases = page1.testcaseLink;
		String expectedTestCases = "Test Cases";
		asc.innerTextEquals(actualTestCases, expectedTestCases);
		asc.elementAvailable(actualTestCases, true);
		asc.elementEnabled(actualTestCases, true);
		
		// API Testing
		WebElement actualApiTesting = page1.apiLink;
		String expectedApiTesting = "API Testing";
		asc.innerTextEquals(actualApiTesting, expectedApiTesting);
		asc.elementAvailable(actualApiTesting, true);
		asc.elementEnabled(actualApiTesting, true);
		
		// Video Tutorial
		WebElement actualVideo = page1.videoLink;
		String expectedVideo = "Video Tutorials";
		asc.innerTextEquals(actualVideo, expectedVideo);
		asc.elementAvailable(actualVideo, true);
		asc.elementEnabled(actualVideo, true);
		
		// Contact Us
		WebElement actualContactUs = page1.contactUsLink;
		String expectedContactUs = "Contact us";
		asc.innerTextEquals(actualContactUs, expectedContactUs);
		asc.elementAvailable(actualContactUs, true);
		asc.elementEnabled(actualContactUs, true);
	}
	
	@Test (priority = 8, description = "Test Case 9: Verify Home Page SubTitles")
	public void verifySubTitles(){
		
		// Featured Items
		WebElement actualfeatured_items = page1.featured_items;
		String expectedrefeatured_items = "FEATURES ITEMS";
		asc.innerTextEquals(actualfeatured_items, expectedrefeatured_items);
		asc.elementAvailable(actualfeatured_items, true);
		asc.elementEnabled(actualfeatured_items, true);	
		
		// Category
		WebElement actualrecategory = page1.category;
		String expectedrecategory = "CATEGORY";
		asc.innerTextEquals(actualrecategory, expectedrecategory);
		asc.elementAvailable(actualrecategory, true);
		asc.elementEnabled(actualrecategory, true);	
				
		// Brands
		WebElement actualrebrands = page1.brands;
		String expectedrebrands = "BRANDS";
		asc.innerTextEquals(actualrebrands, expectedrebrands);
		asc.elementAvailable(actualrebrands, true);
		asc.elementEnabled(actualrebrands, true);	
		
		// Recommended Items
		WebElement actualrecommendedTitle = page1.recommendedTitle;
		String expectedrecommendedTitle = "RECOMMENDED ITEMS";
		asc.innerTextEquals(actualrecommendedTitle, expectedrecommendedTitle);
		asc.elementAvailable(actualrecommendedTitle, true);
		asc.elementEnabled(actualrecommendedTitle, true);	
		
	}
	
	@AfterTest
	public void teardown() {
		closeApp();
	}
	

	

}

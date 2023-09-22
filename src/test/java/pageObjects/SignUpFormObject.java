package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import assertions.AssertionClass;
import reusablemethods.Base;

public class SignUpFormObject extends Base {

	WebDriver driver;

	public SignUpFormObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	// Creating constant global variables
	public static final String filePath = "C:\\Users\\achun\\OneDrive\\Desktop\\Veena-Selenium\\AutomationProjectTestData.xlsx";
	public static final String sheetName = "Generic";
	public static final String sheetNameTest = "UserSignup";

	// Import other required classes
	AssertionClass asc = new AssertionClass(Base.driver);

	// Signup form locators

	@FindBy(xpath = "//b[text()='Enter Account Information']")
	public WebElement enterAccInfoText;
	@FindBy(id = "id_gender1")
	public WebElement maleRdBtn;
	@FindBy(id = "id_gender2")
	public WebElement femaleRdBtn;
	@FindBy(name = "name")
	public WebElement nameForm;
	@FindBy(id = "password")
	public WebElement password;
	// Date of birth
	@FindBy(id = "days")
	public WebElement day;
	@FindBy(id = "months")
	public WebElement month;
	@FindBy(id = "years")
	public WebElement year;
	@FindBy(id = "newsletter")
	public WebElement newsletterCheckbox;
	@FindBy(id = "optin")
	public WebElement offersCheckbox;

	// Address Information
	@FindBy(xpath = "//b[text()='Address Information']")
	public WebElement addInfo;
	@FindBy(id = "first_name")
	public WebElement fname;
	@FindBy(id = "last_name")
	public WebElement lname;
	@FindBy(id = "company")
	public WebElement company;
	@FindBy(id = "address1")
	public WebElement address;
	@FindBy(id = "address2")
	public WebElement address2;
	@FindBy(id = "country")
	public WebElement country;
	@FindBy(id = "state")
	public WebElement state;
	@FindBy(id = "city")
	public WebElement city;
	@FindBy(id = "zipcode")
	public WebElement zipcode;
	@FindBy(id = "mobile_number")
	public WebElement mobile_number;
	@FindBy(xpath = "//button[text()='Create Account']")
	public WebElement createAccBtn;
	@FindBy(xpath = "//b[text()='Account Created!']")
	public WebElement accCreatedSuccess;
	@FindBy(xpath = "//a[text()='Continue']")
	public WebElement continueBtn;

	// Iframe
	@FindBy(id = "aswift_0")
	public WebElement frameId0;
	@FindBy(id = "aswift_1")
	public WebElement frameId1;
	@FindBy(id = "aswift_2")
	public WebElement frameId2;
	@FindBy(id = "aswift_3")
	public WebElement frameId3;
	@FindBy(id = "aswift_4")
	public WebElement frameId4;
	@FindBy(id = "aswift_5")
	public WebElement frameId5;
	@FindBy(id = "aswift_6")
	public WebElement frameId6;
	@FindBy(id = "aswift_7")
	public WebElement frameId7;

	// Add Close button
	@FindBy(css = "path[d='M3.25,3.25l8.5,8.5M11.75,3.25l-8.5,8.5']")
	public WebElement addCloseBtn;
	@FindBy(id = "report_text")
	public WebElement stopSeeingAdd;
	@FindBy(xpath = "//span[text()='Not interested in this ad']")
	public WebElement notInterestedAdd;

	// Close add after continue button
	@FindBy(xpath = "//iframe[@id='ad_iframe' and @title='Advertisement']")
	public WebElement googleAddIframe;
	@FindBy(css = "path[d='M38 12.83L35.17 10 24 21.17 12.83 10 10 12.83 21.17 24 10 35.17 12.83 38 24 26.83 35.17 38 38 35.17 26.83 24z']")
	public WebElement googleAddClose;
	@FindBy(xpath = "//div[@id='dismiss-button']/div/span")
	public WebElement googleAddDismiss;
	@FindBy(xpath = "//span[text()='Close']")
	public WebElement gAddClose;
	@FindBy(id = "google_esf")
	public WebElement googleEsfAdd;


	public void closeAdd() {
		try {
			if (googleEsfAdd.isDisplayed()) {
				driver.switchTo().frame(googleEsfAdd);
				addCloseBtn.click();
				stopSeeingAdd.click();
				notInterestedAdd.click();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			if (frameId0.isDisplayed()) {
				driver.switchTo().frame(frameId0);
				addCloseBtn.click();
				stopSeeingAdd.click();
				notInterestedAdd.click();

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			if (frameId1.isDisplayed()) {
				driver.switchTo().frame(frameId1);
				addCloseBtn.click();
				stopSeeingAdd.click();
				notInterestedAdd.click();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			if (frameId2.isDisplayed()) {
				driver.switchTo().frame(frameId2);
				addCloseBtn.click();
				stopSeeingAdd.click();
				notInterestedAdd.click();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			if (frameId3.isDisplayed()) {
				driver.switchTo().frame(frameId3);
				addCloseBtn.click();
				stopSeeingAdd.click();
				notInterestedAdd.click();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			if (frameId4.isDisplayed()) {
				driver.switchTo().frame(frameId4);
				addCloseBtn.click();
				stopSeeingAdd.click();
				notInterestedAdd.click();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			if (frameId5.isDisplayed()) {
				driver.switchTo().frame(frameId5);
				addCloseBtn.click();
				stopSeeingAdd.click();
				notInterestedAdd.click();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			if (frameId6.isDisplayed()) {
				driver.switchTo().frame(frameId6);
				addCloseBtn.click();
				stopSeeingAdd.click();
				notInterestedAdd.click();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}

	}

	public void closeGoogleAdd() {
		try {
			driver.switchTo().frame(googleAddIframe);
			googleAddClose.click();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			driver.switchTo().frame(googleEsfAdd);
			googleAddClose.click();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			driver.switchTo().frame(frameId0);
			googleAddClose.click();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			driver.switchTo().frame(frameId1);
			googleAddClose.click();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			driver.switchTo().frame(frameId2);
			googleAddClose.click();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			driver.switchTo().frame(frameId3);
			googleAddClose.click();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			driver.switchTo().frame(frameId4);
			googleAddClose.click();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			driver.switchTo().frame(frameId5);
			googleAddClose.click();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			driver.switchTo().frame(frameId6);
			googleAddClose.click();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
	}


	public void closeGoogleAddDismissBtn() {
		try {
			driver.switchTo().frame(googleAddIframe);
			googleAddDismiss.click();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			driver.switchTo().frame(googleEsfAdd);
			googleAddDismiss.click();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			driver.switchTo().frame(frameId0);
			googleAddDismiss.click();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			driver.switchTo().frame(frameId1);
			googleAddDismiss.click();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			driver.switchTo().frame(frameId2);
			googleAddDismiss.click();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			driver.switchTo().frame(frameId3);
			googleAddDismiss.click();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			driver.switchTo().frame(frameId4);
			googleAddDismiss.click();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			driver.switchTo().frame(frameId5);
			googleAddDismiss.click();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
		try {
			driver.switchTo().frame(frameId6);
			googleAddDismiss.click();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
	}

	// Validate home page

	public void submitSignUpForm() {
		String enterAccTitle = "ENTER ACCOUNT INFORMATION";
		asc.innerTextEquals(enterAccInfoText, enterAccTitle);

		// Submit form
		femaleRdBtn.click();
		nameForm.clear();
		nameForm.sendKeys(readDataFromExcel(9, 2, filePath, sheetNameTest));
		password.sendKeys(readDataFromExcel(9, 3, filePath, sheetNameTest));

		// Close Add
		closeAdd();

		selectElement(day, readDataFromExcel(9, 4, filePath, sheetNameTest));
		selectByText(month, readDataFromExcel(9, 5, filePath, sheetNameTest));
		selectElement(year, readDataFromExcel(9, 6, filePath, sheetNameTest));

		// Close Add
		closeAdd();

		newsletterCheckbox.click();
		offersCheckbox.click();

		// Fill address details and create account
		fname.sendKeys(readDataFromExcel(15, 2, filePath, sheetNameTest));
		lname.sendKeys(readDataFromExcel(15, 3, filePath, sheetNameTest));
		company.sendKeys(readDataFromExcel(15, 4, filePath, sheetNameTest));
		address.sendKeys(readDataFromExcel(15, 5, filePath, sheetNameTest));
		address2.sendKeys(readDataFromExcel(15, 6, filePath, sheetNameTest));

		selectElement(country, readDataFromExcel(15, 7, filePath, sheetNameTest));
		state.sendKeys(readDataFromExcel(15, 8, filePath, sheetNameTest));
		city.sendKeys(readDataFromExcel(15, 9, filePath, sheetNameTest));
		zipcode.sendKeys(readDataFromExcel(15, 10, filePath, sheetNameTest));
		mobile_number.sendKeys(readDataFromExcel(15, 11, filePath, sheetNameTest));
		createAccBtn.click();

		String expectedAccCreatedText = "ACCOUNT CREATED!";
		asc.innerTextEquals(accCreatedSuccess, expectedAccCreatedText);

		continueBtn.click();
		String addexpectedUrl = "https://automationexercise.com/account_created#google_vignette";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		try {
			wait.until(ExpectedConditions.urlToBe(addexpectedUrl));
			wait.until(ExpectedConditions.visibilityOf(googleAddIframe));
			driver.switchTo().frame(googleAddIframe);
			wait.until(ExpectedConditions.elementToBeClickable(googleAddClose)).click();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.switchTo().defaultContent();
		}
	}

	// Click continue button
	public void clickContinueBtn() {
		try {
			continueBtn.click();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

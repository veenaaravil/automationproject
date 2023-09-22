package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assertions.AssertionClass;
import reusablemethods.Base;

public class SignUpAndLoginPageObject extends Base {

	WebDriver driver;

	public SignUpAndLoginPageObject(WebDriver driver) {
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

	// Login/Signup page locators

	@FindBy(xpath = "//a[@href='/login']")
	public WebElement loginTab;
	@FindBy(xpath = "//h2[text()='New User Signup!']")
	public WebElement newUserSignUpText;
	@FindBy(name = "name")
	public WebElement name;
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	public WebElement signUpEmail;
	@FindBy(xpath = "//button[@data-qa='signup-button']")
	public WebElement signUpBtn;
	@FindBy(xpath = "//h2[text()='Login to your account']")
	public WebElement loginToAccountText;
	@FindBy(xpath = "//input[@data-qa='login-email']")
	public WebElement loginEmail;
	@FindBy(xpath = "//input[@data-qa='login-password']")
	public WebElement loginPwd;
	@FindBy(xpath = "//button[@data-qa='login-button']")
	public WebElement loginBtn;
	@FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
	public WebElement incorrectEmailOrPwd;
	@FindBy(xpath = "//p[text()='Email Address already exist!']")
	public WebElement existingEmailError;

	// New user Signup
	public void signUp(String username, String email) {
		String expectedNewUserText = "New User Signup!";
		asc.innerTextEquals(newUserSignUpText, expectedNewUserText);
		name.sendKeys(username);
     // signUpEmail.sendKeys(getRandomEmail()+"@d3.com");
		signUpEmail.sendKeys(email);
		signUpBtn.click();
	}
	
	// Login as user
	public void login(String email, String password) {
		String expectedLoginTitleText = "Login to your account";
		asc.innerTextEquals(loginToAccountText, expectedLoginTitleText);
		loginEmail.sendKeys(email);
		loginPwd.sendKeys(password);
		loginBtn.click();

	}

}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assertions.AssertionClass;
import reusablemethods.Base;

public class ContactUsPageObject extends Base{
	
	WebDriver driver;
	public ContactUsPageObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	
	}
	
	//Import other class
	AssertionClass asc = new AssertionClass(Base.driver);
	SignUpFormObject page3 = new SignUpFormObject(Base.driver);
	
	
	@FindBy (xpath = "//h2[text()='Get In Touch']")public WebElement getInTouchText;
	@FindBy (name = "name")public WebElement name;
	@FindBy (name = "email")public WebElement email;
	@FindBy (name = "subject")public WebElement subject;
	@FindBy (id = "message")public WebElement message;
	@FindBy (name = "upload_file")public WebElement uploadFileBtn;
	@FindBy (name = "submit")public WebElement submitBtn;
	@FindBy (xpath = "//div[@class='status alert alert-success']")public WebElement successMsg;
	@FindBy (xpath = "//a[@class='btn btn-success']")public WebElement homeBtn;

	public void submitContactUs() {
		
		// Verify 'GET IN TOUCH' is visible
		WebElement actualgetInTouchText = getInTouchText;
		String expectedgetInTouchText = "GET IN TOUCH";
		asc.innerTextEquals(actualgetInTouchText, expectedgetInTouchText);
		
		page3.closeAdd();
		
				
		name.sendKeys(readDataFromExcel(27, 2,filePath, sheetNameTest));
		email.sendKeys(readDataFromExcel(27, 3,filePath, sheetNameTest));
		subject.sendKeys(readDataFromExcel(27, 4,filePath, sheetNameTest));
		message.sendKeys(readDataFromExcel(27, 5,filePath, sheetNameTest));
		uploadFileBtn.sendKeys(readDataFromExcel(27, 6,filePath, sheetNameTest));
		submitBtn.click();
		
		// Close the alert popup
		closeAlert();
		
		// Verify 'GET IN TOUCH' is visible
		String expectedContactFormSuccessText = "Success! Your details have been submitted successfully.";
		asc.innerTextEquals(successMsg, expectedContactFormSuccessText);
		
		// Click on home button and validate home page
		homeBtn.click();
	}
}

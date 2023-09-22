package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablemethods.Base;

public class PaymentPageObject extends Base {
	WebDriver driver;
	public PaymentPageObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	
	}
	@FindBy (xpath = "//h2[text()='Payment']")public WebElement paymentTitle;
	@FindBy (name = "name_on_card")public WebElement nameOnCard;
	@FindBy (name = "card_number")public WebElement card_number;
	@FindBy (name = "cvc")public WebElement cvc;
	@FindBy (name = "expiry_month")public WebElement expiry_month;
	@FindBy (name = "expiry_year")public WebElement expiry_year;
	@FindBy (id = "submit")public WebElement paymentSubmitBtn;
	@FindBy (xpath = "Order Placed!")public WebElement order_placed;
	
	public void submitPayment() {
		// Enter payment details
		nameOnCard.sendKeys(readDataFromExcel(32, 2, filePath, sheetNameTest));
		card_number.sendKeys(readDataFromExcel(32, 3, filePath, sheetNameTest));
		cvc.sendKeys(readDataFromExcel(32, 4, filePath, sheetNameTest));
		expiry_month.sendKeys(readDataFromExcel(32, 5, filePath, sheetNameTest));
		expiry_year.sendKeys(readDataFromExcel(32, 6, filePath, sheetNameTest));
				
		paymentSubmitBtn.click();
	}

}

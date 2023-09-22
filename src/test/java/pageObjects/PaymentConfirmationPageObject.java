package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentConfirmationPageObject {
	WebDriver driver;
	public PaymentConfirmationPageObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	
	}

	@FindBy (xpath = "//a[text()='Download Invoice']")public WebElement downloadInvoiceBtn;
	@FindBy (xpath = "//a[text()='Continue']")public WebElement continueBtn;
}

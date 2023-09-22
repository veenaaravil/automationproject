package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrandDetailPageObject {
	WebDriver driver;
	public BrandDetailPageObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	
	}
	@FindBy (xpath = "//h2[text()='Brand - Polo Products']")public WebElement brandPoloTitle;
	@FindBy (xpath = "//a[@href='/brand_products/Madame']")public WebElement madmeBrand;
	@FindBy (xpath = "//h2[text()='Brand - Madame Products']")public WebElement brandMadmeTitle;

}

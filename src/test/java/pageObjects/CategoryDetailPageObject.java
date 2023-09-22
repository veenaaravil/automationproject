package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryDetailPageObject {
	WebDriver driver;
	public CategoryDetailPageObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	
	}
	// Category
	@FindBy (xpath = "//h2[text()='Category']")public WebElement category;
	@FindBy (xpath = "//a[@href='#Women']")public WebElement womenCategory;
	@FindBy (xpath = "//a[@href='/category_products/1' and text()='Dress ']")public WebElement womenSubCat;
	@FindBy (xpath = "//h2[text()='Women - Dress Products']")public WebElement womenCatTitle;
	@FindBy (xpath = "//a[@href='#Men']")public WebElement menCategory;
	@FindBy (xpath = "//a[text()='Jeans ']")public WebElement menSubCat;
	@FindBy (xpath = "//h2[text()='Men - Jeans Products']")public WebElement menCatTitle;


}

package assertions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import reusablemethods.Base;

public class AssertionClass extends Base {

	WebDriver driver;

	public AssertionClass(WebDriver driver) {
		this.driver = driver;
	}

	// Method to check whether the url equals to specific string or not
	public void urlEquals(String expectedUrl) {
		String actualUrl = driver.getCurrentUrl();
		assertEquals(actualUrl, expectedUrl, "Actual Url is equal to the expected URL(" + expectedUrl + ")Url");
	}

	// Method to check whether url contains specifx string or not
	public void urlContains(String expectedUrl) {
		String actualUrl = driver.getCurrentUrl();
		if (actualUrl.contains(expectedUrl)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

	// Method to verify the title is equal to expected title
	public void titleEquals(String expectedTitle) {
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle, "Actual Title is equal to the expected Title(" + expectedTitle + ")");
	}

	// Method to verify the innerHtmlText of the single webelement is equal to the expected text
	public void innerTextEquals(WebElement element, String expectedText) {
		String actualText = element.getText();
		assertEquals(actualText, expectedText);
	}

	// Method to verify the innerHtmlText of the multiple webelement is equal to the expected text
	public void multipleInnerTextEquals(List<WebElement> element, String expectedText) {
		for (WebElement data : element) {
			String actualText = data.getText();
			assertEquals(actualText, expectedText);
		}
	}

	// Method to verify whether the element is available in the application or not
	public void elementAvailable(WebElement element, boolean expectedValue) {
		boolean actualValue = element.isDisplayed();
		assertEquals(actualValue, expectedValue);
	}

	// Method to verify whether the element is enabled in the application or not
	public void elementEnabled(WebElement element, boolean expectedValue) {
		boolean actualValue = element.isEnabled();
		assertEquals(actualValue, expectedValue);
	}

	// Method to verify whether the element is selected in the application or not
	public void elementSelected(WebElement element, boolean expectedValue) {
		boolean actualValue = element.isEnabled();
		assertEquals(actualValue, expectedValue);
	}

}

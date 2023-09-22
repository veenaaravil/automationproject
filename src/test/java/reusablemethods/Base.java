package reusablemethods;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	
	// Creating constant global variables
	public static final String filePath = "C:\\Users\\achun\\OneDrive\\Desktop\\Veena-Selenium\\Selenium workspace\\ExcelRSeleniumProject2\\src\\test\\java\\testdata\\AutomationProjectTestData.xlsx";
	public static final String sheetName = "Generic";
	public static final String sheetNameTest = "UserSignup";
	
	// Creating driver instance
	
	public static WebDriver driver = new FirefoxDriver();
		
	// Method to launch application
	public void launchApp() {
		Reporter.log("=====Browser Session Started=====", true);
		WebDriverManager.firefoxdriver().setup();
//		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().deleteAllCookies();
		Reporter.log("=====Application Started=====", true);
	}

	// Method to close the brower instance
	public void closeApp() {
		driver.close();
		Reporter.log("=====Browser Session End=====", true);
	}
	
	// Method to close alert
	public void closeAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	
	// Random email generator
	public String getRandomEmail() {
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder s2 = new StringBuilder();
        Random rnd = new Random();
        while (s2.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * s1.length());
            s2.append(s1.charAt(index));
        }
        String emailStr = s2.toString();
        return emailStr;
    }
	
	// Method to Import Select class to handle drop down
	public void selectElement(WebElement el, String val) {
		Select sel = new Select(el);
		sel.selectByValue(val);
	}
	
	public void selectByText(WebElement el, String val) {
		Select sel = new Select(el);
		sel.selectByVisibleText(val);
	}

	// Import workbook to get the data from the excel
	public String readDataFromExcel(int rowcount,int columncount,String filepath,String Sheetname)
    {
        String data = null;
        try
        {
            FileInputStream input= new FileInputStream(filepath);
            @SuppressWarnings("resource")
			XSSFWorkbook wb=new XSSFWorkbook(input);
            XSSFSheet sh=wb.getSheet(Sheetname);
            XSSFRow row=sh.getRow(rowcount);
            DataFormatter df = new DataFormatter();
            data = df.formatCellValue(row.getCell(columncount));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return data;
    }
}

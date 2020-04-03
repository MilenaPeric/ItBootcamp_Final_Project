package page_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page_objects.Registration;
import page_objects.SignIn;
import utility.ExcelUtils;

@Test
public class RegistrationTest {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test

	public void testRegistrationFromExcelFile() {

		for (int i = 1; i < ExcelUtils.getRowNumber(); i++) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Registration.REGISTRATION_URL);

			ExcelUtils.setExcell("Book.xls");
			WebElement email = Registration.getEmail(driver);
			email.click();
			String data = ExcelUtils.getDataAt(i, 1);
			email.sendKeys(data);
			Registration.clickCreateAccount(driver);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Registration.inputFirstName(driver, ExcelUtils.getDataAt(i, 3));
			Registration.inputLastName(driver, ExcelUtils.getDataAt(i, 4));
			Registration.getPassword(driver, ExcelUtils.getDataAt(i, 6));
			Registration.inputPostalCode(driver, ExcelUtils.getDataAt(i, 10));
			Registration.country(driver);
			Registration.inputMobilePhone(driver, ExcelUtils.getDataAt(i, 12));
			Registration.inputAliasAddress(driver, ExcelUtils.getDataAt(i, 13));
			Registration.getaddress(driver, ExcelUtils.getDataAt(i, 7));
			Registration.getCity(driver, ExcelUtils.getDataAt(i, 8));
			Registration.state(driver, ExcelUtils.getDataAt(i, 9));
			Registration.clickRegBtn(driver);

			String verifyAccount = driver.findElement(By.xpath(Registration.VERIFY_ACCOUNT)).getText();
			String expectedAccount = ExcelUtils.getDataAt(i, 1) + " " + ExcelUtils.getDataAt(i, 3) + " "
					+ ExcelUtils.getDataAt(i, 4);

			boolean areAccountsMatched = verifyAccount.contains(expectedAccount);
			Assert.assertTrue(areAccountsMatched);
			SignIn.getsignOut(driver);
		}
		ExcelUtils.closeExcell();

	}

	@AfterClass
	public void closeChrome() {
		driver.close();
	}
}
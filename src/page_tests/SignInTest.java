package page_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.Registration;
import page_objects.SignIn;
import utility.ExcelUtils;

public class SignInTest {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(HomePage.HOME_URL);
	}

	
	@Test
	
	public void singInAndSignOut() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(Registration.REG_URL);
		for (int i = 25; i < ExcelUtils.getRowNumber(); i++) {
			
			

			ExcelUtils.findExcellSheet();

			SignIn.getEmailAddressRegistered(driver, ExcelUtils.getDataAt(i, 1));
			SignIn.getPassword(driver, ExcelUtils.getDataAt(i, 6));
			SignIn.getBtnSignIn(driver);
			
			String verifyAccount = driver.findElement(By.xpath(Registration.VERIFY_ACCOUNT)).getText();
			String expectedAccount = ExcelUtils.getDataAt(i, 1) + " " + ExcelUtils.getDataAt(i, 3)+ " " +ExcelUtils.getDataAt(i, 4);
			
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
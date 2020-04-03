package page_tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.Cart;

@Test
public class Cart_Tests {
	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test(priority = 1)
	public void PrintedSummerDress() {
		driver.get(Cart.PAGE_URL);
		Cart.clickPrintedSummerDress(driver);
		Cart.getDressAmount(driver);
		Cart.getDressColor(driver);
		Cart.getDressSize(driver);
		Cart.clickAddToCart(driver);
		Cart.clickProccedToCheckout(driver);
	}

	@Test(priority = 2)
	public void cvalidationCart() {

		Cart.validationPrintedSummerDress(driver);
		Cart.validationDressColorSize(driver);
		Cart.validationCartDressAmount(driver);
		Cart.clickCartProccedToCheckout(driver);

	}

	@AfterClass
	public void closeChrome() {
		driver.close();
	}
}
  


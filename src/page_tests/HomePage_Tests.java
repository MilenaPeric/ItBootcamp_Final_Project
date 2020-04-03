package page_tests;

import org.testng.annotations.Test;

import page_objects.HomePage;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class HomePage_Tests {
	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void testOpenPage() {
		driver.get(HomePage.HOME_URL);

		String current = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php";

		Assert.assertEquals(current, expected);
	}

	@Test
	public void testWoman() throws InterruptedException {
		driver.get(HomePage.HOME_URL);
		HomePage.hoverWoman(driver);
		HomePage.getWomanSummerDresses(driver);
		String current = driver.getCurrentUrl();
		String expected = HomePage.WOMAN_SUMMERDRESSES_URL;
		Assert.assertEquals(current, expected);
	}

	@Test
	public void testDresses() {
		driver.get(HomePage.HOME_URL);
		HomePage.hoverDresses(driver);
		HomePage.getDressesSummerDresses(driver);
		String current = driver.getCurrentUrl();
		String expected=HomePage.DRESSES_SUMMERDRESSES_URL;
		Assert.assertEquals(current,expected);

	}
	@Test
	public void testNavigation() {
		driver.get(HomePage.HOME_URL);
		driver.navigate().to(HomePage.WOMAN_SUMMERDRESSES_URL);
		driver.getCurrentUrl();
		if (!driver.getCurrentUrl().equals(HomePage.DRESSES_SUMMERDRESSES_URL)) {
			driver.navigate().to(HomePage.HOME_URL);
		}
	}
	@AfterClass
	public void closeChrome() {
		driver.close();
	}

}

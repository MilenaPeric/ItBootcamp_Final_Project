package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Cart {
	public static final String PAGE_URL = "http://automationpractice.com/index.php?id_category=11&controller=category";
	public static String PRINTED_SUMMER_DRESS_XPATH = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]";
	public static String DRESS_AMOUNT_XPATH = "//input[@id='quantity_wanted']";
	public static String DRESS_SIZE_XPATH = "//select[@id='group_1']";
	public static String DRESS_COLOR_XPATH = "//a[@id='color_14']";;
	public static String ADD_TO_CART_XPATH = "//span[contains(text(),'Add to cart')]";
	public static String PROCCED_TO_CHEKOUT = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a";
	public static String CART_URL = "http://automationpractice.com/index.php?controller=order";
	public static String CART_PROCCED_TO_CHEKOUT = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]";
	public static String CART_URl = "http://automationpractice.com/index.php?controller=order";
	public static String BTN_CHECK_OUT = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]";
	public static String CART_PRINTED_SUMMER_DRESS = "//td[@class='cart_description']//a[contains(text(),'Printed Summer Dress')]";
	public static String CART_COLOR_DRESS_SIZE = "//td[@class='cart_description']//a[contains(text(),'Color : Blue, Size : M')]";
	public static String CART_DRESS_AMOUNT = "//input[@name='quantity_5_24_0_0']";

	public static void openCart(WebDriver driver) {
		driver.get(CART_URL);

	}

	public static void openPage(WebDriver driver) {
		driver.get(PAGE_URL);
	}

	public static void clickPrintedSummerDress(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elem = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRINTED_SUMMER_DRESS_XPATH)));
		elem.click();
	}

	public static void getDressAmount(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DRESS_AMOUNT_XPATH)));
		elem.click();
		elem.clear();
		elem.sendKeys("2");
	}

	public static void getDressColor(WebDriver driver) {
		driver.findElement(By.xpath(DRESS_COLOR_XPATH)).click();
	}

	public static void getDressSize(WebDriver driver) {
		Select size = new Select(driver.findElement(By.xpath(DRESS_SIZE_XPATH)));
		size.selectByVisibleText("M");

	}

	public static void clickAddToCart(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADD_TO_CART_XPATH)));
		elem.click();
	}

	public static void clickProccedToCheckout(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PROCCED_TO_CHEKOUT)));
		elem.click();

	}

	public static void clickCartProccedToCheckout(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CART_PROCCED_TO_CHEKOUT)));
		elem.click();

	}

	public static void validationPrintedSummerDress(WebDriver driver) {
		String cartPrintedSummerDress = driver.findElement(By.xpath(CART_PRINTED_SUMMER_DRESS)).getText();
		String expected = "Printed Summer Dress";
		Assert.assertEquals(cartPrintedSummerDress, expected);

	}

	public static void validationDressColorSize(WebDriver driver) {
		String cartDressColorSize = driver.findElement(By.xpath(CART_COLOR_DRESS_SIZE)).getText();
		String expected = "Color : Blue, Size : M";
		boolean ok = cartDressColorSize.contains(expected);
		Assert.assertTrue(ok);
	}

	public static void validationCartDressAmount(WebDriver driver) {
		String cartDressAmount = driver.findElement(By.xpath(CART_DRESS_AMOUNT)).getAttribute("value");
		String expected = "2";
		boolean ok = cartDressAmount.contains(expected);
		Assert.assertTrue(ok);
	}

}


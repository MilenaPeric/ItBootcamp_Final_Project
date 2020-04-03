package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn {

	public static final String SIGN_IN_URL = "https://petstore.octoperf.com/actions/Account.action?signonForm=";
	public static String EMAIL_ADDRESS_REGISTERED = "//input[@id='email']";
	private static String PASSWORD = "//input[@id='passwd']";
	private static String BTN_SIGN_IN = "//p[@class='submit']//span[1]";
	private static String BTN_SIGN_OUT = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a";

     //Email Address Registered
	public static void getEmailAddressRegistered(WebDriver driver, String emailaddress) {
		WebElement elem = driver.findElement(By.xpath(EMAIL_ADDRESS_REGISTERED));
		elem.click();
		elem.sendKeys("nikola.nikolic1234567@gmail.com");
	}

    // Password
	public static void getPassword(WebDriver driver, String password) {
		WebElement elem = driver.findElement(By.xpath(PASSWORD));
		elem.sendKeys("nikola1234");
	}

	// BTN_SIGN_IN
	public static void getBtnSignIn(WebDriver driver) {
		WebElement elem = driver.findElement(By.xpath(BTN_SIGN_IN));
		elem.click();
	}

	// Sign Out User
	public static void getsignOut(WebDriver driver) {
		WebElement elem = driver.findElement(By.xpath(BTN_SIGN_OUT));
		elem.click();
	}

}
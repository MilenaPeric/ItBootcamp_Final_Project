package page_objects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Registration {
	public static String REGISTRATION_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	public static String EMAIL_ADDRESS = "//input[@id='email_create']";
	public static String BTN_CREATE_ACCOUNT = "//button[@id='SubmitCreate']";
	private static String FIRST_NAME = "//input[@id='customer_firstname']";
	private static String LAST_NAME = "//input[@id='customer_lastname']";
	private static String PASSWORD = "//input[@id='passwd']";
	private static String ASSIGN_AN_ADDRESS_ALLIAS_FOR_FUTURE_REFERENCE = "//input[@id='alias']";
	private static String ADDRESS = "//input[@id='address1']";
	private static String CITY = "//input[@id='city']";
	private static String STATE = "//select[@id='id_state']";
	private static String POSTAL_CODE = "//input[@id='postcode']";
	private static String COUNTRY = "//select[@id='id_country']";
	private static String MOBILE_PHONE = "//input[@id='phone_mobile']";
	private static String BTN_REGISTER = "//span[contains(text(),'Register')]";
	public static String REG_URL = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0#account-creation";
	public static String VERIFY_ACCOUNT = "//a[@class='account']";

	// Open page
	public static void openPage(WebDriver driver) {
		driver.get(REGISTRATION_URL);
	}
	// EMAIL

	public static WebElement getEmail(WebDriver driver) {
		return driver.findElement(By.xpath(EMAIL_ADDRESS));
	}

	public static void clickEmail(WebDriver driver) {
		getEmail(driver).click();
	}

	public static String getEmailValue(WebDriver driver) {
		String email = getEmail(driver).getAttribute("value");
		return email;
	}


	// Create account button
	public static void clickCreateAccount(WebDriver driver) {
		driver.findElement(By.xpath(BTN_CREATE_ACCOUNT)).click();
	}

	// First name
	public static void inputFirstName(WebDriver driver, String firstname) {
		WebElement elem = driver.findElement(By.xpath(FIRST_NAME));
		elem.sendKeys(firstname);
	}

	// Last name
	public static void inputLastName(WebDriver driver, String lastname) {
		WebElement elem = driver.findElement(By.xpath(LAST_NAME));
		elem.sendKeys(lastname);
	}
	// Set email
		public static void inputEmail(WebDriver driver) {
			WebElement elem = getEmail(driver);
			elem.click();
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(30);
			elem.sendKeys("milena" + randomInt + "@gmail.com");

		}
	// Password
	public static void getPassword(WebDriver driver, String password) {
		WebElement elem = driver.findElement(By.xpath(PASSWORD));
		elem.sendKeys(password);
	}

	// State
	public static void state(WebDriver driver, String state) {
		Select statefld = new Select(driver.findElement(By.xpath(STATE)));
		statefld.selectByVisibleText(state);

	}

	// Postal code
	public static void inputPostalCode(WebDriver driver, String postalcode) {
		WebElement elem = driver.findElement(By.xpath(POSTAL_CODE));
		elem.sendKeys(postalcode);
	}

	//Country
	public static void country(WebDriver driver) {
		driver.findElement(By.xpath(COUNTRY)).click();
	}

	// Mobile phone
	public static void inputMobilePhone(WebDriver driver, String mobilePhone) {
		WebElement elem = driver.findElement(By.xpath(MOBILE_PHONE));
		elem.sendKeys(mobilePhone);
	}

	// Alias Address for future reference
	public static void inputAliasAddress(WebDriver driver, String aliasAddress) {
		WebElement elem = driver.findElement(By.xpath(ASSIGN_AN_ADDRESS_ALLIAS_FOR_FUTURE_REFERENCE));
		elem.sendKeys(aliasAddress);
	}

	// Registration button
	public static void clickRegBtn(WebDriver driver) {
		driver.findElement(By.xpath(BTN_REGISTER)).click();
	}

	// Address
	public static void getaddress(WebDriver driver, String address) {
		WebElement elem = driver.findElement(By.xpath(ADDRESS));
		elem.sendKeys(address);
	}

	// City
	public static void getCity(WebDriver driver, String city) {
		WebElement elem = driver.findElement(By.xpath(CITY));
		elem.sendKeys(city);
	}

}

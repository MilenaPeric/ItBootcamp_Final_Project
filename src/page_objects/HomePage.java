package page_objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	/*
	 * Testira se sajt http://automationpractice.com/index.php. Za rad sa elementima
	 * koji se nalaze na web stranici koristiti Selenium, a za pisanje testova
	 * TestNG. Primeniti Page Object Model. Testirati da li kada se na početnoj
	 * stranici sajta mišem stane na dugme WOMEN, a zatim odatle odabere
	 * SummerDresses odlazi na korektnu stranu. Testirati da li kada se na početnoj
	 * stranici sajta mišem stane na dugme DRESSES, a zatim odatle odabere SUMMER
	 * DRESSES odlazi na korektnu stranu. Proverite da li prethodne dve tačke vode
	 * na istu stranicu.
	 */
	public static final String HOME_URL = "http://automationpractice.com/index.php";
	public static String WOMAN = "//a[@class='sf-with-ul'][contains(text(),'Women')]";
	public static String DRESSES ="/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a";
	public static String WOMAN_SUMMERDRESSES_XPATH = "//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'Summer Dresses')]";
	public static String DRESSES_SUMMERDRESSES_XPATH = "//li[@class='sfHover']//a[contains(text(),'Summer Dresses')]";
	public static String WOMAN_SUMMERDRESSES_URL = "http://automationpractice.com/index.php?id_category=11&controller=category";                                         
	public static String DRESSES_SUMMERDRESSES_URL = "http://automationpractice.com/index.php?id_category=11&controller=category";

	//OPEN PAGE

		public static void openPage(WebDriver driver) {
			driver.get(HOME_URL);
		}
		
		
		
	// WOMAN
	public static WebElement getWoman(WebDriver driver) {
		WebElement woman=driver.findElement(By.xpath(WOMAN));
		return woman;
	}

	public static void hoverWoman(WebDriver driver) {
		 Actions actions = new Actions(driver);
		 getWoman(driver);
	     actions.moveToElement(getWoman(driver)).perform();
		}

	public static void getWomanSummerDresses(WebDriver driver){
		WebDriverWait wait= new WebDriverWait(driver,10);
		WebElement elem= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WOMAN_SUMMERDRESSES_XPATH)));
		elem.click();
		
	}

	

	               // Navigate to page
	public static void navigateToWomanSummerDresses(WebDriver driver) {
		driver.navigate().to(WOMAN_SUMMERDRESSES_URL);

	}

	// DRESSES

	private static WebElement getDresses(WebDriver driver) {
		WebElement dresses = driver.findElement(By.xpath(DRESSES));
		return dresses;
	}

	public static void hoverDresses(WebDriver driver) {
		
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDresses(driver);
	     actions.moveToElement(getDresses(driver)).perform();
		}
	

	public static void getDressesSummerDresses(WebDriver driver) {
		WebElement elem= driver.findElement(By.xpath(DRESSES_SUMMERDRESSES_XPATH));
		elem.click();
	}

	//public static void clickDressesSummerDresses(WebDriver driver) {
		//getDressesSummerDresses(driver).click();
	//}

	             // Navigate to page
	public static void navigateToDressesSummerDresses(WebDriver driver) {
		driver.navigate().to(DRESSES_SUMMERDRESSES_URL);

	}




}
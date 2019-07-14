package scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestFlipkartWebsite {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\EclipseLuna\\SeleniumProject\\src\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);

	}

	@Test
	public void test1() throws InterruptedException {
		driver.findElement(By.xpath("//div[1][@class='_39M2dM JB4AMj']/input")).sendKeys("8299708815");
		;
		driver.findElement(By.xpath("//div[2][@class='_39M2dM JB4AMj']/input")).sendKeys("soframycin");
		driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")).click();
		WebElement element = driver.findElement(By.xpath("//*[@class='Wbt_B2 _1YVU3_'][1]/span"));
		/*
		 * Actions action = new Actions(driver); Actions
		 * actions=action.moveToElement(element); actions.perform();
		 */
		WebElement elementSearch = element.findElement(By.xpath("//*[@title='Search for products, brands and more']"));
		elementSearch.sendKeys("iphon");
		elementSearch.click();

		/*
		 * WebElement iphonApple=driver.findElement(By.
		 * xpath("//*[@class='_1-2Iqu row']/div[@class='col col-7-12']/div[contains(text(),'Apple iPhone 6s (Rose Gold, 32 GB')]"
		 * )); iphonApple.click();
		 */
		// WebElement search=elements.findElement(By.xpath("//*[@name='otracker']"));
		// search.click();

	}
}

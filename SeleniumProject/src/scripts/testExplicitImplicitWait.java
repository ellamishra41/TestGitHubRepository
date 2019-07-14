package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testExplicitImplicitWait {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","D:\\EclipseLuna\\SeleniumProject\\src\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		wait = new WebDriverWait(driver, 10000);
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		WebElement element = driver.findElement(By.xpath("//*[@id='start']/button"));
		element.click();
		// WebElement element2 = driver.findElement(By.xpath("//*[@id='finish']/h4"));
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']")));
		System.out.println(element.getText());
		if (!element2.getText().equals("Hello World!")) {
			Assert.fail();
		}
	}
}

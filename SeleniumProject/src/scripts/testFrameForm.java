package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testFrameForm {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\EclipseLuna\\SeleniumProject\\src\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.get("https://www.toolsqa.com/iframe-practice-page/");
		wait = new WebDriverWait(driver, 20);
	}

	/*
	 * @Test public void testFrame() throws InterruptedException { WebElement
	 * element=driver.findElement(By.xpath("//*[@id='IF1']"));
	 * driver.switchTo().frame(element); System.out.println(driver.getPageSource());
	 * 
	 * }
	 */
	/*
	 * @Test public void test2() { driver.switchTo().frame(0);
	 * driver.switchTo().frame("frame-left"); WebElement element =
	 * driver.findElement(By.tagName("body")); if (element.getText().equals("LEFT"))
	 * System.out.println("left");
	 * 
	 * }
	 */
	@Test
	public void test3() {
		WebElement element = driver.findElement(By.xpath("//*[@id='IF1']"));
		driver.switchTo().frame(element);
		if (driver.getPageSource().contains("Practice Automation Form")) {
			System.out.println("InsideFrame1");
		}
		 WebElement firstName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='form-horizontal']/fieldset/div/input[@name='firstname']")));
		//WebElement firstName = driver.findElement(By.xpath("//*[@class='form-horizontal']/fieldset/div/input[@name='firstname']"));
		firstName.sendKeys("ELLA");
		WebElement lastName = driver
				.findElement(By.xpath("//*[@class='form-horizontal']/fieldset/div/input[@name='lastname']"));
		lastName.sendKeys("MISHRA");
		WebElement female = driver
				.findElement(By.xpath("//*[@class='form-horizontal']/fieldset/div/input[@id='sex-1']"));
		female.click();
		WebElement manualTester = driver
				.findElement(By.xpath("//*[@class='form-horizontal']/fieldset/div/input[@id='profession-0']"));
		manualTester.click();
		WebElement automationTester = driver
				.findElement(By.xpath("//*[@class='form-horizontal']/fieldset/div/input[@id='profession-1']"));
		automationTester.click();
		driver.findElement(By.xpath("//*[@id='submit']")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("IF2");
		//WebElement frame2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sidebar']/aside[1]/h3")));
		WebElement frame2 =driver.findElement(By.xpath("//div[@id='sidebar']/aside[1]/h3"));
		if (frame2.getText().equals("Interactions")) {
			System.out.println("frame2");
			driver.switchTo().parentFrame();
			driver.switchTo().frame("IF1");
			if (driver.getPageSource().contains("Practice Automation Form")) {
				System.out.println("InsideFrame1");
			}

		}

	}
}

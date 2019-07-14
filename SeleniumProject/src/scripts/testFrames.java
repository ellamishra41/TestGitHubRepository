package scripts;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testFrames {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\EclipseLuna\\SeleniumProject\\src\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.cookbook.seleniumacademy.com/Frames.html");

	}

	@Test
	public void switchFrames() {
		driver.switchTo().frame("left");
		WebElement element = driver.findElement(By.tagName("p"));
		if (element.getText().equals("This is Left Frame"))
			System.out.println(element.getText());
		driver.switchTo().parentFrame();

	}

	@Test
	public void switchFrames1() {
		driver.switchTo().frame(1);
		WebElement element = driver.findElement(By.tagName("p"));
		if (element.getText().equals("This Frame doesn't have id or name"))
			System.out.println(element.getText());
		driver.switchTo().parentFrame();

		driver.switchTo().frame("right");
		WebElement element1 = driver.findElement(By.tagName("p"));
		if (element1.getText().equals("This is Right Frame"))
			System.out.println(element1.getText());
	}
}

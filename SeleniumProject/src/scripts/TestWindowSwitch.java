package scripts;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestWindowSwitch {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\EclipseLuna\\SeleniumProject\\src\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(" https://www.toolsqa.com/automation-practice-switch-windows/");
	}

	@Test
	public void switchFrames() {
       driver.switchTo().defaultContent();
		WebElement element = driver.findElement(By.xpath("//*[@id='button1']"));
		element.click();
		Set<String> ids1 = driver.getWindowHandles();
		System.out.println("size " + ids1.size());
		for (String id : ids1) {
			driver.switchTo().window(id);
			if (driver.getTitle().contains("Free QA Automation Tools"))
			{
			if(driver.getPageSource().contains("Automation Tools Tutorial"))
			{
				System.out.println("window1");
				System.out.println("pagesource :"+driver.getPageSource());
				break;
			}
			}
			
		}
		Set<String> ids4 = driver.getWindowHandles();
		System.out.println("size " + ids4.size());
		System.out.println(driver.getTitle());
		for (String id : ids4) {
			driver.switchTo().window(id);
			if (driver.getTitle().contains("A new title is here"))
			{
				if(driver.getPageSource().contains("Automation Practice Switch Windows"))
				{
				System.out.println("window1");
				System.out.println("pagesource :"+driver.getPageSource());
				break;
				}
			
			}
		}
		
		
		
		
		

		/*WebElement windowElement = driver.findElement(By.xpath("//*[@id='content']/p[3]/button"));
		windowElement.click();
		Set<String> ids2 = driver.getWindowHandles();
		System.out.println("size " + ids2.size());
		for (String id : ids2) {
			driver.switchTo().window(id);
			if (driver.getPageSource().contains("Knowledge increases by sharing but not bysaving"))
				System.out.println("window2");
			break;
		}

		WebElement elements = driver.findElement(By.xpath("//*[@id='content']/p[4]/button"));
		elements.click();
		Set<String> ids3 = driver.getWindowHandles();
		System.out.println("size " + ids3.size());
		for (String id : ids3) {
			driver.switchTo().window(id);
			if (driver.getTitle().contains("Free QA Automation Tools"))
				System.out.println("window3");
			break;
		}
*/
	}
}

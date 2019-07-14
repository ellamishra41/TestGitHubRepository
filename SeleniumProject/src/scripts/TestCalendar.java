package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCalendar
{
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","D:\\EclipseLuna\\SeleniumProject\\src\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.tripadvisor.in/");
	}
	@Test
	public void test1()
	{
		driver.findElement(By.xpath("//*[@id='taplc_quick_links_component_0']/div/div/div/div/span[4]/div/a/span[1]")).click();
		for(int i=0;i<2;i++)
		{
			List<WebElement> elements=driver.findElements(By.xpath("//*[@id='roundtrip_picker']/div[i]/span"));
			elements.get(i).click();
		}
	}
	
}

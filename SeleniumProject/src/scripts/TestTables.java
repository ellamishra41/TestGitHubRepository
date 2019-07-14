package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTables 
{
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",	"D:\\EclipseLuna\\SeleniumProject\\src\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/tables");
	}

	@Test
	public void testDeleteRow() 
	{
		List<WebElement> trList = driver.findElements(By.tagName("tr"));
		for (WebElement element : trList) 
		{
			if (element.getText().contains("jdoe@hotmail.com")) 
			{
				List<WebElement> tdList = element.findElements(By.tagName("td"));
				for (WebElement td : tdList) 
				{
					if (td.getText().equals("edit delete"))
					{
						List<WebElement> deleteLink = td.findElements(By.tagName("a"));
						for (WebElement elements : deleteLink) 
						{
							if (elements.getText().equals("delete"))
								elements.click();
						}
					}
				}
			}
		}
	}
}

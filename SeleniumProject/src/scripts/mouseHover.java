package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseHover 
{
	public static WebDriver driver;

	   public static void main(String[] args) {
		   System.setProperty("webdriver.chrome.driver","D:\\EclipseLuna\\SeleniumProject\\src\\resources\\chromedriver.exe");
	        driver = new ChromeDriver();

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        driver.get("https://www.onlinestore.toolsqa.com");

	        WebElement element = driver.findElement(By.linkText("Product Category"));

	        Actions action = new Actions(driver);

	        action.moveToElement(element).build().perform();

	        driver.findElement(By.linkText("iPads")).click();

	        }

}

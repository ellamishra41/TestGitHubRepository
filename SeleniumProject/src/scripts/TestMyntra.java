package scripts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMyntra {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","D:\\EclipseLuna\\SeleniumProject\\src\\resources\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		Map<String, Object> prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		//1-Allow, 2-Block, 0-default
		options.setExperimentalOption("prefs",prefs);
	     driver=new ChromeDriver(options);
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
	}

	@Test
	public void login()
	{
	   WebElement elementLogin=	driver.findElement(By.xpath("//div/*[@class='desktop-userTitle']"));
		Actions actions=new Actions(driver);
	    actions.moveToElement(elementLogin).perform();
		driver.findElement(By.xpath("//*[@class='desktop-linkButton'][1]")).click();
		driver.findElement(By.xpath("//*[@id='gPlusLogin']")).click();
		Set<String> windowIds=driver.getWindowHandles();
		System.out.println(windowIds.size());
		for(String windowId:windowIds)
		{
		 driver.switchTo().window(windowId);
			if(driver.getTitle().contains("Sign in – Google accounts"))
			{
			   break;
			}
		}
		 Assert.assertEquals(driver.getTitle(), "Sign in – Google accounts");
		driver.findElement(By.id("identifierId")).sendKeys("missella1993@gmail.com");
		driver.findElement(By.xpath("//*[@id='identifierNext']/span/span[@class='RveJvd snByac']")).click();
	    driver.findElement(By.xpath("//*[@name='password']")).sendKeys("KOMALchautala12");;
	    driver.findElement(By.xpath("//*[@id='passwordNext']/span/span[@class='RveJvd snByac']")).click();
		Set<String> windowIds1=driver.getWindowHandles();
		System.out.println(windowIds1.size());
		for(String windowId1:windowIds1)
		{
		   driver.switchTo().window(windowId1);
		   System.out.println(driver.getCurrentUrl());
			if(driver.getCurrentUrl().contains("https://www.myntra.com/"))
			{
			   break;
			}
		}
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.myntra.com/");

	}
	@Test
	public void selectElementFromHover() throws InterruptedException
	{
		login();
		List<WebElement> elements=driver.findElements(By.xpath("//*[@class='desktop-navContent']"));
		for(WebElement element:elements)
		{
			System.out.println(element.getText());
		}
		Actions action = new Actions(driver);	
		Actions actions=action.moveToElement(elements.get(1)); //womens section hover
		actions.perform();
		List<WebElement> elementWomens=driver.findElements(By.xpath("//*[@class='desktop-navLinks']/div[2]/div/div/div/div/li[1]/ul[1]/li")) ;
		for(WebElement elementWomen:elementWomens)
		{
			if(elementWomen.getText().contains("Lehenga Cholis"))
			{
				Actions actionWomen = new Actions(driver);
				actionWomen.moveToElement(elementWomen).perform();
				actionWomen.click();
				break;
			}
		}
		WebElement listLehenga= driver.findElement(By.xpath("//*[@class='pagination-container']/li[4]/a"));
		listLehenga.click();
		List<WebElement> elementPage=driver.findElements(By.xpath("//*[@class='results-showMoreContainer']/ul/li"));
		System.out.println(elementPage.size());
		/*   List<WebElement> listLehenga= driver.findElements(By.xpath("//*[@class='pagination-container']/li"));
		   for(WebElement lehengaPage:listLehenga)
		   {
			   System.out.println(lehengaPage.getText());
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			   lehengaPage.click();
		   }*/
	}
	@Test
	public void searchFromSearchBar()
	{
		//WebElement element=driver.findElement(By.xpath("//*[@class='desktop-searchBar']"));
		//element.sendKeys("womens");
		 //List<WebElement> elementWomens=driver.findElements(By.xpath("//*[@class='desktop-suggestion null']"));
		//elementWomens.get(0).click();
	}
	@Test
	public void scrolldown()
	{
		try {
			  selectElementFromHover();
		     JavascriptExecutor js = (JavascriptExecutor) driver;
	    	// js.executeScript("arguments[0].scrollIntoView();", Element);
		     js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		     }
		 catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Clasifika {


	//WebDriver driver;
	//WebElement ;

	@Test
	public void TestClasifika() throws InterruptedException
	{
		
		// TODO Auto-generated method stub
				try {
					System.setProperty("webdriver.chrome.driver","C:\\Users\\Amol\\Downloads\\ChromeDriver\\chromedriver.exe");
					WebDriver driver= new ChromeDriver();
					String baseUrl = "https://dev.clasifika.com";
					driver.get(baseUrl);
					WebDriverWait wait=new WebDriverWait(driver, 20);	
					
					System.out.println("URL Launched");					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav.header")));
					driver.findElements(By.cssSelector("div.header-lang-icon.eng.ng-scope")).get(1).click();
					driver.manage().window().maximize() ;
					driver.findElement(By.cssSelector("button.btn.btn-default.btn-search.ng-binding")).click();
					System.out.println("Clicked Search");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for='sell']")));
					System.out.println("Selecting Filters");
					driver.findElement(By.cssSelector("label[for='sell']")).click();
					driver.findElement(By.cssSelector("label[for='house']")).click();
					driver.findElement(By.cssSelector("a.view-more.ng-binding")).click();
					((JavascriptExecutor) driver).executeScript("scroll(0,2000);");
					driver.findElement(By.xpath("//label[@id='4bedroom']")).click();
					driver.findElement(By.cssSelector("label#near_school")).click();
					driver.findElement(By.xpath("//label[@id='parking_lot']/following-sibling::label[1]")).click();		
					driver.findElement(By.cssSelector("label#elevator")).click();
					//((JavascriptExecutor) driver).executeScript("scroll(2000,0);");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.filter-element-button a.ng-scope")));
					
					driver.findElement(By.cssSelector("div.filter-element-button a.ng-scope")).click();
					
					//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton")));
					Thread.sleep(10000);
					WebElement ele = driver.findElement(By.id("searchButton"));
					ele.click();
					System.out.println("Element clicke");
					List<WebElement> filters= driver.findElements(By.id("searchButton"));
				System.out.println("Verifying selected Filters on Results Page");
					for (WebElement webElement : filters) {
					System.out.println(webElement.getText());
					
				}
					
					
			driver.quit();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
			
			


		

	}
	@BeforeTest
	public void beforeTest()
	{


	}

	@AfterTest
	public void afterTest() {
	}

}

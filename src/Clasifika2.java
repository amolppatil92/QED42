import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Clasifika2 {
	@Test
	public void secondscenario() 
	{
		// TODO Auto-generated method stub
		try {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Amol\\Downloads\\ChromeDriver\\chromedriver.exe");
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
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton")));
		WebElement ele = driver.findElement(By.id("searchButton"));
		ele.click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-default.more-filter.dropdown-toggle")));
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button.btn.btn-default.more-filter.dropdown-toggle")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.dropdown-menu li.ng-binding")));
		
		
		//WebElement sort = driver.findElement(By.cssSelector("ul.dropdown-menu li.ng-binding"));
		List<WebElement> filters= driver.findElements(By.cssSelector("ul.dropdown-menu li.ng-binding"));
		filters.get(1).click();
		
		Thread.sleep(10000);
		System.out.println("Sorted As Price (Low To High)");
		List<WebElement> price= driver.findElements(By.cssSelector("div.price.ng-binding"));
		System.out.println("Size of list is "+price.size());
		
		long arrPrice[]=new long[price.size()];
		int i=0;
		boolean sorted = true;
		for (WebElement webElement : price) {
			String temp = webElement.getText();
			
			String[] arr1 = temp.split(" ");
		String arr2 = arr1[0].replace("$","");		
		String arr3=arr2.replace(",","");
		arrPrice[i]=Long.parseLong(arr3);
		System.out.println(arrPrice[i]);
		if(i>0){
			 if (arrPrice[i-1] < arrPrice[i]) {
		            continue;
		            
		        } else {
		           System.out.println("Not sorted");
		           sorted=false;
		           break;
		        }
			}
		i++;
		//System.out.println(arr2[1]);
		}
		if(sorted){
		System.out.println("Its sorted Array of prices");
		}
		
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-default.more-filter.dropdown-toggle")));
		
		driver.findElement(By.cssSelector("button.btn.btn-default.more-filter.dropdown-toggle")).click();
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.dropdown-menu li.ng-binding")));
		
		driver.findElements(By.cssSelector("ul.dropdown-menu li.ng-binding")).get(3).click();
		
		Thread.sleep(5000);
				
		System.out.println("Sorted As per dates");
		List<WebElement> dateList= driver.findElements(By.cssSelector("span.date.calender.ng-binding"));
		for (WebElement webElement2 : dateList) {
			System.out.println(webElement2.getText());
		}
		
		driver.close();
		//driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
			
			


	}
}

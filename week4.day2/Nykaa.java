package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.nykaa.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(driver.findElement(By.xpath("//a[text()='brands']"))).build().perform();
		
		builder.moveToElement(driver.findElement(By.xpath("//a[text()=\"L'Oreal Paris\"]"))).click().build().perform();
		
		System.out.println("Title of the page is: " + driver.getTitle());
		
		if(driver.getTitle().contains("L'Oreal Paris"))
			System.out.println("Title matching");
		else System.out.println("Title not matching");
		
		builder.moveToElement(driver.findElement(By.className("sort-name"))).click().build().perform();
		
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='customer top rated']"))).click().build().perform();
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='Category']"))).click().build().perform();
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='Hair']"))).click().build().perform();
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='Hair Care']"))).click().build().perform();
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='Shampoo']"))).click().build().perform();
	
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='Concern']"))).click().build().perform();
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='Color Protection']"))).click().build().perform();
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='Color Protection']"))).click().build().perform();
			
		boolean verifyFilter = driver.findElement(By.xpath("//span[text()='Shampoo']")).isDisplayed();
		System.out.println("Filter is applied with 'Shampoo " + verifyFilter);
		
			
		builder.moveToElement(driver.findElement(By.xpath("//div[text()=\"L'Oreal Paris Colour Protect Shampoo\"]"))).click().build().perform();
		
		Set <String> window = driver.getWindowHandles();
		List <String> windowHandle = new ArrayList <String> (window);
		
		driver.switchTo().window(windowHandle.get(1));
		
		WebElement select = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select size = new Select(select);
		size.selectByIndex(2);
		
		String mrp = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
		System.out.println("MRP : " + mrp);
		
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='ADD TO BAG']"))).click().build().perform();
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='ADD TO BAG']"))).click().build().perform();
		builder.moveToElement(driver.findElement(By.xpath("//span[@class=\"cart-count\"]"))).click().build().perform();
		
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		
		String grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		grandTotal = grandTotal.substring(1); // substring() extracts first letter of this string:
		System.out.println("Grand total is : " + grandTotal);
		
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='PROCEED']"))).click().build().perform();
		builder.moveToElement(driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']"))).click().build().perform();
		String finalGrandTotal = driver.findElement(By.xpath("//div[text()='Grand Total']//following-sibling::div/span")).getText();
		System.out.println("Final grand total is : " + finalGrandTotal);
		
		if(grandTotal.equals(finalGrandTotal)) {
			System.out.println("Shopping page and Checkout page grand total value is same");
		} else System.out.println("Shopping page and Checkout page grand total value is not same");
				
	
					
		
		
		

	}

}

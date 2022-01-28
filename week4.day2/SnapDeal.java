package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.snapdeal.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"))).click().build().perform();
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='Sports Shoes']"))).click().build().perform();
		String countShoes = driver.findElement(By.xpath("//div[@class='child-cat-count ']")).getText();
		System.out.println("No. of count of spoert shoes for men: " + countShoes); 
		
		Thread.sleep(2000);
		
		builder.moveToElement(driver.findElement(By.xpath("//div[text()='Training Shoes']"))).click().build().perform();
		
		Thread.sleep(2000);
		
		builder.moveToElement(driver.findElement(By.xpath("//div[@class='sort-selected']"))).click().build().perform();
		builder.moveToElement(driver.findElement(By.xpath("//li[@class='search-li' and @data-sorttype='plth']"))).click().build().perform();

		Thread.sleep(3000);
		
		WebElement fromValue = driver.findElement(By.xpath("//input[@name='fromVal']")); fromValue.clear();
		fromValue.sendKeys("900");
		  
		WebElement toValue = driver.findElement(By.xpath("//input[@name='toVal']"));
		toValue.clear(); toValue.sendKeys("1200");
		  
		builder.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'GO')]"))).click().build().perform();
		
		Thread.sleep(3000);
		
		builder.moveToElement(driver.findElement(By.xpath("//label[@for='Color_s-Navy']"))).click().build().perform();
		
		
		String priceFilter = driver.findElement(By.xpath("//div[@class='navFiltersPill'][1]/a")).getText();
		
		String colorFilter = driver.findElement(By.xpath("//div[@class='navFiltersPill'][2]/a")).getText();

		System.out.println("Price Filter Text : "+ priceFilter);
		System.out.println("Price Color Text : "+ colorFilter);
				
		boolean verifyFilter  = (priceFilter.contains("Rs. 900 - Rs. 1200") && colorFilter.contains("Navy"));
		System.out.println("Filters verified --> " + verifyFilter);
		
		builder.moveToElement(driver.findElement(By.xpath("//img[@class='product-image wooble']/ancestor::a"))).build().perform();
		Thread.sleep(3000);
		builder.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"))).click().build().perform();
		
		String price = driver.findElement(By.className("payBlkBig")).getText();
		String discount = driver.findElement(By.className("percent-desc")).getText();
		
		System.out.println("Price of the product: " + price);
		System.out.println("Discount percentage: " + discount);
		
					
		File source = driver.getScreenshotAs(OutputType.FILE);
	
		File location = new File("E://Testleaf//Screenshots/screenshot.png");
	
		FileUtils.copyFile(source, location);
		
		driver.close();
		 
	}

}

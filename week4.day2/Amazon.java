package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	
	public static void main(String[] args) throws InterruptedException, IOException {
	
	WebDriverManager.chromedriver().setup();
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	
	ChromeDriver driver = new ChromeDriver(options);
	
	driver.manage().window().maximize();
	
	driver.get("https://www.amazon.in/");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	
	Actions builder = new Actions(driver);
	
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus 9 Pro", Keys.ENTER);
	
	String productPrice = driver.findElement(By.className("a-price-whole")).getText();
	System.out.println("Price of the First product displayed : " + productPrice);
	
	String firstProduct = driver.findElement(By.xpath("//span[@class='a-size-base a-color-base s-underline-text']")).getText();
	System.out.println("Customer ratings of the first displayed product: " + firstProduct);
	
	builder.moveToElement(driver.findElement(By.xpath("//span[@class='a-icon-alt']"))).click().build().perform();
	
	String ratingProduct = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-beside-button a-text-bold']")).getText();
	System.out.println("Percentage rating of first product: " + ratingProduct);
	
	builder.moveToElement(driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"))).click().build().perform();
	
	driver.switchTo().window(new ArrayList <String> (driver.getWindowHandles()).get(1));
	
	File screenshot = driver.getScreenshotAs(OutputType.FILE);
	
	File location = new File("E://Testleaf//Screenshots/screenshot2.png");
	
	FileUtils.copyFile(screenshot, location);
	
	builder.moveToElement(driver.findElement(By.id("add-to-cart-button"))).click().build().perform();
	
	Thread.sleep(5000);
	
	String cartTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
	
	cartTotal = cartTotal.substring(1,7);
	
	System.out.println("Cart Total Amount : "+cartTotal);
	
	boolean verifyTotal  = (productPrice.equals(cartTotal));
	System.out.println(verifyTotal);

	}
}

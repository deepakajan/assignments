package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnActions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable--notifications");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		///driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("https://www.snapdeal.com/");
		
		Actions builder = new Actions(driver);
		
		WebElement men = driver.findElement(By.xpath("//span[text()='Men's Fashion']"));
		Thread.sleep(1000);
		WebElement shirts = driver.findElement(By.xpath("//span[text()='Shirts']"));
		builder.moveToElement(men).pause(100).click(shirts).perform();
		
		WebElement firstShirt = driver.findElement(By.xpath("//div[@class='product-tuple-image ']"));
		
		builder.moveToElement(firstShirt).perform();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[text()='QUICK VIEW']")).click();
		
	}

}

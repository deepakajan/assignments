package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;	

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
				
		driver.get("http://www.leafground.com/pages/Alert.html");
	
		//Alert alert = driver.switchTo().alert();
		
		
		//Click on Alert box
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		
		//Click on confirm box
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		driver.switchTo().alert().dismiss();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		
		//Click on Prompt Box 
		driver.findElement(By.xpath("//button[text() ='Prompt Box']")).click();
		driver.switchTo().alert().sendKeys("Deepak");
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		
		//Click on Line Breaks?
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		
		//click on switch alert
		//driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		driver.findElement(By.id("btn")).click();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.close();
	}
	}



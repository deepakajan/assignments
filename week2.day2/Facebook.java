package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
	
	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	System.out.println("Our current URL is " + driver.getCurrentUrl());
	if(driver.getTitle().contains("Facebook")) {
		System.out.println("Title verified, matching");
	}
	else {
		System.out.println("Title verified, not-matching");
	}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	
	//driver.findElement(By.xpath("//a[@role='button' and contains(text(),'Create New Account')]")).click();
	driver.findElement(By.linkText("Create New Account")).click();
	driver.findElement(By.xpath("//input[@type='text' and @name='firstname']")).sendKeys("Firstname");
	driver.findElement(By.xpath("//input[@type='text' and @name='lastname']")).sendKeys("Lastname");
	driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys("mail@gmail.com");
	driver.findElement(By.xpath("//input[@aria-label='Re-enter email address']")).sendKeys("mil@gmail.com");
	//driver.findElement(By.xpath("//input[@aria-label='New password']")).sendKeys("hello");
	
	WebElement mail = driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']"));
	String email = mail.getText();
	
	WebElement vmail = driver.findElement(By.xpath("//input[@aria-label='Re-enter email address']"));
	String verifymail = vmail.getText();
	
	if(verifymail.contentEquals(email)) {
		
		System.out.println("mail matching");
		
		driver.findElement(By.xpath("//input[@aria-label='New password']")).sendKeys("hello");
		
		WebElement dd = driver.findElement(By.id("day"));
		Select dropdown = new Select(dd);
		dropdown.selectByValue("6");
		
		WebElement dd1 = driver.findElement(By.id("month"));
		Select dropdown1 = new Select(dd1);
		dropdown1.selectByIndex(0);
		
		WebElement dd2 = driver.findElement(By.id("year"));
		Select dropdown2 = new Select(dd2);
		dropdown2.selectByVisibleText("2021");
			
		driver.findElement(By.xpath("//input[@type='radio' and @name='sex' and @value='2']")).click();
		driver.findElement(By.xpath("//button[@type='submit' and @name='websubmit']")).click();
		
	}
	else {
		System.out.println("mail not matching");
	}
	
	
//	WebElement dd = driver.findElement(By.id("day"));
//	Select dropdown = new Select(dd);
//	dropdown.selectByValue("6");
//	
//	WebElement dd1 = driver.findElement(By.id("month"));
//	Select dropdown1 = new Select(dd1);
//	dropdown1.selectByIndex(0);
//	
//	WebElement dd2 = driver.findElement(By.id("year"));
//	Select dropdown2 = new Select(dd2);
//	dropdown2.selectByVisibleText("2021");
//		
//	driver.findElement(By.xpath("//input[@type='radio' and @name='sex' and @value='2']")).click();
//	driver.findElement(By.xpath("//button[@type='submit' and @name='websubmit']")).click();
	
	
	}
}


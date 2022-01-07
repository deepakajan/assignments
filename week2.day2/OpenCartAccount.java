package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCartAccount {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		driver.findElement(By.id("input-username")).sendKeys("deepakrajan");
		driver.findElement(By.id("input-firstname")).sendKeys("deepak");
		driver.findElement(By.id("input-lastname")).sendKeys("rajan");
		driver.findElement(By.id("input-email")).sendKeys("deepakvrajan@gmail.com");
		WebElement dropdown = driver.findElement(By.id("input-country"));
		Select country = new Select(dropdown);
		country.selectByVisibleText("India");
		driver.findElement(By.id("input-password")).sendKeys("password");
		
		//driver.findElement(By.xpath("//button[@type='submit' and contains(text(), 'Register']"));

		
		
	}

}

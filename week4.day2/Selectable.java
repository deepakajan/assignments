package week4.day2;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/selectable/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		Actions builder = new Actions(driver);
		
		driver.switchTo().frame(0);
				
		WebElement item1 = driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"));
		WebElement item3 = driver.findElement(By.xpath("//ol[@id='selectable']/li[3]"));
		WebElement item5 = driver.findElement(By.xpath("//ol[@id='selectable']/li[5]"));
		   
	    builder.keyDown(Keys.CONTROL).click(item1).click(item5).click(item3).build().perform();
	    
	   // driver.close();
		
		
	}
}

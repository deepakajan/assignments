package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizabale {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/resizable/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
				
		Actions builder = new Actions(driver);
		
		driver.switchTo().frame(0);
		
		WebElement resize = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
							
				
		//builder.dragAndDropBy(resize, resize.getLocation().getX(), resize.getLocation().getY()).build().perform();
		builder.clickAndHold(resize).moveByOffset(200, 150).perform();
	
	
	}
}

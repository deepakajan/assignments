package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/draggable/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
		
		Actions builder = new Actions(driver);
		
		driver.switchTo().frame(0);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		
		wait.until(ExpectedConditions.visibilityOf(drag));
		
		builder.dragAndDropBy(drag, 55, 180).perform();
		
		driver.close();
	}

}

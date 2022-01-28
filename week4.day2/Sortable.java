package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/sortable/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		Actions builder = new Actions(driver);
		
		driver.switchTo().frame(0);
		
		WebElement drag = driver.findElement(By.xpath("//ul[@id='sortable']/li[7]"));
		
		WebElement drop = driver.findElement(By.xpath("//ul[@id='sortable']/li[1]"));
		
		//builder.clickAndHold(draggableWE).moveToElement(droppableWE).release().build().perform();
				
		builder.clickAndHold(drag).moveToElement(drop).release().build().perform();

	}

}

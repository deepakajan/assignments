package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.leafground.com/pages/Window.html");
				
		//Click on Open Home Page
		
		  driver.findElement(By.id("home")).click();
		  
		  Set <String> openWindow = driver.getWindowHandles(); List <String> window =
		  new ArrayList <String> (openWindow);
		  
		  driver.switchTo().window(window.get(1));
		  System.out.println("Title of the child window is -->" + driver.getTitle());
		  Thread.sleep(1000); driver.close(); driver.switchTo().window(window.get(0));
		  System.out.println("Title of the parent window is -->" + driver.getTitle());
		 
		
		//Find the number of opened windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		Set <String> openWindows = driver.getWindowHandles();
		List <String> windows = new ArrayList <String> (openWindows);
		
		System.out.println("---------------------------------");
		System.out.println("Find the number of opened windows");
		driver.switchTo().window(windows.get(1));
		System.out.println("Title of the window one is -->" + driver.getTitle());
		Thread.sleep(1000);
		driver.close();
		driver.switchTo().window(windows.get(2));
		System.out.println("Title of the window two is -->" + driver.getTitle());
		Thread.sleep(1000);
		driver.close();

		
		//Close all except this window
		driver.findElement(By.xpath("//button[text()='Do not close me ')]")).click();
		
		
		Set <String> closedWindow = driver.getWindowHandles();
		List <String> closedWindows = new ArrayList <String> (closedWindow);
		driver.switchTo().window(closedWindows.get(1));
		System.out.println("Title of the closed window one is -->" + driver.getTitle());
		Thread.sleep(1000);
		driver.close();
		driver.switchTo().window(closedWindows.get(0));
		
			
		//Wait for 5 seconds
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds')]")).click();
				
		Set <String> wait = driver.getWindowHandles();
		List <String> waitWindow = new ArrayList <String> (wait);
		
		
		driver.switchTo().window(waitWindow.get(1));
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(waitWindow.get(0));
		//driver.quit();
		
	}

}

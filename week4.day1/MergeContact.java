package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	
		public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
			
			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
		
			driver.findElement(By.linkText("Contacts")).click();			
			driver.findElement(By.linkText("Merge Contacts")).click();	
			driver.findElement(By.xpath("//input[@name='ComboBox_partyIdFrom']"));
			driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
			
			Set <String> windowhandle = driver.getWindowHandles();
			List <String> window = new ArrayList <String> (windowhandle);
			driver.switchTo().window(window.get(1));
			
			
			driver.findElement(By.name("firstName")).sendKeys("test");
			driver.findElement(By.xpath("//button[text() = 'Find Contacts']")).click();
			Thread.sleep(1000);
			
			String firstId = driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).getText();
			driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
			
			System.out.println("First resulting ID from " + firstId);
			
			driver.switchTo().window(window.get(0));
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
			windowhandle = driver.getWindowHandles();
			window = new ArrayList <String> (windowhandle);
			driver.switchTo().window(window.get(1));
			
			driver.findElement(By.name("firstName")).sendKeys("deepak");
			driver.findElement(By.xpath("//button[text() = 'Find Contacts']")).click();
			Thread.sleep(1000);
			
			String SecondId = driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).getText();
			driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
			
			System.out.println("Second resulting ID to " + SecondId);
			driver.switchTo().window(window.get(0));
			
			driver.findElement(By.linkText("Merge")).click();
			
			driver.switchTo().alert().accept();
			
			System.out.println("Title of the page: " + driver.getTitle());
			
			if(driver.getTitle().contains("View"))
				System.out.println("Title matching");
			else
				System.out.println("Title not matching");
			
			String text = driver.findElement(By.className("x-paging-info")).getText();
			
			if(text.equals("No records to display")) { 
				System.out.println("Title matching: " + text);
				} else { 
					System.out.println("Title not matched"); 
				}
			
			driver.close();
	
		}
}


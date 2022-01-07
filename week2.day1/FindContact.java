package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FindContact {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.linkText("Find Contacts")).click();
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("peterparker@gmail.com");
		// driver.findElement(By.tagName("button")).click();
		driver.findElement(By.xpath("//button[@class='x-btn-text' and contains(text(),'Find Contacts')]")).click();
		// driver.findElement(By.xpath("//a[@class='linktext']/preceding-sibiling::div[@class='x-grid3-cell-inner
		// x-grid3-col-partyId']")).click();

		driver.close();

	}

}

package week2.day1;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class CreateContact {
		
			public static void main(String[] args) {
			
			WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.get("http://leaftaps.com/opentaps/");
			
			driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Create Contact")).click();
			driver.findElement(By.id("firstNameField")).sendKeys("Peter");
			driver.findElement(By.id("lastNameField")).sendKeys("Parker");
			driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Peter");
			driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Parker");
			driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("peterparker@gmail.com");
		
			driver.findElement(By.className("smallSubmit")).click();
			System.out.println("First name is "+ driver.findElement(By.id("viewContact_firstName_sp")).getText());;
			System.out.println(driver.getTitle());
					
			driver.close(); 
						
			}

}

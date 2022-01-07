package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {
	
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Stark Industries");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Peter");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Parker");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("peterparker@gmail.com");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("03/01/22"); 
		WebElement dropDown1 = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select dropDown2 = new Select(dropDown1);		
		dropDown2.selectByValue("INR");	
		
		WebElement dropDown3 = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select dropDown4 = new Select(dropDown3);	
		dropDown4.selectByIndex(0);
		
		WebElement dropDown5 = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select dropDown6 = new Select(dropDown5);		
		dropDown6.selectByVisibleText("India");	
		
			
		System.out.println(driver.findElement(By.id("createLeadForm_companyName")).getAttribute("value"));
		
		driver.findElement(By.className("smallSubmit")).click();
		
		System.out.println(driver.getTitle());
		System.out.print(driver.findElement(By.xpath("//span[@class='requiredField' and contains(text(),'Forename')]")).getText());
	
		System.out.println("is "+ driver.findElement(By.id("viewLead_firstName_sp")).getText());;
		System.out.println(driver.getTitle());
				
					
		if(driver.getTitle().contains("View "))
		{
			System.out.println("Title verified, matching");
		}
		else {
			System.out.println("Title verified, not-matching");
		}

		/* WebElement name = driver.findElement(By.id("viewContact_fullName_sp"));
		String fullname = name.getText();
			System.out.println(fullname);*/
			
		System.out.println(driver.findElement(By.xpath("//a[@class='linktext']/ancestor::td")).getText());
		
			
		//driver.close(); 
		
		
}

}

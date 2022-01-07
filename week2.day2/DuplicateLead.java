package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
			
		public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress' and @type='text']")).sendKeys("peterparker@gmail.com");
		
		driver.findElement(By.xpath("//button[@type='button' and contains(text(),'Find Leads')]")).click();
		
		Thread.sleep(500);
		WebElement capturedLeadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]"));
		String leadId = capturedLeadId.getText();
		System.out.println("Lead ID is " + leadId);
		
		Thread.sleep(500);
		
		//First resulting click
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
		
		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Captured company name is " + companyName);
		
		String firstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("Captured first name is " + firstName);
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		driver.findElement(By.className("smallSubmit")).click();
		
		System.out.println("Capture title is " + driver.getTitle());
					
		if(driver.getTitle().contains("Duplicate Lead")) {
			System.out.println("Title verified, matching");
		}
		else {
			System.out.println("Title verified, not matching");
		}
		
				
		String firstNameCopy = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("Captured first name copy is " + firstNameCopy);
		
		String companyNameCopy = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Captured Duplicate company name is " + companyNameCopy);
		
		if(firstName.equals(firstNameCopy)) {
			System.out.println("Name verified, matching " + firstName + " and " + firstNameCopy);
		}
		else {
			System.out.println("Name verified, not matching" + firstName + " and " + firstNameCopy);
		}
	
		if(companyName.equals(companyNameCopy)) {
			System.out.println("Company Name verified " + companyName + " and " + companyNameCopy + " is matching");
		}
		else {
			System.out.println("Company Name verified " + companyName + " and " + companyNameCopy + " is not matching");
		}
			
		}
}

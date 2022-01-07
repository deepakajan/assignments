package week2.day2;

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
	
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	driver.findElement(By.linkText("Create Contact")).click();
	driver.findElement(By.id("firstNameField")).sendKeys("Peter");
	driver.findElement(By.id("lastNameField")).sendKeys("Parker");
	driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Peter");
	driver.findElement(By.id("createContactForm_departmentName")).sendKeys("IT");
	driver.findElement(By.id("createContactForm_description")).sendKeys("Description wrote");
	
	WebElement dropdown = driver.findElement(By.id("createContactForm_preferredCurrencyUomId"));
	Select currency = new Select(dropdown);
	currency.selectByValue("INR");
	
	driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("peterparker@gmail.com");
	
	
//	  WebElement dropdown1 =
//	  driver.findElement(By.id("createContactForm_generalCountryGeoId")); Select
//	  country = new Select(dropdown1); country.selectByValue("IND");
	  
	  WebElement dropdown2 =
	  driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
	  Select state = new Select(dropdown2); 
	  state.selectByVisibleText("New York");
	 
	
	driver.findElement(By.className("smallSubmit")).click();
	
	driver.findElement(By.linkText("Edit")).click();
	driver.findElement(By.id("updateContactForm_description")).clear();
	driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Description cleared and It worked!!");
	driver.findElement(By.xpath("//input[@class='smallSubmit' and @value='Update']")).click();
	
	System.out.println(driver.getTitle());

	}

}

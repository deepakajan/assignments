package week3.day2;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws InterruptedException 
	{
		//Setup the chrome driver
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = handleWindowPopup();
		
		//Launch the chrome driver
		ChromeDriver chromeDriver = new ChromeDriver(options);
		
		//Load the URL
		chromeDriver.get("https://www.ajio.com/");
		
		//Maximize the window
		chromeDriver.manage().window().maximize();
		
		//Implicit Wait of 5 seconds
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		//Find the search box
		WebElement searchBox = chromeDriver.findElement(By.name("searchVal"));
		searchBox.sendKeys("Bags", Keys.ENTER);
		
		/*
		 * //Find and select the Men checkbox under gender filter Select genderCheckBox
		 * = new Select(chromeDriver.findElement(By.id("Men")));
		 * genderCheckBox.selectByValue("Men");
		 */
		
		Thread.sleep(2000);
		chromeDriver.findElement(By.xpath("//label[@for='Men']")).click();
		
		Thread.sleep(2000);
		chromeDriver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		
		Thread.sleep(2000);
		String itemsFound = chromeDriver.findElement(By.className("length")).getText();
		
		System.out.println("Items Found :"+itemsFound);
		
		List<WebElement> bagBrandList = chromeDriver.findElements(By.className("brand"));
		
		System.out.println("Brand Size :" + bagBrandList.size());
		
		for (WebElement webElement : bagBrandList) 
		{
			String brandName = webElement.getText();
			System.out.println(brandName);
		}
		
		List<WebElement> bagNameList = chromeDriver.findElements(By.className("nameCls"));
		
		System.out.println("Bag Name : "+bagNameList.size());
		
		for(WebElement webElement : bagNameList)
		{
			String bagName = webElement.getText();
			System.out.println(bagName);
		}
		
	}

	private static ChromeOptions handleWindowPopup() 
	{
		// Create object of HashMap Class
		Map<String, Object> prefs = new HashMap<String, Object>();
              
        // Set the notification setting it will override the default setting
		prefs.put("profile.default_content_setting_values.notifications", 2);
 
        // Create object of ChromeOption class
		ChromeOptions options = new ChromeOptions();
 
        // Set the experimental option
		options.setExperimentalOption("prefs", prefs);	
		
		return options;
	}

}

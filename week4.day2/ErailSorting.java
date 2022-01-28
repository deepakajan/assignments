package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSorting {
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.get("ttps://erail.in/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("MS",Keys.ENTER);
		
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("MDU",Keys.ENTER);
		
		WebElement dateCB = driver.findElement(By.id("chkSelectDateOnly"));
		
		if(dateCB.isSelected())
			dateCB.click();
		
		Thread.sleep(3000);
		
		//Get the total number of rows for the listed trains
		List <WebElement> rowElementsWE = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		int rowSize = rowElementsWE.size();
		
		Thread.sleep(3000);

		String trainName = "";
		List<String> trainNameList = new ArrayList <String>();
		
		//Iterate over the rows and get the list of train names 
		for(int i=1; i<=rowSize;i++)
		{
			//Get the train name
			trainName = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();

			//Add all the train name names in the set to check for duplicates
			trainNameList.add(trainName);
		}
		
		//Sort the train names in ascending order
		Collections.sort(trainNameList);
		System.out.println(trainNameList);
		
	}
}

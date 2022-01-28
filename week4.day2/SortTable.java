package week4.day2;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.get("http://www.leafground.com/pages/sorttable.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		driver.findElement(By.xpath("//tr[@role='row']/th[2]")).click();
		List <WebElement> tdList = driver.findElements(By.xpath("//tr[@role='row']/th[2]"));
		String strArry [] = new String[tdList.size()];
		for(int i=0;i < tdList.size();i++)
		{
			strArry[i]=tdList.get(i).getText();
		}
		/*
		 * Compare the String
		 */
		boolean sortFunctionality = true;
		outer: 
		for(int i=0;i < strArry.length;i++)
		{
			for(int j=i+1;j < i;j++)
			{
				int result = strArry[j].compareTo(strArry[i]);
				if(!(result > 0))
				{
						System.out.println("Data in the Table is not SORTED::" +strArry[j]+":::"+ strArry[i]);
						sortFunctionality=false;
						break outer;
				}
				else
				{
					 System.out.println("Data in the Table is SORTED::" +strArry[j]+":::"+ strArry[i]);
				}
			}
		}
		
		if(sortFunctionality)
		{
			System.out.println("SORT Functionality is working");
		}
		else
		{
			System.out.println("SORT Functionality is not working");
		}
		
	}
}

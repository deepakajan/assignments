package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {
public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.myntra.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(driver.findElement(By.xpath("//a[text()='Men']"))).build().perform();

		Thread.sleep(3000);
		
		builder.moveToElement(driver.findElement(By.xpath("//a[text()='Jackets']"))).click().build().perform();
		
		String titleCount = (driver.findElement(By.className("title-count")).getText());
		System.out.println("Total Count Initial : " + titleCount);
			
		int totalCountJacket = Integer.parseInt(titleCount.split(" ")[2]);
		System.out.println("Total Count of Jackets: " + totalCountJacket);
		
		String jacketCategoryCount = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		int jacketCount = Integer.parseInt(jacketCategoryCount.substring(1, 5));
		System.out.println("Total Count of Jackets under Category : " + jacketCount);
		
		String rainJacketCategoryCount = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		int rainJacketCount = Integer.parseInt(rainJacketCategoryCount.substring(1,3));
		System.out.println("Total Count of Rain Jackets under Category : " + rainJacketCount);
		
		int totalCount = jacketCount + rainJacketCount;
		System.out.println(totalCount);
		
		boolean verifyTotal = totalCountJacket == totalCount;
		System.out.println(verifyTotal);
		
		builder.moveToElement(driver.findElement(By.xpath("//span[@class='categories-num']/following-sibling::div"))).click().build().perform();
		builder.moveToElement(driver.findElement(By.className("brand-more"))).click().build().perform();
		
		WebElement brandName = driver.findElement(By.className("FilterDirectory-searchInput"));
		brandName.sendKeys("Duke", Keys.ENTER);
		
		builder.moveToElement(driver.findElement(By.xpath("//span[@class='FilterDirectory-count']/following-sibling::div"))).click().build().perform();
		
		builder.moveToElement(driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']"))).click().build().perform();
							
		int totalProducts =0;
		Thread.sleep(2000);
		totalProducts = checkBrandName(driver, totalProducts, 1);
		System.out.println("Page 1: " + totalProducts);
	
		builder.moveToElement(driver.findElement(By.xpath("//li[@class='pagination-number'][1]/a"))).click().build().perform();

		Thread.sleep(3000);
		totalProducts = checkBrandName(driver, totalProducts, 2);
		System.out.println("Page 2: " + totalProducts);

		
		builder.moveToElement(driver.findElement(By.xpath("//li[@class='pagination-number'][2]/a"))).click().build().perform();

		Thread.sleep(3000);
		totalProducts = checkBrandName(driver, totalProducts, 3);
		System.out.println("Page 3: " + totalProducts);

		builder.moveToElement(driver.findElement(By.xpath("//li[@class='pagination-number'][3]/a"))).click().build().perform();

		Thread.sleep(3000);
		totalProducts = checkBrandName(driver, totalProducts, 4);
		System.out.println("Page 4: " + totalProducts);
		
		Thread.sleep(3000);

		builder.moveToElement(driver.findElement(By.xpath("//li[@class='pagination-number'][4]/a"))).click().build().perform();

		Thread.sleep(3000);
		totalProducts = checkBrandName(driver, totalProducts, 5);
		System.out.println("Page 5: " + totalProducts);
	
		builder.moveToElement(driver.findElement(By.xpath("(//input[@class='discount-input'])[3]"))).click().build().perform();

		System.out.println("Price of the First Product displayed in the page : " + driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText());

		builder.moveToElement(driver.findElement(By.xpath("//div[@class='product-imageSliderContainer']/parent::a"))).click().build().perform();

		driver.switchTo().window(new ArrayList <String> (driver.getWindowHandles()).get(1));

		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);

		File destLocation = new File("E://Testleaf//Screenshots/screenshot1.png");

		FileUtils.copyFile(screenshotAs, destLocation);

		builder.moveToElement(driver.findElement(By.xpath("//span[text()='WISHLIST']"))).click().build().perform();

		}

		private static int checkBrandName(ChromeDriver driver, int totalProducts, int pageindex) {
		String brandName = "";
		
		List <WebElement> brandList = driver.findElements(By.xpath(("//h3[@class='product-brand']")));
		System.out.println("Size of brand list in current page " + pageindex + " : " + brandList.size());
			for (WebElement brandNameList : brandList) {
					brandName = brandNameList.getText();
					if (brandName.equalsIgnoreCase("Duke")) {
						totalProducts++;
					}
				}
				return totalProducts;
		}
}

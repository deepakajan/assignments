package week2.day2;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class DeleteLead {
		
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
		driver.findElement(By.linkText("Phone")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9025242755");
		driver.findElement(By.xpath("//button[@type='button' and contains(text(),'Find Leads')]")).click();
		Thread.sleep(300);
		WebElement capturedLeadId = driver.findElement(By.xpath("//div [@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]"));
		String leadId = capturedLeadId.getText();
		System.out.println("Lead ID is " + leadId);
		Thread.sleep(300);
			//driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
		driver.findElement(By.xpath("//div [@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
		
		driver.findElement(By.linkText("Delete")).click();
		//driver.findElement(By.className("subMenuButtonDangerous")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//input[@type='text' and @name='id']")).sendKeys(leadId);
		
		driver.findElement(By.xpath("//button[@type='button' and contains(text(),'Find Leads')]")).click();
		
		Thread.sleep(300);
		
		String text = driver.findElement(By.className("x-paging-info")).getText();
		
		if(text.equals("No records to display")) {
			System.out.println("Text matched");
		}
		else {
			System.out.println("Text not matched");
	}
		
		}
	}



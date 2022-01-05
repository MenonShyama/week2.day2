package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException{
		String updateName="Info";
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Edit']")).click();
		WebElement companyName=driver.findElement(By.xpath("(//input[@name='companyName'])[2]"));
		companyName.clear();
		companyName.sendKeys(updateName);
		
		//driver.findElement(By.xpath("//input[@name='companyName'])[2]")).sendKeys(updateName);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		WebElement name=driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
		String firstName=name.getText();
		
		if( firstName.contains("Info"))
		{
			System.out.println("Company name updated");
		}
		else
		{
			System.out.println("failed");
		}
		
		
		
	}

}

package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	
	//Pre-requisite required
	//should have a record with the number 9645454577

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		// driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("91");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9645454577");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner')]/a[@class='linktext']"))
				.getAttribute("value");

		WebElement output = driver
				.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner')]/a[@class='linktext']"));
		String leadId = output.getText();

		System.out.println(leadId);
		output.click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9677699819");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		WebElement message = driver.findElement(By.xpath("//div[@class='x-paging-info']"));
		String outputMessage = message.getText();
		System.out.println(outputMessage);
		driver.close();

		// driver.findElement(By.xpath("//input[@name='id']")).);

	}

}

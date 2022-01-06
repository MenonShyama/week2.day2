package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		String expectedTitle = "Duplicate Lead";
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("babu@testleaf.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		WebElement firstName = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"));
		String name = firstName.getText();
		System.out.println("First resulting name is " + name);
		Thread.sleep(5000);
		firstName.click();
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Duplicate Lead']")).click();
		WebElement pageTitle = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads']"));
		String title = pageTitle.getText();
		//System.out.println(title);
		//System.out.println(expectedTitle);
		// Thread.sleep(2000);
		if (title.matches(expectedTitle)) {
			System.out.println("Check passed expected title matches the opened page");
		} else {
			System.out.println("Check failed expected title doesnot match the opened page");
		}
		// driver.findElement(By.xpath("//div[@class='frameSectionBody']//a[text()='Create
		// Lead']")).click();
		WebElement detailPageName = driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']"));
		//System.out.println(detailPageName.getAttribute("value"));
		String duplicatePageName = detailPageName.getAttribute("Value");
		System.out.println("First resulting name is " + duplicatePageName);
		// Thread.sleep(5000);
		if (name.matches(duplicatePageName)) {
			System.out.println("Check passed expected name matches the opened page name");
		} else {
			System.out.println("Check failed expected name doesnot match the opened page name");
		}
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//a[text()='Create Lead']")).click();
		driver.close();

	}

}

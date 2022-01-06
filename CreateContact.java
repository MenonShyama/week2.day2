package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("shyama");
		driver.findElement(By.id("lastNameField")).sendKeys("Menon");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("shyama");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("menon");
		driver.findElement(By.xpath("//input[@id='createContactForm_departmentName']")).sendKeys("Info");
		driver.findElement(By.xpath("//textarea[@id='createContactForm_description']")).sendKeys("Selenium automation sample");
		driver.findElement(By.xpath("//span[contains(text(),'E-Mail')]/following::input[@id='createContactForm_primaryEmail']")).sendKeys("shyamamenon19@gmail.com");
		driver.findElement(By.xpath("//select[@id='createContactForm_generalStateProvinceGeoId']/option[text()='New York']")).click();
		driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Edit']")).click();
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_description']")).clear();
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_importantNote']")).sendKeys("Selenium imporant note");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		System.out.println(driver.getTitle());	
		
		
	}

}

package demoblaze;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactUs {
	WebDriver driver;
	@BeforeTest
	public void beforeTest() throws InterruptedException
	{
		System.out.println("TEST EXECUTION BEGINS...");
		String chromeDriverPath = System.setProperty("user.dir",  "\\chromedriver.exe");
		System.out.println(chromeDriverPath);
		driver=new ChromeDriver();
		driver.navigate().to("https://www.demoblaze.com");   
		driver.manage().window().maximize();

		System.out.println("Welcome to DEMOBLAZE...");
	}
	@Test
	public void demoBlazeContact() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("Contact")).click();
	  	driver.findElement(By.id("recipient-email")).sendKeys("xyz@gmail.com");
		driver.findElement(By.id("recipient-name")).sendKeys("123");
		driver.findElement(By.id("message-text")).sendKeys("Test message!!");

		driver.findElement(By.xpath("//button[contains(text(),'Send message')]")).click();
		WebDriverWait wait=new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.alertIsPresent());

		driver.switchTo().alert().accept();

	}
	@AfterTest
	public void afterTest() 
	{
		System.out.println("TEST EXECUTION ENDS...");
		driver.close();
	}
}

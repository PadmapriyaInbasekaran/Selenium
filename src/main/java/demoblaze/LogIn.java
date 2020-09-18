package demoblaze;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogIn {
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
	public void demoBlazeLogIn() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Log in")).click();
		
		driver.findElement(By.id("loginusername")).sendKeys("Padmapriya");
		
		driver.findElement(By.id("loginpassword")).sendKeys("123");
		
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

	}
	@AfterTest
	public void afterTest() 
	{
		System.out.println("TEST EXECUTION ENDS...");
		driver.close();
	}
}

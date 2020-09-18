package demoblaze;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyCart {
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
	public void demoBlazeVerifyCart() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Cart")).click();
	
}	@AfterTest
	public void afterTest() 
	{
		System.out.println("TEST EXECUTION ENDS...");
		driver.close();
	}

}

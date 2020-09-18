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

public class AddToCart {
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
	public void demoBlazeAddToCart() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Samsung galaxy s7")).click();
		
		driver.findElement(By.linkText("Add to cart")).click();
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

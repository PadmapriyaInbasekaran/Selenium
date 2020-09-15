package com.atmecs.selenium;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoBlaze {
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException
	{
		System.out.println("TEST EXECUTION BEGINS...");
		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\padmapriya.i\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@BeforeClass
public void beforeClass() throws InterruptedException
{
		driver.navigate().to("https://www.demoblaze.com");   
		driver.manage().window().maximize();
		
		System.out.println("Welcome to DEMOBLAZE...");
	
}
@Test(priority=0)
public void demoBlazeSignUp() throws InterruptedException
{
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	driver.findElement(By.linkText("Sign up")).click();
Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='sign-username']")).sendKeys("PadmapriyaInb");
	driver.findElement(By.id("sign-password")).sendKeys("123");
	
	driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
	WebDriverWait wait=new WebDriverWait(driver, 2000);
	wait.until(ExpectedConditions.alertIsPresent());

	driver.switchTo().alert().accept();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//button[contains(text(),'Close')])[2]")).click();
}
@Test(priority=1)
public void demoBlazeLogIn() throws InterruptedException
{
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	driver.findElement(By.linkText("Log in")).click();
	
	driver.findElement(By.id("loginusername")).sendKeys("Padmapriya");
	
	driver.findElement(By.id("loginpassword")).sendKeys("123");
	
	driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

}
@Test(priority=2)
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
	@Test(priority=3)
	public void demoBlazeAddToCart() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Samsung galaxy s7")).click();
		
		driver.findElement(By.linkText("Add to cart")).click();
		WebDriverWait wait=new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.alertIsPresent());

		driver.switchTo().alert().accept();
	
}
	@Test(priority=4)
	public void demoBlazeVerifyCart() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Cart")).click();
	
}
	@AfterTest
	public void afterTest() 
	{
		System.out.println("TEST EXECUTION ENDS...");
		driver.close();
	}
}
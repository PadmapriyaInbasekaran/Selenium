package com.atmecs.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ixigo {
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
		driver.navigate().to("https://www.ixigo.com/");   
		driver.manage().window().maximize();

		System.out.println("Welcome...");

	}
	@Test 
	public void booking() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath("(//input[@placeholder='Enter city or airport'])[1]"));
		element1.click();
		Thread.sleep(2000);
		element1.sendKeys("Che");
		element1.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//input[@placeholder='Enter city or airport'])[2]")).sendKeys("Bom");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Depart']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@data-date='19092020']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Return']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@data-date='22092020']")).click();
		driver.findElement(By.xpath("(//div[@class='u-ripple'])[1]")).click();
	}
	@AfterTest
	public void afterTest() 
	{

		System.out.println("TEST EXECUTION ENDS...");
		driver.close();
	}
}

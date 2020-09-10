package com.atmecs.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class AmazonLogin {
	WebDriver driver;
	
	@BeforeClass
public void beforeClass() throws InterruptedException
{
		driver.navigate().to("https://www.amazon.com");   
		driver.manage().window().maximize();
		Thread.sleep(1000);
		System.out.println("Welcome to amazon...");
	
}
	@BeforeTest
	public void beforeTest() throws InterruptedException
	{
		System.out.println("TEST EXECUTION BEGINS...");
		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\padmapriya.i\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
	
	
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("METHOD EXECUTION BEGINS...");
	}
	@Test
	public void amazonLogin() 

	{
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Computers");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
	}
	@AfterMethod
	public void afterMethod()
	{
		driver.navigate().back();
		System.out.println("METHOD EXECUTION ENDS...");
	}
	@Test
	public void amazonTest() 
	{
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptops");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
		System.out.println("TEST EXECUTION ENDS...");
	}
}
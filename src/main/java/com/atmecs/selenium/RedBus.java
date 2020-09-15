package com.atmecs.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RedBus {
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
		driver.navigate().to("https://www.redbus.in/"); 
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		System.out.println("Welcome...");

	}
	@Test
	public void booking() throws InterruptedException
	{
		
	}
}

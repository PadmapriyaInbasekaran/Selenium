package com.atmecs.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
		driver.findElement(By.xpath("//*[@id=\'content\']/div/div[1]/div[6]/div/nav/span[2]/span")).click();
		WebElement field1 =	driver.findElement(By.xpath("//*[@id=\'content\']/div/div[1]/div[6]/div/div/div[1]/div/div[1]/input"));
		field1.click();
		field1.sendKeys("che");
		Thread.sleep(2000);
		field1.sendKeys(Keys.ENTER);
		
		WebElement field2 =	driver.findElement(By.xpath("//*[@id=\'content\']/div/div[1]/div[6]/div/div/div[3]/div/div[1]/input"));
		field2.click();
		field2.sendKeys("ben");
		Thread.sleep(2000);
		field2.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'content\']/div/div[1]/div[6]/div/div/div[4]/div/div[1]/div/input")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/table/tbody/tr[3]/td[4]/div[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'content\']/div/div[1]/div[6]/div/div/div[4]/div/div[2]/div[2]/input")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/table/tbody/tr[3]/td[7]/div[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'content\']/div/div[1]/div[6]/div/div/div[5]/div/div[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\'content\']/div/div[1]/div[6]/div/div/div[5]/div/div[2]/div[2]/div[1]/div[2]/span[5]")).click();
	}
}

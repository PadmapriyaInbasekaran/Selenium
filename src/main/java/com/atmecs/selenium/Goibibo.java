package com.atmecs.selenium;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Goibibo {
	WebDriver driver;
	Properties prop ;
	@BeforeTest
	public void beforeTest() throws InterruptedException, IOException
	{
		System.out.println("TEST EXECUTION BEGINS...");
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\atmecs\\selenium\\locators.properties");
		prop = new Properties();
		prop.load(file);
	}
	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{
		String chromeDriverPath = System.setProperty("user.dir",  "\\chromedriver.exe");
		System.out.println(chromeDriverPath);
		driver=new ChromeDriver();
		driver.navigate().to("https://www.goibibo.com/flights/");   
		driver.manage().window().maximize();

	}
	@Test(priority=0)
	public void signup() throws InterruptedException
	{
		driver.findElement(By.linkText("Sign up")).click();
		Thread.sleep(5000);
		driver.switchTo().frame("authiframe");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id=\'authFBSignInBtn\']")).click();
		Thread.sleep(2000);
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
				driver.findElement(By.id("email")).sendKeys("xyzz");
				driver.findElement(By.id("pass")).sendKeys("123");
				driver.findElement(By.name("login")).click();
				Thread.sleep(5000);
				WebElement text = 	driver.findElement(By.id("error_box"));
				System.out.println(text.getText());	

			}
		}

	}
	@Test (priority=1)
	public void booking() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.findElement(By.id((prop.getProperty("RoundTrip_id")))).click();
		WebElement field1 =	driver.findElement(By.id(prop.getProperty("From_id")));
		field1.click();
		field1.sendKeys("che");
		Thread.sleep(2000);
		field1.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		field1.sendKeys(Keys.ENTER);

		WebElement field2 =	driver.findElement(By.id(prop.getProperty("To_id")));
		field2.click();
		field2.sendKeys("ban");
		Thread.sleep(2000);
		field2.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		field2.sendKeys(Keys.ENTER);

		driver.findElement(By.id(prop.getProperty("Departure_id"))).click();
		driver.findElement(By.id(prop.getProperty("Date16"))).click();

		driver.findElement(By.id(prop.getProperty("Return_id"))).click();
		driver.findElement(By.id(prop.getProperty("Date18"))).click();
		Thread.sleep(2000);
		driver.findElement(By.id(prop.getProperty("Travel_id"))).click();
		Thread.sleep(2000);
		for(int i=0;i<4;i++)
		{
			driver.findElement(By.id(prop.getProperty("Passengers"))).click();
		}
		driver.findElement(By.id(prop.getProperty("Search_btn"))).click();
		Thread.sleep(10000);
		driver.close();
	}
	@AfterMethod
	public void afterMethod() 
	{
		driver.quit();
	}
	@AfterTest
	public void afterTest() 
	{
		System.out.println("TEST EXECUTION ENDS...");
	}
}

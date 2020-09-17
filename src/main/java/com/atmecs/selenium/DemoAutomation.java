package com.atmecs.selenium;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoAutomation {
	WebDriver driver;
	WebElement txt;

	@BeforeTest
	public void beforeTest() throws InterruptedException
	{
		System.out.println("TEST EXECUTION BEGINS...");

	}
	@BeforeClass
	public void beforeClass() throws InterruptedException
	{
		String chromeDriverPath = System.setProperty("user.dir",  "\\chromedriver.exe");
		System.out.println(chromeDriverPath);
		driver=new ChromeDriver();
		driver.navigate().to("http://demo.automationtesting.in/Register.html");   
		driver.manage().window().maximize();

		System.out.println("Welcome...");

	}
	@Test
	public void register() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@ng-model='FirstName']")).sendKeys("Padmapriya"); //firstName
		driver.findElement(By.xpath("//*[@ng-model='LastName']")).sendKeys("Inbasekaran"); //lastName
		driver.findElement(By.xpath("//*[@ng-model='Adress']")).sendKeys("Chennai,Tamilnadu");  //address
		driver.findElement(By.xpath("//*[@ng-model='EmailAdress']")).sendKeys("abcd@gmail.com"); //email

		driver.findElement(By.xpath("//*[@ng-model='Phone']")).sendKeys("9234567747");  //mobileNo
		driver.findElement(By.xpath("//*[@value='FeMale']")).click();  //gender
		driver.findElement(By.xpath("//*[@id='checkbox2']")).click();  //hobby
		Thread.sleep(2000);

		WebElement element8 =	driver.findElement(By.xpath("//*[@id='msdd']"));  
		element8.click();
		Thread.sleep(1000);
		WebElement element9 =	driver.findElement(By.xpath("//a[contains(text(),'Danish')]"));
		element9.click();
		Thread.sleep(1000);
		WebElement element10 =	driver.findElement(By.xpath("//a[contains(text(),'French')]"));
		element10.click();
		driver.findElement(By.xpath("//form[@id='basicBootstrapForm']")).click();
		Thread.sleep(10000);

		WebElement element1 =	driver.findElement(By.xpath("//*[@id='Skills']"));  
		element1.click();
		element1.sendKeys("Ja");
		element1.sendKeys(Keys.ENTER);          //skills

		WebElement element2 =	driver.findElement(By.xpath("//*[@id='countries']"));
		element2.click();
		element2.sendKeys("In");
		element2.sendKeys(Keys.ENTER);        //country
		Thread.sleep(3000);

		WebElement txt8 = driver.findElement (By.xpath("//*[@id=\'basicBootstrapForm\']/div[10]/div/span/span[1]/span"));
		txt8.click();
		Thread.sleep(3000);
		txt8.sendKeys(Keys.DOWN);
		txt8.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		WebElement element3 = driver.findElement(By.id("yearbox"));
		element3.click();
		for(int i=0;i<10;i++)
		{
			element3.sendKeys(Keys.ARROW_DOWN);
		}
		element3.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		WebElement element4 = driver.findElement(By.xpath("//*[@ng-model='monthbox']"));
		element4.click();
		for(int i=0;i<5;i++)
		{
			element4.sendKeys(Keys.ARROW_DOWN);
		}
		element4.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		WebElement element5 = driver.findElement(By.id("daybox"));
		element5.click();
		for(int i=0;i<10;i++)
		{
			element5.sendKeys(Keys.ARROW_DOWN);
		}
		element5.sendKeys(Keys.ENTER);
		Thread.sleep(10000);

		WebElement element6 =	driver.findElement(By.xpath("//*[@ng-model='Password']"));
		element6.click();
		element6.sendKeys("Welcome@123");
		Thread.sleep(10000);

		WebElement element7 =	driver.findElement(By.xpath("//*[@ng-model='CPassword']"));
		element7.click();
		element7.sendKeys("Welcome@123");
		driver.findElement(By.id("submitbtn")).click();
		Thread.sleep(10000);

	}
	@AfterTest
	public void afterTest() 
	{

		System.out.println("TEST EXECUTION ENDS...");
		driver.quit();
	}
}
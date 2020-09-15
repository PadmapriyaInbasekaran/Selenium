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
		String chromeDriverPath = System.getProperty("user.dir")+"\\chromedriver.exe";
		
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
Thread.sleep(1000);
		WebElement txt9 =	driver.findElement(By.xpath("//*[@id='msdd']"));  
		//Thread.sleep(1000);
		txt9.click();
		Thread.sleep(1000);
		WebElement txt10 =	driver.findElement(By.linkText("Danish"));
		Thread.sleep(1000);
		txt10.sendKeys(Keys.ENTER); 
		
		WebElement txt1 =	driver.findElement(By.xpath("//*[@id='Skills']"));  
		txt1.click();
		txt1.sendKeys("Ja");
		txt1.sendKeys(Keys.ENTER);          //skills

		WebElement txt3 =	driver.findElement(By.xpath("//*[@id='countries']"));
		txt3.click();
		txt3.sendKeys("In");
		txt3.sendKeys(Keys.ENTER);        //country
		Thread.sleep(3000);

		WebElement txt8 = driver.findElement (By.xpath("//*[@id=\'basicBootstrapForm\']/div[10]/div/span/span[1]/span"));
		txt8.click();
		Thread.sleep(3000);
		txt8.sendKeys("Den");
		txt8.sendKeys(Keys.DOWN);
		txt8.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		WebElement txt4 = driver.findElement(By.id("yearbox"));
		txt4.click();
		for(int i=0;i<10;i++)
		{
			txt4.sendKeys(Keys.ARROW_DOWN);
		}
		txt4.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		WebElement txt5 = driver.findElement(By.xpath("//*[@ng-model='monthbox']"));
		txt5.click();
		for(int i=0;i<5;i++)
		{
			txt5.sendKeys(Keys.ARROW_DOWN);
		}
		txt5.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		WebElement txt6 = driver.findElement(By.id("daybox"));
		txt5.click();
		for(int i=0;i<10;i++)
		{
			txt6.sendKeys(Keys.ARROW_DOWN);
		}
		txt6.sendKeys(Keys.ENTER);
		Thread.sleep(10000);

		WebElement txt2 =	driver.findElement(By.xpath("//*[@ng-model='Password']"));
		txt2.click();
		txt2.sendKeys("Welcome@123");
		Thread.sleep(10000);

		WebElement txt7 =	driver.findElement(By.xpath("//*[@ng-model='CPassword']"));
		txt7.click();
		txt7.sendKeys("Welcome@123");
		driver.findElement(By.id("submitbtn")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("error_box")).getText();
	}
	@AfterTest
	public void afterTest() 
	{

		System.out.println("TEST EXECUTION ENDS...");
		driver.close();
	}
}
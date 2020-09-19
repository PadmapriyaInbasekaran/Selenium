package demoautomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
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

public class Register {
	WebDriver driver;
	WebElement txt;
	FileInputStream file;
	Properties prop;
	FileInputStream file1;
	Properties prop1;
	@BeforeTest
	public void beforeTest() throws InterruptedException, IOException
	{
		System.out.println("TEST EXECUTION BEGINS...");
		file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\atmecs\\selenium\\RegisterLocators.properties");
		prop = new Properties();
		prop.load(file);
		file1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\atmecs\\selenium\\RegisterData.properties");
		prop1 = new Properties();
		prop1.load(file1);
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
		driver.findElement(By.xpath(prop.getProperty("FirstName"))).sendKeys(prop1.getProperty("FirstName")); //firstName
		driver.findElement(By.xpath(prop.getProperty("LastName"))).sendKeys(prop1.getProperty("LastName")); //lastName
		driver.findElement(By.xpath(prop.getProperty("Address"))).sendKeys(prop1.getProperty("Address"));  //address
		driver.findElement(By.xpath(prop.getProperty("EmailAdress"))).sendKeys(prop1.getProperty("EmailAdress")); //email

		driver.findElement(By.xpath(prop.getProperty("PhoneNo"))).sendKeys(prop1.getProperty("PhoneNo"));  //mobileNo
		driver.findElement(By.xpath(prop.getProperty("Gender"))).click();  //gender
		driver.findElement(By.xpath(prop.getProperty("Hobby"))).click();  //hobby
		Thread.sleep(2000);

		WebElement element8 =	driver.findElement(By.xpath(prop.getProperty("Language")));  
		element8.click();
		Thread.sleep(1000);
		WebElement element9 =	driver.findElement(By.xpath(prop.getProperty("Danish")));
		element9.click();
		Thread.sleep(1000);
		WebElement element10 =	driver.findElement(By.xpath(prop.getProperty("French")));
		element10.click();
		driver.findElement(By.xpath(prop.getProperty("Form_click"))).click();
		Thread.sleep(10000);

		WebElement element1 =	driver.findElement(By.xpath(prop.getProperty("Skills")));  
		element1.click();
		element1.sendKeys("Ja");
		element1.sendKeys(Keys.ENTER);          //skills

		WebElement element2 =	driver.findElement(By.xpath(prop.getProperty("Country")));
		element2.click();
		element2.sendKeys("In");
		element2.sendKeys(Keys.ENTER);        //country
		Thread.sleep(3000);

		WebElement txt8 = driver.findElement (By.xpath(prop.getProperty("SelectCountry")));
		txt8.click();
		Thread.sleep(3000);
		txt8.sendKeys(Keys.DOWN);
		txt8.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		WebElement element3 = driver.findElement(By.id(prop.getProperty("Year")));
		element3.click();
		for(int i=0;i<10;i++)
		{
			element3.sendKeys(Keys.ARROW_DOWN);
		}
		element3.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		WebElement element4 = driver.findElement(By.xpath(prop.getProperty("Month")));
		element4.click();
		for(int i=0;i<5;i++)
		{
			element4.sendKeys(Keys.ARROW_DOWN);
		}
		element4.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		WebElement element5 = driver.findElement(By.id(prop.getProperty("Date")));
		element5.click();
		for(int i=0;i<10;i++)
		{
			element5.sendKeys(Keys.ARROW_DOWN);
		}
		element5.sendKeys(Keys.ENTER);
		Thread.sleep(10000);

		WebElement element6 =	driver.findElement(By.xpath(prop.getProperty("Pwd")));
		element6.click();
		element6.sendKeys(prop1.getProperty("Pwd"));
		Thread.sleep(10000);

		WebElement element7 =	driver.findElement(By.xpath(prop.getProperty("ConfirmPwd")));
		element7.click();
		element7.sendKeys(prop1.getProperty("ConfirmPwd"));
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

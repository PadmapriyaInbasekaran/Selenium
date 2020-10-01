package goibibo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp {
	WebDriver driver;
	Properties prop ;
	Properties prop1 ;
	FileInputStream file1;
	FileInputStream file;
	@BeforeTest
	public void beforeTest() throws InterruptedException, IOException
	{
		System.out.println("TEST EXECUTION BEGINS...");
		
	}
	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException
	{
		file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\atmecs\\selenium\\GoibiboLocators.properties");
		prop = new Properties();
		prop.load(file);
		
		file1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\atmecs\\selenium\\GoibiboData.properties");
		prop1 = new Properties();
		prop1.load(file1);
		String chromeDriverPath = System.setProperty("user.dir",  "\\chromedriver.exe");
		System.out.println(chromeDriverPath);
		driver=new ChromeDriver();
		driver.navigate().to("https://www.goibibo.com/flights/");   
		driver.manage().window().maximize();

	}
	@Test
	public void signup() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.id(prop.getProperty("SignUp_id"))).click();
		Thread.sleep(5000);
		driver.switchTo().frame("authiframe");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("SignInToFB"))).click();
		Thread.sleep(2000);
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
				driver.findElement(By.id(prop.getProperty("FacebookUname"))).sendKeys(prop1.getProperty("FacebookUname"));
				driver.findElement(By.id(prop.getProperty("FacebookPwd"))).sendKeys(prop1.getProperty("FacebookPwd"));
				driver.findElement(By.name(prop.getProperty("LoginButton"))).click();
				Thread.sleep(5000);
				WebElement text = 	driver.findElement(By.id(prop.getProperty("ErrorMessage")));
				System.out.println(text.getText());	

			}
		}

	}
	
	@AfterMethod
	public void afterMethod() 
	{
		driver.quit();
	}
	@AfterTest
	public void afterTest() throws IOException 
	{
		file1.close();
		file.close();
		System.out.println("TEST EXECUTION ENDS...");
	}
}

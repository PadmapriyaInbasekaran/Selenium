package phptravels;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChatBox {
	WebDriver driver;
	Properties prop ;
	Properties prop1 ;
	@BeforeTest
	public void beforeTest() throws InterruptedException, IOException
	{
		System.out.println("TEST EXECUTION BEGINS...");
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\atmecs\\selenium\\phpTravelsLocators.properties");
				prop = new Properties();
				prop.load(file);
				FileInputStream file1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\atmecs\\selenium\\phpTravelsData.properties");
				prop1 = new Properties();
				prop1.load(file1);
	}
	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{
		String chromeDriverPath = System.setProperty("user.dir",  "\\chromedriver.exe");
		System.out.println(chromeDriverPath);
		driver=new ChromeDriver();
		driver.navigate().to("https://www.phptravels.com/");   
		driver.manage().window().maximize();
	}
	@Test
	public void chatBox() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(10000);
		driver.switchTo().frame("chat-widget");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("chatIcon"))));
		Thread.sleep(3000);
		WebElement	chatIcon = 	driver.findElement(By.xpath(prop.getProperty("chatIcon")));
		js.executeScript("arguments[0].click();", chatIcon);
		Thread.sleep(3000);
		driver.findElement(By.id(prop.getProperty("Name"))).sendKeys(prop1.getProperty("Name"));
		Thread.sleep(5000);
		WebElement element2 = driver.findElement(By.xpath(prop.getProperty("WhatsappNumber")));
		element2.click();
		element2.sendKeys(prop1.getProperty("WhatsappNumber"));
		Thread.sleep(3000);
		driver.findElement(By.id(prop.getProperty("Email"))).sendKeys(prop1.getProperty("Email"));
		Thread.sleep(3000);
		Select s=new Select(driver.findElement(By.xpath(prop.getProperty("DropDown"))));
		s.selectByValue("index1_1");
		Thread.sleep(3000);
		WebElement	button = driver.findElement(By.xpath(prop.getProperty("StartChat")));
		js.executeScript("arguments[0].click();", button);
		Thread.sleep(3000);
	}
	@AfterTest
	public void afterTest() 
	{
		driver.quit();
		System.out.println("TEST EXECUTION ENDS...");
	}
}


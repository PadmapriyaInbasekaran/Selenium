package phptravels;

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

public class ChatBox  {
	WebDriver driver;
	Properties prop ;
	@BeforeTest
	public void beforeTest() throws InterruptedException, IOException
	{
		System.out.println("TEST EXECUTION BEGINS...");
		//		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\atmecs\\selenium\\locators.properties");
		//		prop = new Properties();
		//		prop.load(file);
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
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Open LiveChat chat widget']")));
	Thread.sleep(3000);
	WebElement	chatIcon = 	driver.findElement(By.xpath("//div[@aria-label='Open LiveChat chat widget']"));
	js.executeScript("arguments[0].click();", chatIcon);
	Thread.sleep(3000);
	driver.findElement(By.id("name")).sendKeys("Abc123");
	Thread.sleep(5000);
	WebElement element2 = driver.findElement(By.xpath("(//input[@class='lc-1gz7fd7 e1xplv9i0'])[2]"));
	element2.click();
	element2.sendKeys("9123456780");
	Thread.sleep(3000);
	driver.findElement(By.id("email")).sendKeys("xyz@gmail.com");
	Thread.sleep(3000);
	Select s=new Select(driver.findElement(By.xpath("//select[@class='lc-jjhb0i egtcv0s1']")));
	s.selectByValue("index1_1");
	Thread.sleep(3000);
	WebElement	button = driver.findElement(By.xpath("//button[@class='lc-tf4jp6 esv0owm0']"));
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

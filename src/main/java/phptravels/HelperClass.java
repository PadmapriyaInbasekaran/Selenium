package phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperClass extends ChatBox1{
WebDriver driver;
public HelperClass(WebDriver driver)
{
	this.driver = driver;
}
public void SelectElement(String xpath , String value)
{
	Select s=new Select(driver.findElement(By.xpath(xpath)));
	s.selectByValue(value);
}
}
//By.xpath(prop.getProperty("DropDown"))
//"index1_1"
package extentReportsPackage;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TypeInGoogle extends BaseClass{
	WebDriver driver;
	
	@Test
	public void Entervalue() throws AWTException {
		
		driver = driver_open();
		driver.manage().window().maximize();
		driver.get("https://google.co.in");
		WebElement enterbox=driver.findElement(By.name("q"));
		enterbox.sendKeys("n");
		driver.getTitle();
		Assert.assertTrue(false);
		driver.close();
	}

}

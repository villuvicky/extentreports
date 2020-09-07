package extentReportsPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LeafLinks extends BaseClass{
	WebDriver driver;
	
	@Test
	public void LinkOnLeaf() throws AWTException {
		
		driver = driver_open();
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Link.html");
		WebElement linktext = driver.findElement(By.linkText("Go to Home Page"));
		linktext.click();
		Assert.assertTrue(true);
		driver.close();
	}
}

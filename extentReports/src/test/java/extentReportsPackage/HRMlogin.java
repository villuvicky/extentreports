package extentReportsPackage;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HRMlogin extends BaseClass{
	WebDriver driver;
	
	@Test
	public void loginHRM() throws AWTException {
		//ExtentTest test1=extent.createTest("login");
		driver=driver_open();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		Assert.assertTrue(true);
		driver.close();
		

	}
}

package extentReportsPackage;


import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class BaseClass {

	WebDriver driver;
	
	
	WebDriver driver_open() {
		 driver= new ChromeDriver();
		return driver;
	}

	public String GetScreenshot(String TestcaseName,WebDriver driver) throws Exception {
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File sourcefile=screenshot.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\reports\\"+TestcaseName+".png";
		File destinstion= new File(path);
		FileHandler.copy(sourcefile, destinstion);
		return path;
	}
}

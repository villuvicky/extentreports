package extentReportsPackage;

import java.awt.Robot;
import java.awt.image.BufferedImage;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseClass implements ITestListener{

	ExtentReports extent=ExtentReporting.reporting();
	ExtentTest test;
	private static ThreadLocal<ExtentTest> SafeTest= new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		test= extent.createTest(result.getMethod().getMethodName());
		SafeTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		SafeTest.get().log(Status.PASS, "Successful");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		 WebDriver driver=null;
		 Object testobject=result.getInstance(); 
		 Class classObjects=result.getTestClass().getRealClass(); 
		 
		 try {
			driver=(WebDriver) classObjects.getDeclaredField("driver").get(testobject);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 

		SafeTest.get().fail(result.getThrowable());
		try {
			SafeTest.get().addScreenCaptureFromPath(GetScreenshot(result.getMethod().getMethodName(), driver),result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}

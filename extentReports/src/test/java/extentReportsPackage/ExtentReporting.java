package extentReportsPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporting {

	static ExtentReports extent;
	public static ExtentReports reporting() {
		
		String path= System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("HRM Login");
		reporter.config().setDocumentTitle("Web Automation Results");
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vicky");
		return extent;
	}
}

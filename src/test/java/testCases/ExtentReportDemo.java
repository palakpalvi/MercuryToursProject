package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo 
{
	public static ExtentTest parentTest=null;
	public static ExtentTest test=null;
	public static void main (String[] args)
	{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\TestResults\\extent.html");
		htmlReporter.config().setDocumentTitle("Automation Test Results");
		htmlReporter.config().setReportName("Smoke Test Report");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		parentTest = extent.createTest("TC001");
		test=parentTest.createNode("LoginPage");
		test.log(Status.PASS, "Username entered successfully");
		test.log(Status.PASS, "Password entered successfully");
		test.log(Status.PASS, "Submit button clicked successfully");
		test=parentTest.createNode("FlightSelectionPage");
		//parentTest = extent.createTest("FlightSelectionPage");
		test.log(Status.PASS, "Flight selected successfully");
		test.log(Status.PASS, "Date selected successfully");
		test.log(Status.PASS, "Serched button clicked succesffully");
		extent.flush();
		System.out.println("Test successfull");
	}
}

package testCases;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import baseUtil.BaseUtil;
import pageFunctions.FlightFinder;
import pageFunctions.LoginPage;
import utility.ExcelOperation;

public class TC001 extends BaseUtil{
	
	@BeforeTest
	public void startUp() throws IOException 
	{
		init();
		Log4jinit();
		launchApplication();
		extentReport();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="empLogin")
	public void tc001(
			//Login Page
			String userName, String password)
			//Search Flight Page
			/*String passengers, String departingFrom, String departingMonth, String departingDate, String arrivingFrom, String arrivingMonth, String arrivingDate, String airline
			)*/ throws IOException 
	{
		parentTest = extent.createTest("TC001");
		new LoginPage().login(userName,password);
		/*new FlightFinder().flightFinder(passengers, departingFrom, departingMonth, departingDate, 
				arrivingFrom, arrivingMonth, arrivingDate, airline);*/
	} 
	
	@AfterTest
	public void tearDown() 
	{
		driver.quit();
		extent.flush();
	}
	
	@DataProvider(name="empLogin")
	public static Object[][] loginData() throws IOException {
		Object[][] arrayObject = ExcelOperation.getExcelData(System.getProperty("user.dir")+"\\testDataFiles\\TestData.xlsx","Sheet1");
		return arrayObject;
	}
	}

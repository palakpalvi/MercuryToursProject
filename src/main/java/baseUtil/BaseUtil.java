package baseUtil;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseUtil 
{
	public static WebDriver driver=null;
	public static Properties prop=new Properties();
	public static Logger logger = null;
	public static ExtentTest parentTest=null;
	public static ExtentTest test=null;
	public static ExtentReports extent=null;
	
	public static void init() throws IOException
	{
		
	}
	
	public static void launchApplication()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public static void Log4jinit()
	{
		PatternLayout layout = new PatternLayout();
		String conversionPattern = "[%p] %d %c %M - %m%n";
		layout.setConversionPattern(conversionPattern);
		// creates daily rolling file appender
		DailyRollingFileAppender rollingAppender = new DailyRollingFileAppender();
		rollingAppender.setFile("app.log");
		rollingAppender.setDatePattern("'.'yyyy-MM-dd");
		rollingAppender.setLayout(layout);
		rollingAppender.activateOptions();
		// configures the root logger
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.addAppender(rollingAppender);
		// creates a custom logger and log messages
		logger = Logger.getLogger(BaseUtil.class);
		/*logger.debug("this is a debug log message");
		logger.info("this is a information log message");
		logger.warn("this is a warning log message");*/
	}
	public static void extentReport()
	{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\TestResults\\extent.html");
		htmlReporter.config().setDocumentTitle("Automation Test Results");
		htmlReporter.config().setReportName("Smoke Test Report");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
}

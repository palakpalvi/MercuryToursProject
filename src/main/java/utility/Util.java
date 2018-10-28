package utility;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.Status;

import baseUtil.BaseUtil;

public class Util extends BaseUtil
{
	public static void click(String xpath, String elementName)
	{
		driver.findElement(By.xpath(xpath)).click();
		logger.info("Clicked on "+elementName);
		test.log(Status.PASS, "Clicked on "+elementName);
	}
	public static void sendKeys(String xpath, String elementName, String value)
	{
		driver.findElement(By.xpath(xpath)).sendKeys(value);
		logger.info("Value entered in "+elementName);
		test.log(Status.PASS, "Value entered in "+elementName);
	}
	
	public static String screenshot() throws IOException 
	{
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String currentTime = timestamp.toString().replace(":", "-");
		String path = System.getProperty("user.dir")+"\\TestResults\\Screenshots\\screenshort"+currentTime+".png";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(path));
		return path;
	}
}

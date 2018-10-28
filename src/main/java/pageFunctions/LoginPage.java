package pageFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.log4j.Logger;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import baseUtil.BaseUtil;
import utility.Util;

public class LoginPage extends BaseUtil {
	
	public LoginPage() throws IOException 
	{
		logger=Logger.getLogger(LoginPage.class);
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\locators\\Login.properties");
		prop.load(fis);
	}
	public void login(String userName,String password) throws IOException 
	{
		test = parentTest.createNode("LoginPage");
		
		Util.sendKeys(prop.getProperty("userName"), "UserName", userName);
		Util.sendKeys(prop.getProperty("password"), "Password", password);
		Util.click(prop.getProperty("submitBtn"), "SubmitButton");
		//test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		
		test.log(Status.INFO, "All data entered in login page.",MediaEntityBuilder.createScreenCaptureFromPath(Util.screenshot()).build());
	}
}

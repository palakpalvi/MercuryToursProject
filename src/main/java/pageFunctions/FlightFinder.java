package pageFunctions;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import baseUtil.BaseUtil;
import utility.Util;

public class FlightFinder extends BaseUtil
{
	public FlightFinder() throws IOException 
	{
		logger=Logger.getLogger(FlightFinder.class);
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\locators\\FlightFinder.properties");
		prop.load(fis);
	}
	public void flightFinder(String passengers, String departingFrom, String departingMonth, String departingDate, 
			String arrivingFrom, String arrivingMonth, String arrivingDate,String airline) 
	{
		test = parentTest.createNode("FlightFinder");
		
		Util.click(prop.getProperty("roundTrip"),"radioButton");
		Util.sendKeys(prop.getProperty("passengers"), "Passengers", passengers);
		Util.sendKeys(prop.getProperty("departingFrom"), "departingCity", departingFrom);
		Util.sendKeys(prop.getProperty("departingMonth"), "departingMonth", departingMonth);
		Util.sendKeys(prop.getProperty("departingDate"), "departingDate", departingDate);
		Util.sendKeys(prop.getProperty("arrivingIn"), "arrivingCity", arrivingFrom);
		Util.sendKeys(prop.getProperty("arrivingMonth"), "arrivingMonth", arrivingMonth);
		Util.sendKeys(prop.getProperty("arrivingDate"), "arrivingDate", arrivingDate);
		Util.click(prop.getProperty("economyClass"), "serviceClass");
		Util.sendKeys(prop.getProperty("airline"), "airlineType", airline);
		Util.click(prop.getProperty("continueBtn"), "ContinueButton");
	}
}

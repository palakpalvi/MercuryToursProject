package testCases;

import java.sql.Timestamp;

public class TimeStampClass
{
	public static void main(String[] args)
	{
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp.toString().replace(":", "-"));
	}
}

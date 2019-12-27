package com.Rest_Assured_Automation.Base_Classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;

public class Test_Base_class
{
	public Properties prop_get ;
	public FileInputStream get_stream;
	public static Logger log = null ;
		
	public Test_Base_class()
	{
		prop_get = new Properties();

		try 
		{
			get_stream = new FileInputStream("F:\\Selenium\\Rest_Assured_Projects\\src\\main\\java\\com\\Rest_Assured_Automation\\config\\Get_config.properties");
			prop_get.load(get_stream);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	@BeforeTest
	public static void getlogger()
	{
		String log4j_filename = System.getProperty("F:\\Selenium\\FreeCRM_Automation\\src\\main\\resources\\com\\FreeCRM\\Resources\\log4j.properties");
		PropertyConfigurator.configure(log4j_filename);  
	}
}

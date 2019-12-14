package com.Rest_Assured_Automation.Base_Classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.Rest_Assured_Automation.Util_Classes.Test_Util_Class;

public class Test_Base_class extends Test_Util_Class
{
	public Properties prop_get ;
	public FileInputStream get_stream;

	public Test_Base_class()
	{
		prop_get = new Properties();
		
		try 
		{
			get_stream = new FileInputStream("F:\\Selenium\\Rest_Assurest_Projects\\src\\main\\java\\com\\Rest_Assured_Automation\\config\\Get_config.properties");
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
}

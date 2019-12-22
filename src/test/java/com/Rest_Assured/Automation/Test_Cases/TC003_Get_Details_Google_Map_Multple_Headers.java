package com.Rest_Assured.Automation.Test_Cases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Rest_Assured_Automation.Base_Classes.Test_Base_class;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_Get_Details_Google_Map_Multple_Headers extends Test_Base_class
{
	String Base_URI ;
	Response response;

	@BeforeTest
	public void set_up() 
	{
		System.out.println("*End Point URL is taken form the Config.Properties File*");
		String Base_URI_google = prop_get.getProperty("Base_URI_google");
		String Base_Path_gogle = prop_get.getProperty("Base_Path_gogle");
		Base_URI = Base_URI_google + Base_Path_gogle;
		System.out.println("End Point URL of the Request : -" +Base_URI);
	}
	@Test
	public void getting_store_details() 
	{
		RestAssured.baseURI = Base_URI;
		RequestSpecification http_request = RestAssured.given();
		response = http_request.request(Method.GET);

		Headers all_headers = response.getHeaders();
		System.out.println("-------- All Headers rom the Request--------");
		for (Header header : all_headers) 
		{
			System.out.println(header.getName()+"-->"+header.getValue());
		}
	}
	@AfterTest
	public void tear_down() 
	{
		System.out.println("*End Point URL is taken form the Config.Properties File*");
	}
}

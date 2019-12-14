package com.Rest_Assured.Automation.Test_Cases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Rest_Assured_Automation.Base_Classes.Test_Base_class;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Get_Request_Weather extends Test_Base_class
{
	String End_point_URI ; 
	Response response ; 
	@BeforeTest
	public void set_up()
	{
		System.out.println("*End Point URL is taken form the Config.Properties File*");
		String Base_URI = prop_get.getProperty("Base_URI_Weather");
		String Base_Path= prop_get.getProperty("Base_Path_Weather");
		End_point_URI = Base_URI + Base_Path;
		System.out.println("End Point URI : - "+End_point_URI);
	}

	@Test
	public void get_Weather_deatils()
	{
		RestAssured.baseURI = End_point_URI;
		RequestSpecification httprequst = RestAssured.given();
		response = httprequst.request(Method.GET);
		String response_body = response.getBody().asString();
		System.out.println("Response Body is : - "+response_body);
		
		int status_code = response.getStatusCode();
		Assert.assertEquals(status_code, Status_code200);
		
		String statusline = response.getStatusLine();
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}
	@AfterTest
	public void tear_down()
	{
       System.out.println("*Received Response Body and Validated*");
	}
}

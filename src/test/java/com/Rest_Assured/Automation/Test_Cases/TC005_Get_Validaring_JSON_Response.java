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

public class TC005_Get_Validaring_JSON_Response extends Test_Base_class
{
	String Base_URI;
	Response response ; 

	@BeforeTest
	public void set_up()
	{
		System.out.println("*End Point URL is taken form the Config.Properties File*");
		String Base_URI_JSON = prop_get.getProperty("Base_URI_JSON");
		String Base_Path_JSON= prop_get.getProperty("Base_Path_JSON");
		Base_URI = Base_URI_JSON + Base_Path_JSON ;
		System.out.println("Base URI of the Weather Request : - "+Base_URI);

	}

	@Test
	public void Getting_JSON_Response_Validating()
	{
      RestAssured.baseURI = Base_URI;
      RequestSpecification http_request = RestAssured.given();
      response = http_request.request(Method.GET);
      
      String Response_body = response.getBody().asString();
      System.out.println("Response Body of the Request : - "+Response_body);
      
      Assert.assertEquals(Response_body.contains("Bangalore"), true); 
	}
	@AfterTest
	public void tear_down()
	{
		System.out.println("*End Point URL is taken form the Config.Properties File*");
	}
}

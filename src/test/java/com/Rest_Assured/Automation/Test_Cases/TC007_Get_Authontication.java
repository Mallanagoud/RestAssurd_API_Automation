package com.Rest_Assured.Automation.Test_Cases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Rest_Assured_Automation.Base_Classes.Test_Base_class;
import com.Rest_Assured_Automation.Util_Classes.Test_Util_Class;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_Get_Authontication extends Test_Base_class
{
	String Base_URI = prop_get.getProperty("Base_URI_JSON_Auth");
	Response response ;

	@BeforeTest
	public void teardown()
	{
		System.out.println("*End Point URL is taken form the Config.Properties File*");	
		System.out.println("Base URI of the REquest : - "+Base_URI);
	}

	@Test
	public void Get_details_Using_AUTH()
	{
		RestAssured.baseURI = Base_URI;
		
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		
		auth.setUserName(prop_get.getProperty("Base_Username"));
		auth.setPassword(prop_get.getProperty("Base_Password"));
		
		RestAssured.authentication = auth;
	
        RequestSpecification http_request = RestAssured.given();
        
        response = http_request.request(Method.GET);
        
        int status_code = response.getStatusCode();
        System.out.println("Status Code Of the Request : - "+status_code);
        
        Assert.assertEquals(status_code, Test_Util_Class.Status_code200);
	}

	@BeforeTest
	public void setup()
	{
		System.out.println("*End Point URL is taken form the Config.Properties File*");	
	}
}

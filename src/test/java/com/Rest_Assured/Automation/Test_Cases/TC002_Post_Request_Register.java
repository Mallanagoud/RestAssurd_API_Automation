package com.Rest_Assured.Automation.Test_Cases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Rest_Assured_Automation.Base_Classes.Test_Base_class;
import com.Rest_Assured_Automation.Util_Classes.Test_Util_Class;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_Post_Request_Register extends Test_Base_class
{
	String End_Point_Url;

	@BeforeTest
	public void set_up() 
	{
		System.out.println("*End Point URL is taken form the Config.Properties File*");

		End_Point_Url = prop_get.getProperty("End_Point_URL");
		System.out.println("End Point URL : - "+End_Point_Url);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void Register_Cosumer()
	{
		RestAssured.baseURI = End_Point_Url;
		RequestSpecification httprequest = RestAssured.given();

		JSONObject json_obj = new JSONObject();

		json_obj.put("FirstName", prop_get.getProperty("FirstName"));
		json_obj.put("LastName", prop_get.getProperty("LastName"));
		json_obj.put("UserName", prop_get.getProperty("UserName"));
		json_obj.put("Password", prop_get.getProperty("Password"));
		json_obj.put("Email", prop_get.getProperty("Email"));

		httprequest.header("Content-Type","application/json");
		httprequest.body(json_obj.toJSONString());
		
		Response response = httprequest.request(Method.POST);

		String response_body = response.getBody().asString();
		System.out.println("Response Body : - "+response_body);

		int status_code = response.statusCode();
		Assert.assertEquals(status_code, Test_Util_Class.Status_code201);

		String SuccessCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(SuccessCode, "OPERATION_SUCCESS");
		
		String Message = response.jsonPath().get("Message");
		Assert.assertEquals(Message, "Operation completed successfully");
	}

	@AfterTest
	public void tear_down() 
	{
		System.out.println("*Received Response Body and Validated*");
	}
}

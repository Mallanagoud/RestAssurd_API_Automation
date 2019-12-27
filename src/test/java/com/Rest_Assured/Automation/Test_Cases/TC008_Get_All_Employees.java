package com.Rest_Assured.Automation.Test_Cases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import com.Rest_Assured_Automation.Base_Classes.Test_Base_class;
import com.Rest_Assured_Automation.Util_Classes.Test_Util_Class;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC008_Get_All_Employees extends Test_Base_class
{
	public static Logger log = Logger.getLogger(TC008_Get_All_Employees.class.getName()); 
	String base_URI;
	Response response ; 
	@BeforeTest
	public void setup()
	{
		log.info("Starting the Get Employee Request");
		base_URI = prop_get.getProperty("Base_URI_Employees");
		log.info("Base URL of the Request : - "+base_URI);
	}

	@Test
	public void getting_the_Employees()
	{
		log.info("Getting the All Employess");
		RestAssured.baseURI = base_URI;
		RequestSpecification http_request = RestAssured.given();
		log.info("Getting all Reponse and Saving in Response Object");
		response = http_request.request(Method.GET);
		
		String body = response.getBody().asString();
		System.out.println("Response Body :-"+body);
		
		int Status_code = response.getStatusCode();
		
		log.info("Status Code : - "+Status_code);
		log.info("Validating the Status Code");
		Assert.assertEquals(Status_code, Test_Util_Class.Status_code200);
	}

	@AfterTest
	public void teardown()
	{
		log.info("End of the Request");
	}
}

package com.Rest_Assured.Automation.Test_Cases;

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

public class TC009_Get_Single_Employee_From_Request extends Test_Base_class
{
	String Base_URI ;
	Response response ;

	@BeforeTest
	public void setup()
	{
		String URI = prop_get.getProperty("Base_URI_Employee");
		String emp_ID = prop_get.getProperty("Employee_ID");
		Base_URI  =URI + emp_ID ; 
	}
	@Test
	public void Get_single_employee_details()
	{
		RestAssured.baseURI = Base_URI;
		RequestSpecification http_request = RestAssured.given();

		response = http_request.request(Method.GET);

		String resonse_body = response.getBody().asString();
		System.out.println("Response Body : - "+resonse_body);

		int status_code = response.getStatusCode();
		System.out.println("Status Code : "+status_code);

		Assert.assertEquals(status_code, Test_Util_Class.Status_code200);

		String status_line = response.statusLine();
		System.out.println("Status Line : "+status_line);

		Assert.assertEquals(status_line, "HTTP/1.1 200 OK");

		String contenttype = response.getHeader("Content-Type");
		System.out.println("Content Type of Request : "+contenttype);

		Assert.assertEquals(contenttype, "text/html; charset=UTF-8");

		String contentlength = response.header("Content - Length");
		System.out.println("Content Lenght : - "+contentlength);

		Assert.assertEquals(contentlength, null);

		String servertype = response.getHeader("Server");
		System.out.println("Server type of The Request : "+servertype);

		Assert.assertEquals(servertype, "nginx/1.16.0");

	}
	@AfterTest
	public void teardown()
	{

	}

}

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

public class TC004_Get_Details_Stores_Single_Header extends Test_Base_class
{
	String base_URI;
	Response response ; 

	@BeforeTest
	public void set_up() 
	{
		System.out.println("*End Point URL is taken form the Config.Properties File*");
		String Base_URI_Mi_Store = prop_get.getProperty("Base_URI_Mi_Store");
		String Base_Path_Mi_Store = prop_get.getProperty("Base_Path_Mi_Store");
		base_URI = Base_URI_Mi_Store + Base_Path_Mi_Store;
		System.out.println("Base URI of the MI Store in Kammanahalli : - "+base_URI);
	}
	@Test
	public void getting_store_details_() 
	{
		RestAssured.baseURI = base_URI;
		RequestSpecification httprequest  = RestAssured.given();
		response = httprequest.request(Method.GET);

		String Respnse_body = response.body().asString();
		System.out.println("Respnse Body of the Mi Stores in Kammanahalli : - "+Respnse_body);

		int status_code = response.getStatusCode();
		System.out.println("Status Code of the Mi Store Request : -"+status_code);
		Assert.assertEquals(status_code, Status_code200);

		String content_type = response.getHeader("Content-Type");
		System.out.println("Content-Type of Header : - "+content_type);
		Assert.assertEquals(content_type, "text/html; charset=ISO-8859-1");

	}
	@AfterTest
	public void tear_down() 
	{
		System.out.println("*End Point URL is taken form the Config.Properties File*");
	}
}

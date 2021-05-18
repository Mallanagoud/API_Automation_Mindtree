package com.student.JunitTest_classes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;

@RunWith(SerenityRunner.class)
public class Assessment4
{
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI = "http://postman-echo.com";
	}

	@Test()
	public void LoggingintotheURL()
	{
		int statuscode = SerenityRest.rest().given()
		.auth().preemptive()
		.basic("postman", "password")
		.when()
		.get("/basic-auth")
		.getStatusCode();
		
		System.out.println("Status Code - "+statuscode);
		
	}
	@AfterClass
	public static void teardown()
	{

	}
}
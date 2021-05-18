package com.student.JunitTest_classes;

import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(SerenityRunner.class)
public class Assessment3 {

	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI = "https://reqres.in/api/users";
	}

	@Test()
	public void verifyingEnrolltheMember()
	{
		JSONObject Obj = new JSONObject();
		Obj.put("name", "Ravindra");
		Obj.put("job", "Student");
		Response response = RestAssured.given()
		.body(Obj.toString())
		.post("/users");
		System.out.println("Response Body : - "+response.asString());
		System.out.println("Response Code - "+response.getStatusCode());
		Assert.assertEquals(201, response.getStatusCode());
	}
	@AfterClass
	public static void teardown()
	{

	}
    
}
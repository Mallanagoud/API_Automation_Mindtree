package com.student.JunitTest_classes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(SerenityRunner.class)
public class Assessment2
{
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI = "http://restcountries.eu/rest/v1/name";
	}

	@Test()
	public void gettingNorwayDetails()
	{
		RestAssured.given()
		.when()
		.get("/norway")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all()
		.and()
		.extract()
		.body()
		.asString()
		.contentEquals("Oslo");
		
	}
	@AfterClass
	public static void teardown()
	{

	}
}
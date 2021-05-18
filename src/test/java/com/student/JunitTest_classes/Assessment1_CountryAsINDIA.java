package com.student.JunitTest_classes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(SerenityRunner.class)
public class Assessment1_CountryAsINDIA
{
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI = "http://restcountries.eu/rest/v1/name";
	}

	@Test()
	public void gettingthe_INDIACounryDetails()
	{
		RestAssured.given()
		.when()
		.get("/INDIA")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all()
		.and()
		.extract()
		.body()
		.asString()
		.contentEquals("Republic of India");
		
	}
	@AfterClass
	public static void teardown()
	{

	}
}
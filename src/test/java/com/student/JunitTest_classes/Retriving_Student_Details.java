package com.student.JunitTest_classes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(SerenityRunner.class)
public class Retriving_Student_Details
{
	@BeforeClass
	public static void init()
	{
     RestAssured.baseURI = "http://localhost:8080/student";
	}

	@Test
	public void gettingallStudents()
	{
		RestAssured.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);
	}
	
	@AfterClass
	public static void teardown()
	{
		
	}
}

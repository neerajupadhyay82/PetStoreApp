package com.petstoreapp.junit;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(SerenityRunner.class)
public class SerenityTestGetMethods {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet";
	}
	
	@Test
	public void getAllPets() {
		 ArrayList<String> status = new ArrayList<String>();
		 status.add("available");
		 status.add("pending");
		 status.add("sold");
		 
		for(String statusName : status ) { 
			RestAssured.given() 
			  .when()
			  .get("/findByStatus?status="+statusName) 
			  .then() 
			  .log() 
			  .all()
			  .statusCode(200); }
			 
		}
	
}

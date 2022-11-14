package services;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class SFLeadMgmt extends BaseRequest{

	@Test(priority=0)
	public void createLead(){
		File ft= new File("./data/Lead1.json");
		 response = RestAssured.given().contentType(ContentType.JSON).body(ft).post("Lead");
		 
		 response.prettyPrint();
		 
			response.then().assertThat().statusCode(201);
			response.then().assertThat().time(Matchers.lessThan(8000L));
			String statusLine = response.statusLine();
			System.out.println(statusLine);
			System.out.println(response.time());
			System.out.println(response.jsonPath().get("id"));
		 LeadID = response.jsonPath().get("id");
	}
	
	@Test(priority=1)
	public void getLeadBeforeDelete(){
		 response = RestAssured.given().get("Lead/"+LeadID);
		 
			
		 response.then()
		.assertThat()
		.statusCode(200).extract().response().prettyPrint();
	}
	
	@Test(priority=2)
	public void deleteLead() {
		
		response = RestAssured.given().contentType(ContentType.JSON).delete("Lead/"+LeadID);
		response.then().assertThat().statusCode(204);
		response.then().assertThat().time(Matchers.lessThan(8000L));
		String statusLine = response.statusLine();
		System.out.println(statusLine);
		
	}

	
	@Test(priority=3)
	public void getAllLeads(){
	 RestAssured.given()
			.get("Lead")
			.then()
			.assertThat()
			.statusCode(200)
			.extract().response().prettyPrint();
				
	}

	@Test(priority=4)
	public void getDeletedLead(){
		 response = RestAssured.given().get("Lead/"+LeadID);
		 
		 response.prettyPrint();
		 response.then()
		.assertThat()
		.statusCode(404);
	}
}

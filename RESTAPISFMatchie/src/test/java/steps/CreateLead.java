package steps;

import java.io.File;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateLead extends Common{

	@When("User send POST request")
	public void sendPOSTRequest()
	{
		File ft= new File("./data/Lead1.json");
		 response = RestAssured.given().contentType(ContentType.JSON).body(ft).post("Lead");
	}
	@Then("Validate the POST response") 
    public void validatePOSTResponse()
    {
		System.out.println("-------------Create Lead sceanario starts----------");
		response.prettyPrint();
		response.then().assertThat().statusCode(201);
		response.then().assertThat().time(Matchers.lessThan(8000L));
		String statusLine = response.statusLine();
		System.out.println(statusLine);
		System.out.println(response.time());
		System.out.println(response.jsonPath().get("id"));
	 LeadID = response.jsonPath().get("id");
	 System.out.println("-------------Create Lead sceanario ends----------");
    }
}

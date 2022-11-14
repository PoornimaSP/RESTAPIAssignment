package steps;

import java.io.File;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateLead extends Common{
	@When("User send PATCH request")
	public void sendPATCHRequest()
	{
		File ft= new File("./data/Lead2.json");
		 response = RestAssured.given().contentType(ContentType.JSON).body(ft).patch("Lead/"+LeadID);
	}
	@Then("Validate the PATCH response") 
	public void validatePATCHResponse()
	{
		System.out.println("-------------Update Lead sceanario starts----------");
		response.then().assertThat().statusCode(204);
		response.then().assertThat().time(Matchers.lessThan(8000L));
		String statusLine = response.statusLine();
		System.out.println(statusLine);
		System.out.println("-------------Update Lead sceanario ends----------");
	}
}

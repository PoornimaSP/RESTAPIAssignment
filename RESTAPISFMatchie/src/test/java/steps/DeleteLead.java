package steps;

import java.io.File;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteLead extends Common{
	@When("User send DELETE request")
	public void sendDELETERequest()
	{
		
		 response = RestAssured.given().contentType(ContentType.JSON).delete("Lead/"+LeadID);
	}
	@Then("Validate the DELETE response")
	public void validateDELETEResponse()
	{
		System.out.println("-------------Delete Lead sceanario starts----------");
		response.then().assertThat().statusCode(204);
		response.then().assertThat().time(Matchers.lessThan(8000L));
		String statusLine = response.statusLine();
		System.out.println(statusLine);
		System.out.println("-------------Delete Lead sceanario ends----------");
	}
}

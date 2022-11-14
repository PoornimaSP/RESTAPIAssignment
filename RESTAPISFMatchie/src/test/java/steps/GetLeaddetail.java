package steps;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetLeaddetail extends Common{
	@When("User send GET request")
	public void sendGETRequest()
	{
		 response = RestAssured.given().contentType(ContentType.JSON).get("Lead/"+LeadID);
	}
	@Then("Validate the GET response")
	public void validateGETResponse()
	{
		 System.out.println("-------------Get Lead before delete sceanario starts----------");
		response.prettyPrint();
		System.out.println(response.jsonPath().get("Id"));
		System.out.println(response.jsonPath().get("Company"));
		response.then().assertThat().statusCode(200);
		response.then().assertThat().time(Matchers.lessThan(8000L));
		response.then().assertThat().body("Id", Matchers.equalTo(LeadID));
		String statusLine = response.statusLine();
		System.out.println(statusLine);
		 System.out.println("-------------Get Lead before delete sceanario ends----------");
	}
}

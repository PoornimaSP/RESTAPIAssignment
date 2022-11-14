package steps;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetLeaddetailafterDelete extends Common{
	@Then("Validate the GET response after delete")
	public void validateGETResponse()
	{
		System.out.println("-------------Get Lead after delete sceanario starts----------");
		response.prettyPrint();
		response.then().assertThat().statusCode(404);
		response.then().assertThat().time(Matchers.lessThan(8000L));
		String statusLine = response.statusLine();
		System.out.println(statusLine);
		System.out.println("-------------Get Lead after delete sceanario ends----------");
	}
}

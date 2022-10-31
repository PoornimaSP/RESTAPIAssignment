package jira_RestAssured;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETIssueBasedonKeyPostUpdate extends JIRABaseClass{
	
	@Test(dependsOnMethods="jira_RestAssured.UpdateJIRAIssue.runUpdateJIRAIssue")
	public void runGETJIRAIssue()
	{
		
		Response response = inputReq.get(keyval);	
		System.out.println("-----------------Get Issue Based on JIRA Key post Update-----------------");
		response.prettyPrint();
		System.out.println(response.jsonPath().get("key"));
		System.out.println(response.jsonPath().get("fields.description"));
		response.then().assertThat().statusCode(200);
		response.then().assertThat().body("key",Matchers.equalTo(keyval));
		response.then().assertThat().body("fields.description",Matchers.containsString("Updated"));
		System.out.println("------------------------------------------------------------");
	}

}

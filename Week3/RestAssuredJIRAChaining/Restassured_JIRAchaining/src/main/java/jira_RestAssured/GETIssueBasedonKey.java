package jira_RestAssured;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETIssueBasedonKey extends JIRABaseClass{
	
	@Test(dependsOnMethods="jira_RestAssured.CreateJIRAIssue.runCreateJIRAIssue")
	public void runGETJIRAIssue()
	{
		//inputReq.accept("application/json");	
		Response response = inputReq.get(keyval);	
		System.out.println("-----------------Get Issue Based on JIRA Key-----------------");
		response.prettyPrint();
		System.out.println(response.jsonPath().get("key"));
		response.then().assertThat().statusCode(200);
		response.then().assertThat().body("key",Matchers.equalTo(keyval));
		System.out.println("------------------------------------------------------------");
	}

}

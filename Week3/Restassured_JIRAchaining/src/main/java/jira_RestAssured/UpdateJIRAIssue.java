package jira_RestAssured;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class UpdateJIRAIssue extends JIRABaseClass{
	@Test(dependsOnMethods="jira_RestAssured.GETIssueBasedonKey.runGETJIRAIssue")
	public void runUpdateJIRAIssue()
	{
		File f2= new File("./data/update.json");
	inputReq.contentType("application/json").body(f2);	
		
		Response response = inputReq.put(keyval);	
		System.out.println("----------------------Update JIRA Issue----------------------");
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(204);
		System.out.println("------------------------------------------------------------");
	}

}

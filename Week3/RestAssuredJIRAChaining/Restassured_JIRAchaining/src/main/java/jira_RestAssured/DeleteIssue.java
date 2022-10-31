package jira_RestAssured;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DeleteIssue extends JIRABaseClass{
	@Test(dependsOnMethods="jira_RestAssured.GETIssueBasedonKeyPostUpdate.runGETJIRAIssue")
	public void runDeleteIssue()
	{
		Response response = inputReq.delete(keyval);
		System.out.println("-----------------------Delete JIRA Issue--------------------");
		response.prettyPrint();
		System.out.println(response.statusCode());
		response.then().assertThat().statusCode(204);
		System.out.println("------------------------------------------------------------");
	}

}

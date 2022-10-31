package jira_RestAssured;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateJIRAIssue extends JIRABaseClass{
	
	@Test
	public void runCreateJIRAIssue()
	{
		File fl= new File("./data/create.json");
		
		
		 inputReq.body(fl).contentType(ContentType.JSON);
		 Response resp = inputReq.post();
		 System.out.println("--------------------Create JIRA Issue---------------------");
		 resp.prettyPrint();
		 System.out.println(resp.getStatusCode());
		keyval = resp.jsonPath().get("key");
		resp.then().assertThat().statusCode(201);
		resp.then().assertThat().body("key",Matchers.containsString("OC-"));
		System.out.println("------------------------------------------------------------");
	}

}

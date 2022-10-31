package jira_RestAssured;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class JIRABaseClass {
	public static RequestSpecification inputReq;
	public static String keyval;
	
	@BeforeMethod
	public void initialSetUp()
	{
RestAssured.baseURI="https://api-training.atlassian.net/rest/api/2/issue";
		
		 inputReq = RestAssured.given().auth().preemptive().basic("hari.radhakrishnan@testleaf.com","shzZzlBP3Ij1MRU0LPWW6ECF");
		}

}

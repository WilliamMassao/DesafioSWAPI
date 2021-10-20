package br.ce.williamsaito.rest.support;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;

import io.cucumber.java.Before;
import br.ce.williamsaito.rest.core.ConfigurationParameters;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

public class BaseTest implements ConfigurationParameters{
	
	@Before
	public static void setup() {
		RestAssured.baseURI = baseUrl;
		RestAssured.basePath = basePath;
		RestAssured.port = 443;
		
		RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
		requestBuilder.setContentType(contentType); //JSON nesse caso
		RestAssured.requestSpecification = requestBuilder.build();
		
		ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();
		responseBuilder.expectResponseTime(Matchers.lessThan(maxTimeout)); //Definir Timeout máximo de requisição
		RestAssured.responseSpecification = responseBuilder.build();
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
	}
}

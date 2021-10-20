package br.ce.williamsaito.rest.core;

import io.restassured.http.ContentType;

public interface ConfigurationParameters {
	
	String baseUrl = "https://swapi.dev";
	
	String basePath = "/api";
	
	ContentType contentType = ContentType.JSON;
	
	Long maxTimeout = 10000L;

}

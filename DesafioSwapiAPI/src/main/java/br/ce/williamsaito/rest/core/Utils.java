package br.ce.williamsaito.rest.core;

import io.restassured.response.Response;

public class Utils {
	
	public String[] getSwapiResponseAttributes(Response responseGetSwapi, String[] attributes) {
		String response[] = new String[ attributes.length];
		for (int i = 0; i < attributes.length; i++) {
			response[i] = responseGetSwapi.body().jsonPath().get(attributes[i]).toString();
		}
		return response;
	}
	
	public int countNumberAttributes(Response responseGetSwapi, String countBy) {
		return Integer.parseInt(responseGetSwapi.jsonPath().get(countBy + ".size()").toString());
	}

}

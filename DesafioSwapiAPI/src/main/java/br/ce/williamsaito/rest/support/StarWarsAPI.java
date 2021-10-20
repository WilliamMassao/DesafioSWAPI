package br.ce.williamsaito.rest.support;

import static io.restassured.RestAssured.given;

import br.ce.williamsaito.rest.core.Utils;
import io.restassured.response.Response;

public class StarWarsAPI {
	
	Utils utils = new Utils();
		
	public Response getSwapiRequest(String endpoint, int numero) {
		return given().when().get(endpoint + numero);
    }
	
	public Response getSwapiRequest(String endpoint) {
		return given().when().get(endpoint);
    }
	
	public String getSwapiResponseFilmTitle(Response responseGetSwapiFilms) {
		String attributes[] = {"title"};
		return utils.getSwapiResponseAttributes(responseGetSwapiFilms, attributes)[0];
	}
	
	public String[] getSwapiResponsePeopleNameMass(Response responseGetSwapiPeople) {
		String attributes[] = {"name","mass"};
		return utils.getSwapiResponseAttributes(responseGetSwapiPeople, attributes);
	}
	
	public int[] getSwapiResponseCountQuntidade(Response responseGetSwapiFilms) {
		String attributes[] = {"count"};
		int[] response = new int[2];	
		response[0] = Integer.parseInt(utils.getSwapiResponseAttributes(responseGetSwapiFilms, attributes)[0]);
		response[1] = utils.countNumberAttributes(responseGetSwapiFilms, "results");
		return response;
		
	}
	
}

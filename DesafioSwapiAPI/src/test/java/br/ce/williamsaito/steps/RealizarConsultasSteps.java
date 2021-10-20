package br.ce.williamsaito.steps;

import org.junit.Assert;

import br.ce.williamsaito.rest.support.BaseTest;
import br.ce.williamsaito.rest.support.StarWarsAPI;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

public class RealizarConsultasSteps {

	private Response responseGetSwapi;
	private StarWarsAPI starWarsAPI;
	BaseTest basteTest = new BaseTest();
	
	 public RealizarConsultasSteps() {
		 starWarsAPI = new StarWarsAPI();
	    }
	
	@Dado("que possuo acesso ao endpoint films")
	public void quePossuoAcessoAoEndpointFilms() throws Throwable {
		BaseTest.setup();
	}

	@Quando("realizo a requisicao GET do filme {int}")
	public void realizoARequisicaoGETDoFilme(int numeroFilme) throws Throwable {
		responseGetSwapi = starWarsAPI.getSwapiRequest("/films/", numeroFilme);
	}

	@Entao("valido o titulo {string} obtido na response")
	public void validoOsObtidoNaResponse(String arg1) throws Throwable {
		responseGetSwapi.then().statusCode(200);
		Assert.assertEquals(arg1, starWarsAPI.getSwapiResponseFilmTitle(responseGetSwapi));
		
	}
	
	@Dado("que possuo acesso ao endpoint people")
	public void que_possuo_acesso_ao_endpoint_people() throws Throwable {
		BaseTest.setup();
	}

	@Quando("realizo a requisicao GET da pessoa {int}")
	public void realizoARequisicaoGETPessoa(int numeroPessoa) throws Throwable {
		responseGetSwapi = starWarsAPI.getSwapiRequest("/people/", numeroPessoa);
	}

	@Entao("valido o nome {string} e o peso {double} obtido na response")
	public void validoNomePesoObtidoResponse(String nomePessoa, double pesoPessoa) throws Throwable {
		responseGetSwapi.then().statusCode(200);
		Assert.assertEquals(nomePessoa, starWarsAPI.getSwapiResponsePeopleNameMass(responseGetSwapi)[0]);
		Assert.assertEquals(pesoPessoa, (Double.parseDouble(starWarsAPI.getSwapiResponsePeopleNameMass(responseGetSwapi)[1])), 1e-15);
	}
	
	@Quando("realizo a requisicao GET dos filmes")
	public void realizoRequisicaoGETFilmes() {
		responseGetSwapi = starWarsAPI.getSwapiRequest("/films/");
	}
	@Entao("valido o count de acordo com a quantidade de filmes listados")
	public void valorCountQuntiddeFilmesListados() {
		responseGetSwapi.then().statusCode(200);
		Assert.assertEquals(starWarsAPI.getSwapiResponseCountQuntidade(responseGetSwapi)[1], starWarsAPI.getSwapiResponseCountQuntidade(responseGetSwapi)[0]);
	}
	
	@Quando("realizo a requisicao GET da pessoa {int} inexistente")
	public void realizoRequisicaoGetPessoaInexistente(int numeroPessoa) {
	    responseGetSwapi = starWarsAPI.getSwapiRequest("/people/", numeroPessoa);
	}
	@Entao("valido o Status Code {int} de requisicao nao encontrada")
	public void validoRequisicaoNaoEncontrada(int statusCode) {
		responseGetSwapi.then().statusCode(statusCode);
	}
}

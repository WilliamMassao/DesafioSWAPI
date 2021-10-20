#language: pt
@funcionais
Funcionalidade: Consulta de filmes

	Como um usuario 
	Gostaria de realizar requisicoes
	Para que eu possa consultar os filmes cadastrados na API
	
Esquema do Cenario: Validar titulo do filme na response ao enviar requisicao para o endpoint films
	Dado que possuo acesso ao endpoint films
	Quando realizo a requisicao GET do filme <numeroFilme>
	Entao valido o titulo <tituloFilme> obtido na response
	
Exemplos:
   | numeroFilme | tituloFilme  		         | 
   | 1           | "A New Hope"		        	 |
   | 2           | "The Empire Strikes Back" |
   | 5           | "Attack of the Clones"    |

Esquema do Cenario: Validar nome e peso da pessoa na response ao enviar requisicao para o endpoint people
	Dado que possuo acesso ao endpoint people
	Quando realizo a requisicao GET da pessoa <numeroPessoa>
	Entao valido o nome <nomePessoa> e o peso <pesoPessoa> obtido na response
	
Exemplos:
   | numeroPessoa | nomePessoa  		 | pesoPessoa |
   | 1            | "Luke Skywalker" | 77         |
   | 2            | "C-3PO"					 | 75         |
   | 10           | "Obi-Wan Kenobi" | 77         |
   
Esquema do Cenario: Validar a quantidade de filmes na response ao enviar requisicao para o endpoint films
	Dado que possuo acesso ao endpoint films
	Quando realizo a requisicao GET dos filmes 
	Entao valido o count de acordo com a quantidade de filmes listados
		
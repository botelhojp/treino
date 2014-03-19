package br.gov.serpro.treino.view.managedbean;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import br.gov.serpro.treino.config.TreinoConfig;
import br.gov.serpro.treino.constant.Navigation;

@ManagedBean(name = "testeMB")
@ApplicationScoped
public class TesteMB extends TestGridMB {

	private static final long serialVersionUID = 1L;

	private String selectedMovies = "1";
	
	private String categoriaSelecionada = "1";
	
	private String filmeSelecionado = "1";

	private Map<String, String> movies;
	
	private Map<String, String> categorias;
	
	private Map<String, String> filmes;
	
    private boolean value1;  
    
    private boolean value2; 
	
	private Integer numero;

	private static Logger log = Logger.getLogger(TesteMB.class);

	@PostConstruct
	public void init() {
		movies = new HashMap<String, String>();
		movies.put("Opção 1", "Opção 1");
		movies.put("Opção 2", "Opção 2");
		movies.put("Opção 3", "Opção 3");
		
		categorias = new HashMap<String, String>();
		categorias.put("Ação", "Ação");
		categorias.put("Drama", "Drama");
		categorias.put("Comédia", "Comédia");
		
		mudarCategoria(null);
		
	}

	public String teste() {
		return Navigation.TESTE;
	}

	public void salvar() {
		if (TreinoConfig.getDelay() > 10) {
			TreinoConfig.setDelay(10);
		}
	}

	public boolean getExibiBotao() {
		return (selectedMovies != null && !selectedMovies.equals("0"));
	}
	
	public boolean getExibiFilme() {
		return (filmeSelecionado != null && !filmeSelecionado.equals("0"));
	}

	public void mudaOpcao(ActionEvent event) {
		log.debug(selectedMovies);
	}
	
	public void mudarCategoria(ActionEvent event) {
		filmes = new HashMap<String, String>();
		if (categoriaSelecionada.equals("Ação")){
			filmes.put("Jogos Vorazes - Em Chamas", "Jogos Vorazes - Em Chamas");	
			filmes.put("O Senhor dos Anéis - O Retorno do Rei", "O Senhor dos Anéis - O Retorno do Rei");
			filmes.put("Thor: O Mundo Sombrio", "Thor: O Mundo Sombrio");			
		} else
		if (categoriaSelecionada.equals("Drama")){
			filmes.put("A Primeira Coisa Bela", "A Primeira Coisa Bela");
			filmes.put("Amores Imaginários", "Amores Imaginários");
			filmes.put("Another Year", "Another Year");
		}else 
		if (categoriaSelecionada.equals("Comédia")){
			filmes.put("Forrest Gump", "Forrest Gump");
			filmes.put("Te Pego Lá Fora (1987)", "Te Pego Lá Fora (1987)");
		}else{
			filmes.clear();
		}
	}

	public Integer getDelay() {
		return TreinoConfig.getDelay();
	}

	public void setDelay(Integer delay) {
		TreinoConfig.setDelay(delay);
	}

	public String getSelectedMovies() {
		return selectedMovies;
	}
	

	public String getCategoriaSelecionada() {
		return categoriaSelecionada;
	}

	public void setCategoriaSelecionada(String categoriaSelecionada) {
		this.categoriaSelecionada = categoriaSelecionada;
	}

	public String getFilmeSelecionado() {
		return filmeSelecionado;
	}

	public void setFilmeSelecionado(String filmeSelecionado) {
		this.filmeSelecionado = filmeSelecionado;
	}

	public Map<String, String> getCategorias() {
		return categorias;
	}

	public void setCategorias(Map<String, String> categorias) {
		this.categorias = categorias;
	}

	public Map<String, String> getFilmes() {
		return filmes;
	}

	public void setFilmes(Map<String, String> filmes) {
		this.filmes = filmes;
	}

	public void setSelectedMovies(String selectedMovies) {
		this.selectedMovies = selectedMovies;
	}

	public Map<String, String> getMovies() {
		return movies;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public boolean isValue1() {
		return value1;
	}

	public void setValue1(boolean value1) {
		this.value1 = value1;
	}

	public boolean isValue2() {
		return value2;
	}

	public void setValue2(boolean value2) {
		this.value2 = value2;
	}

}

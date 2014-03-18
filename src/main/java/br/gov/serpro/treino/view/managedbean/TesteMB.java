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

	private Map<String, String> movies;
	
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

	public void mudaOpcao(ActionEvent event) {
		log.debug(selectedMovies);
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

package br.gov.serpro.treino.view.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.gov.serpro.treino.config.TreinoConfig;
import br.gov.serpro.treino.constant.Navigation;

@ManagedBean(name = "menuMB")
public class Menu implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	private static String version;
 
	@PostConstruct
	public void init(){		
	}	

	public String index() {
		return Navigation.INDEX;
	}
	
	public String getVersion(){
		if (version == null){
			version = TreinoConfig.getInstance().getVersion() + " " +  TreinoConfig.getInstance().getBuild();
		}
		return version;
	}
}

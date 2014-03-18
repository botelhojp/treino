package br.gov.serpro.treino.view.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

import br.gov.serpro.treino.constant.Navigation;
import br.gov.serpro.treino.listener.Timer;

@ManagedBean(name = "desempenhoMB")
@SessionScoped
public class DesempenhoMB extends TestGridMB {
	

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(DesempenhoMB.class);
	
	private boolean showFile;

	@PostConstruct
	public void init() {
		showFile = false;
	}

	@Override
	public void setModeInsert(Boolean modeInsert) {
		super.setModeInsert(modeInsert);
	}

	/**
	 * Retorna todos os projetos da base
	 * 
	 * @return
	 */
	public String exibir() {
		log.debug("exibir");
		showFile = false;
		return Navigation.DESEMPENHO;
	}

	
	public void obterJTL() {
		try {
			log.debug("obterJTL");
			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
			String path = servletContext.getRealPath("/");
			Timer.writeJTL(path + "treino.jtl");
			showFile = true;
		} catch (Throwable e) {
			FacesUtil.handleException(e);
		}
	}

	public boolean isShowFile() {
		return showFile;
	}

	public void setShowFile(boolean showFile) {
		this.showFile = showFile;
	}

}

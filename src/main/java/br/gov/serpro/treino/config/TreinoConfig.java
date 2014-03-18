package br.gov.serpro.treino.config;

import java.text.ParseException;

import br.gov.framework.demoiselle.core.transaction.ITransactionContext;
import br.gov.framework.demoiselle.util.config.ConfigKey;
import br.gov.framework.demoiselle.util.config.ConfigType;
import br.gov.framework.demoiselle.util.config.ConfigurationLoader;
import br.gov.framework.demoiselle.web.transaction.WebTransactionContext;
import br.gov.serpro.treino.bean.Obra;
import br.gov.serpro.treino.persistence.dao.implementation.ProjectDAO;

public class TreinoConfig {

	private static TreinoConfig instance;

	private static Integer delay = 0;

	private static final String FILE_NAME = "testgrid.properties";

	@ConfigKey(name = "testgrid.version", type = ConfigType.PROPERTIES, resourceName = FILE_NAME)
	private String version;

	@ConfigKey(name = "testgrid.build", type = ConfigType.PROPERTIES, resourceName = FILE_NAME)
	private String build;

	/**
	 * Construtor privado
	 */
	private TreinoConfig() {
	}

	/**
	 * Retorna instancia única
	 * 
	 * @return
	 */
	public static TreinoConfig getInstance() {
		if (instance == null) {
			instance = new TreinoConfig();
			ConfigurationLoader.load(instance);
			initDB();
		}
		return instance;
	}

	private static void initDB() {
		ITransactionContext transaction = WebTransactionContext.getInstance();
		transaction.init();
		try {
			ProjectDAO dao = new ProjectDAO();
			dao.save(new Obra("Arena da Baixada", 100000.00, "30/07/2014"));
			dao.save(new Obra("Arena das Dunas", 100000.00, "30/07/2014"));
			dao.save(new Obra("Arena Recife", 100000.00, "30/07/2014"));
			dao.save(new Obra("Beira Rio", 100000.00, "30/07/2014"));
			dao.save(new Obra("Castelão", 100000.00, "30/07/2014"));
			dao.save(new Obra("Estádio Corinthians", 100000.00, "30/07/2014"));
			dao.save(new Obra("Fonte Nova", 100000.00, "30/07/2014"));
			dao.save(new Obra("Mané Garrincha", 100000.00, "30/07/2014"));
			dao.save(new Obra("Maracanã", 100000.00, "30/07/2014"));
			dao.save(new Obra("Mineirão", 100000.00, "30/07/2014"));			
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			transaction.end();	
		}
		
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public static Integer getDelay() {
		return delay;
	}

	public static void setDelay(Integer delay) {
		TreinoConfig.delay = delay;
	}

}

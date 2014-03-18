package br.gov.serpro.treino.constant;

import br.gov.serpro.treino.exception.ErrorMessage;
import br.gov.serpro.treino.exception.TestGridException;

public enum ChartType {
	
	LINE90("line90", "line90_scenario", "Tempo de Resposta (linha de 90%)", "Tempo de resposta em segundos"),
	ERROR("error", "error_scenario", "Taxa de Erro", "Percentual de erro"),
	MON("mon", "", "", ""),
	TIMES("times", "times_scenario", "Duração do Teste", "Duração em minutos"),
	FEEDBACKANSWERS("feedbackanswers", "", "", ""),
	FEEDBACKTOTALS("feedbacktotals", "", "", ""),
	FEEDBACKTOTALPROJECTS("feedbacktotalprojects", "", "", ""),
	FEEDBACKAVGANSWERS("feedbackavganswers", "","Médias das Respostas dos Feedbacks","Nota (%)");
	
	private String name;
	private String prefix;
	private String typeName;
	private String yAxis;
	
	private ChartType(String name, String prefix, String typeName, String yAxis){
		this.name = name;
		this.prefix = prefix;
		this.typeName = typeName;
		this.yAxis = yAxis;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getTypeName() {
		return typeName;
	}

	public String getyAxis() {
		return yAxis;
	}

	public String getName() {
		return name;
	}
	
	public static ChartType valueOfString(Object _value){
		String value = _value.toString();
		if (LINE90.getName().equals(value) ) return LINE90;
		if (ERROR.getName().equals(value) ) return ERROR;
		if (MON.getName().equals(value) ) return MON;
		if (TIMES.getName().equals(value) ) return TIMES;
		if (FEEDBACKANSWERS.getName().equals(value) ) return FEEDBACKANSWERS;
		if (FEEDBACKTOTALS.getName().equals(value) ) return FEEDBACKTOTALS;
		if (FEEDBACKTOTALPROJECTS.getName().equals(value) ) return FEEDBACKTOTALPROJECTS;
		if (FEEDBACKAVGANSWERS.getName().equals(value) ) return FEEDBACKAVGANSWERS;
		String[] param = {value};
		throw new TestGridException(ErrorMessage.CHART_TYPE_NOT_FOUND, param);
	}
	
}

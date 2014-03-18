package br.gov.serpro.treino.listener;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("sample")
public class Sample {

	@XStreamAsAttribute
	private String t = "2864";

	@XStreamAsAttribute
	private String lt = "763";

	@XStreamAsAttribute
	private String ts = "1322006075174";

	@XStreamAsAttribute
	private String s = "true";

	@XStreamAsAttribute
	private String lb = "#LoginSuite-/suiterfb/private/pages/default.jsf";

	@XStreamAsAttribute
	private String rc = "200";

	@XStreamAsAttribute
	private String rm = "OK";

	@XStreamAsAttribute
	private String tn = "Grupo de Usuários 1-1";

	@XStreamAsAttribute
	private String dt = "text";

	@XStreamAsAttribute
	private String by = "13580";

	public Sample(String t, String lt, String ts, String s, String lb,
			String rc, String rm, String tn, String dt, String by) {
		super();
		this.t = t;
		this.lt = lt;
		this.ts = ts;
		this.s = s;
		this.lb = lb;
		this.rc = rc;
		this.rm = rm;
		this.tn = tn;
		this.dt = dt;
		this.by = by;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getLt() {
		return lt;
	}

	public void setLt(String lt) {
		this.lt = lt;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public String getLb() {
		return lb;
	}

	public void setLb(String lb) {
		this.lb = lb;
	}

	public String getRc() {
		return rc;
	}

	public void setRc(String rc) {
		this.rc = rc;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

}

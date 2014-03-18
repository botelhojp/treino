package br.gov.serpro.treino.listener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import com.thoughtworks.xstream.XStream;

public class Timer implements ServletRequestListener, Serializable {

	private static Hashtable<String, Long> requests = new Hashtable<String, Long>();
	
	private static String SPLIT = "______";

	private static final long serialVersionUID = 1L;
	//private static Logger log = Logger.getLogger(Timer.class);
	private static List<Sample> samples = new ArrayList<Sample>();

	public void requestInitialized(ServletRequestEvent sre) {
		String id = getID(sre);
		//log.debug("ini: " + id);
		if (requests.get(id) == null) {
			Long time = GregorianCalendar.getInstance().getTimeInMillis();
			requests.put(id, time);
		} else {
			throw new RuntimeException("URL não experada:" + id);
		}
	}

	public void requestDestroyed(ServletRequestEvent sre) {
		String id = getID(sre);
		//log.debug("end: " + id);
		if (requests.get(id) != null) {
			Long time2 = GregorianCalendar.getInstance().getTimeInMillis();
			Long time1 = requests.get(id);
			Long tempo = time2 - time1;
			String label = id.split(SPLIT)[1];
			add(new Sample(tempo.toString(), tempo.toString(), time2.toString(), "true", label, "200", "OK", "-", "text", "0"));
			//log.debug("TEMPO: " + id + " = " + (time2 - time1));
			requests.remove(id);
		} else {
			throw new RuntimeException("URL não experada:" + id);
		}
	}

	public synchronized void add(Sample s) {
		samples.add(s);
	}

	private String getID(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		return Thread.currentThread().getName() + SPLIT + request.getRequestURL().toString();
	}

	public static void writeJTL(String path) {
		try {
			XStream xstream = new XStream();
			xstream.processAnnotations(Sample.class);
			xstream.processAnnotations(TestResults.class);
			xstream.alias("testResults", List.class);
			TestResults test = new TestResults();
			test.setSamples(samples);
			String xml = xstream.toXML(samples);
			xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + System.getProperty("line.separator") + xml;
			FileWriter fstream = new FileWriter(path);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(xml);
			out.close();
			samples.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

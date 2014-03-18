package br.gov.serpro.treino;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RST {
	
	private static long count = 0;

	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			
			

			DefaultHandler handler = new DefaultHandler() {


				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
					System.out.println("startElement :" + count++ + " " + qName);
					
					if (qName.equalsIgnoreCase("httpSample")) {
						System.out.println(Integer.valueOf(attributes.getValue("t")).intValue());	
						
						
						
						
						
					}
					

				}

				public void endElement(String uri, String localName, String qName) throws SAXException {

					System.out.println("endElement :" + qName);

				}

				public void characters(char ch[], int start, int length) throws SAXException {

					
				}
			};

			saxParser.parse("/home/03397040477/workspace-testgrid/testgrid-web/src/main/resources/LoadTestResults_Threads_2_Iteracoes_10.jtl", handler);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

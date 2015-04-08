package com.home.common.parser;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.home.common.model.IPToCountryBean;
import com.home.common.model.IPToCountryBeans;

@Service
public class XMLFileReader implements GenericReader {

    @Autowired
    DocumentBuilderFactory documentBuilderFactory;

    @Autowired
    SAXParserFactory saxParserFactory;

    public Object parsetoJavaObject(Object obj) {
        List<IPToCountryBean> ipToCountryBeanList = null;
        try {
            ipToCountryBeanList = parseUsingSAX(obj, ipToCountryBeanList);
        } catch (Exception e) {

        }
        return ipToCountryBeanList;
    }

    private List<IPToCountryBean> parseUsingSAX(Object obj, List<IPToCountryBean> ipToCountryBeanList)
            throws ParserConfigurationException, SAXException, IOException {
        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyHandler myHandler = new MyHandler();
        saxParser.parse((File) obj, myHandler);
        return myHandler.getIpToCountryBeanList();
    }

    @SuppressWarnings("unused")
    private List<IPToCountryBean> parseUsingDOM(Object obj, List<IPToCountryBean> ipToCountryBeanList)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse((File) obj);
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("ipToCountries");
        if (nodeList != null) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                NodeList subNodeList = element.getElementsByTagName("ipToCountry");
                Element subElement = null;
                IPToCountryBean ipToCountryBean = null;
                for (int j = 0; j < subNodeList.getLength(); j++) {
                    subElement = (Element) subNodeList.item(j);
                    if (ipToCountryBeanList == null)
                        ipToCountryBeanList = new ArrayList<IPToCountryBean>();
                    ipToCountryBean = new IPToCountryBean();
                    ipToCountryBean.setCountry(subElement.getElementsByTagName("country").item(0).getTextContent());
                    ipToCountryBean.setCountryCode(subElement.getAttribute("countryCode"));
                    ipToCountryBean.setIpAddrsss(subElement.getElementsByTagName("ip").item(0).getTextContent());
                    ipToCountryBean
                            .setIso_code_2(subElement.getElementsByTagName("iso_code2").item(0).getTextContent());
                    ipToCountryBean
                            .setIso_code_3(subElement.getElementsByTagName("iso_code3").item(0).getTextContent());
                    ipToCountryBean.setIso_country(subElement.getElementsByTagName("iso_country").item(0)
                            .getTextContent());
                    ipToCountryBean.setLat(Double.parseDouble(subElement.getElementsByTagName("lat").item(0)
                            .getTextContent()));
                    ipToCountryBean.setLon(Double.parseDouble(subElement.getElementsByTagName("lon").item(0)
                            .getTextContent()));
                    ipToCountryBeanList.add(ipToCountryBean);
                }
            }
        }
        return ipToCountryBeanList;
    }

    @SuppressWarnings("unchecked")
    public Object parseFromJavaObject(Object obj) {
        StringWriter sw = new StringWriter();
        try {
            IPToCountryBeans ipToCountryBeans = new IPToCountryBeans();
            ipToCountryBeans.setIpToCountries((List<IPToCountryBean>) obj);
            JAXBContext context = JAXBContext.newInstance(IPToCountryBeans.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(ipToCountryBeans, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }

}

class MyHandler extends DefaultHandler {
    List<IPToCountryBean> ipToCountryBeanList = null;
    IPToCountryBean ipToCountryBean = null;

    private boolean ipAddrsss;
    private boolean iso_code_2;
    private boolean iso_code_3;
    private boolean iso_country;
    private boolean country;
    private boolean lat;
    private boolean lon;

    public List<IPToCountryBean> getIpToCountryBeanList() {
        return ipToCountryBeanList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("ipToCountry")) {
            String countryCode = attributes.getValue("countryCode");
            ipToCountryBean = new IPToCountryBean();
            ipToCountryBean.setCountryCode(countryCode);
            if (ipToCountryBeanList == null)
                ipToCountryBeanList = new ArrayList<IPToCountryBean>();
        } else if (qName.equalsIgnoreCase("ip")) {
            this.ipAddrsss = true;
        } else if (qName.equalsIgnoreCase("iso_code_2")) {
            this.iso_code_2 = true;
        } else if (qName.equalsIgnoreCase("iso_code_3")) {
            this.iso_code_3 = true;
        } else if (qName.equalsIgnoreCase("iso_country")) {
            this.iso_country = true;
        } else if (qName.equalsIgnoreCase("country")) {
            this.country = true;
        } else if (qName.equalsIgnoreCase("lat")) {
            this.lat = true;
        } else if (qName.equalsIgnoreCase("lon")) {
            this.lon = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("ipToCountry")) {
            ipToCountryBeanList.add(ipToCountryBean);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (ipAddrsss) {
            ipToCountryBean.setIpAddrsss(new String(ch, start, length));
            this.ipAddrsss = false;
        } else if (iso_code_2) {
            ipToCountryBean.setIso_code_2(new String(ch, start, length));
            this.iso_code_2 = false;
        } else if (iso_code_3) {
            ipToCountryBean.setIso_code_3(new String(ch, start, length));
            this.iso_code_3 = false;
        } else if (iso_country) {
            ipToCountryBean.setIso_country(new String(ch, start, length));
            this.iso_country = false;
        } else if (country) {
            ipToCountryBean.setCountry(new String(ch, start, length));
            this.country = false;
        } else if (lat) {
            ipToCountryBean.setLat(Double.parseDouble(new String(ch, start, length)));
            this.lat = false;
        } else if (lon) {
            ipToCountryBean.setLon(Double.parseDouble(new String(ch, start, length)));
            this.lon = false;
        }
    }
}
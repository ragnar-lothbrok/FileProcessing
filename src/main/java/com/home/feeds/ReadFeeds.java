package com.home.feeds;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;

public class ReadFeeds {

    public static void main(String[] args) throws IOException, IllegalArgumentException, FeedException {
        SyndFeed syndFeed = null;
        InputStream inputStream = null;
        try {
            URLConnection openConnection = new URL("http://oglobo.globo.com/rss/plantaopais.xml").openConnection();
            inputStream = openConnection.getInputStream();
            if ("gzip".equals(openConnection.getContentEncoding())) {
                inputStream = new GZIPInputStream(inputStream);
            }
            InputSource source = new InputSource(inputStream);
            SyndFeed feed = new SyndFeedInput().build(source);
            for (Iterator i = feed.getEntries().iterator(); i.hasNext();) {
                SyndEntry entry = (SyndEntry) i.next();
                System.out.println(entry.getUri() + " " + entry.getTitle() + " " + entry.getDescription());
            }
        } finally {
            if (inputStream != null)
                inputStream.close();
        }

        System.out.println("#####");
        getFeed();
    }

    public static void getFeed() {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new URL("http://oglobo.globo.com/rss/plantaopais.xml").openStream());
            NodeList items = doc.getElementsByTagName("item");
            for (int i = 0; i < items.getLength(); i++) {
                Element item = (Element) items.item(i);
                System.out.println(item.getElementsByTagName("title").item(0).getFirstChild().getNodeValue() + " "
                        + item.getElementsByTagName("description").item(0).getFirstChild().getNodeValue() + " "
                        + item.getElementsByTagName("link").item(0).getFirstChild().getNodeValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

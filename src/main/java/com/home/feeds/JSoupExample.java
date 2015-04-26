package com.home.feeds;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sun.syndication.io.FeedException;

public class JSoupExample {

    public static void main(String[] args) throws IOException, IllegalArgumentException, FeedException {
        InputStream inputStream = null;
        try {
            URL url = new URL("http://cron.schlitt.info/index.php?cron=11%20*%20*%20*%20*&iterations=10&test=Test");
            
            /* Document doc = Jsoup.connect(url.toString()).get(); */

            Connection con = Jsoup.connect(url.toString())
                    .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:36.0) Gecko/20100101 Firefox/36.0")
                    .timeout(10000);
            Response resp = con.execute();
            Document doc = resp.parse();
            List<String> futureExecutionTime = new ArrayList<String>();
            if (doc != null) {
                for (int i = 1; i < 6; i++) {
                    Elements elements = doc.select("body ol li:eq(" + i + ")");
                    if (elements != null && elements.text() != null && elements.text().trim().length() > 0) {
                        futureExecutionTime.add(elements.text().trim());
                    }
                }
            }
            System.out.println(futureExecutionTime);
        } finally {
            if (inputStream != null)
                inputStream.close();
        }

        System.out.println("#####");
    }

}

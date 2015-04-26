package com.home.feeds;

import java.net.HttpURLConnection;
import java.net.IDN;
import java.net.MalformedURLException;
import java.net.URL;

public class Sample {
	
    private static final int TODAYS = 1;
    private static final int LAST_THIRTY = 30;
    private static final int CUSTOMREPORT = 0;
    private static final int QUARTERLY = 90;
    private static final int YEARLY = 365;
    private static final long MS_TO_DAYS_FACTOR = 24 * 60 * 60 * 1000;

    private static final String PROTOCOL = "http://";
    private static final String SECURE_PROTOCOL = "https://";

    private static final Integer CONNECTION_TIMEOUT = 40000; /* 40 sec */
    private static final int MAX_HEX_CHARS_REQUIRED = 32;
    private static final String DEFAULT_HEX_CHAR = "0";
    private static final String FORWARD_SLASH = "/";
    private static final String COMMA = ",";
    
    private static final double _DEFAULT_DOUBLE_SIZE_FACTOR = 0.25;
    
    public static final String TIMEZONE="timezone";	
    
    public static URL getASCIIUrl(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
            String host = url.getHost();
            String protocol = url.getProtocol();

            url = new URL(protocol + "://" + IDN.toASCII(host));
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            return null;
        }
        return url;
    }
	
	public static boolean checkHttpURLExistence(String httpUrl) {
        boolean res = false;
        if (null != httpUrl) {
            // If protocol is not attached with the passed URL
            if (!(httpUrl.startsWith(SECURE_PROTOCOL) || httpUrl.startsWith(PROTOCOL))) {
                httpUrl = PROTOCOL + httpUrl;
            }
            URL url=getASCIIUrl(httpUrl);
            
            HttpURLConnection con = null;
            try {
                // Open a http connection via the url
                con = (HttpURLConnection) url.openConnection();
                HttpURLConnection.setFollowRedirects(false);
                con.setRequestMethod("GET");
                // Putting connection timeout
                con.setConnectTimeout(CONNECTION_TIMEOUT);
                // Adding default user agent property as few websites won't
                // allow unknown user agent's
                con.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.01; Windows NT 5.0)");
                // con.addRequestProperty( "User-Agent",
                // "Mozilla/4.0 (compatible; MSIE 5.01; Windows NT 5.0)" );
                // Response Status code
                int code = con.getResponseCode();
                System.out.println(code);
                // Check if it belongs to 2xx / 3xx
                char[] codeArray = new Integer(code).toString().toCharArray();
                // added code to handle for sites whoes user-agent doesnt
                // support value
                // so need to make it blank and launch a connection again.
                if (codeArray[0] == '4') {
                    con.disconnect();
                    con = null;
                    con = (HttpURLConnection) new URL(httpUrl).openConnection();
                    HttpURLConnection.setFollowRedirects(false);
                    con.setRequestMethod("GET");
                    // Putting connection timeout
                    con.setConnectTimeout(100);
                    con.addRequestProperty("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:36.0) Gecko/20100101 Firefox/36.0");
                    code = con.getResponseCode();
                    codeArray = new Integer(code).toString().toCharArray();
                }
                if (codeArray[0] == '2' || codeArray[0] == '3') {
                    res = true;
                }
            } catch (Exception e) {
            	e.printStackTrace();
            } finally {
                if (con != null) {
                    con.disconnect();
                    con = null;
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(checkHttpURLExistence("cron.schlitt.info/index.php?cron=11 * * * *&iterations=5&test=Test"));
	}
}

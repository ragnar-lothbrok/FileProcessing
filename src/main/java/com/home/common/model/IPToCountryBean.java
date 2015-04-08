package com.home.common.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ipToCountry")
public class IPToCountryBean {

    private String ipAddrsss;
    private String countryCode;
    private String iso_code_2;
    private String iso_code_3;
    private String iso_country;
    private String country;
    private Double lat;
    private Double lon;

    @XmlElement(name = "ip")
    public String getIpAddrsss() {
        return ipAddrsss;
    }

    public void setIpAddrsss(String ipAddrsss) {
        this.ipAddrsss = ipAddrsss;
    }

    @XmlAttribute
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @XmlElement(name = "iso_code2")
    public String getIso_code_2() {
        return iso_code_2;
    }

    public void setIso_code_2(String iso_code_2) {
        this.iso_code_2 = iso_code_2;
    }

    @XmlElement(name = "iso_code3")
    public String getIso_code_3() {
        return iso_code_3;
    }

    public void setIso_code_3(String iso_code_3) {
        this.iso_code_3 = iso_code_3;
    }

    @XmlElement(name = "iso_country")
    public String getIso_country() {
        return iso_country;
    }

    public void setIso_country(String iso_country) {
        this.iso_country = iso_country;
    }

    @XmlElement(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement(name = "lat")
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @XmlElement(name = "lon")
    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "IPtoCountryBean [ipAddrsss=" + ipAddrsss + ", countryCode=" + countryCode + ", iso_code_2="
                + iso_code_2 + ", iso_code_3=" + iso_code_3 + ", iso_country=" + iso_country + ", country=" + country
                + ", lat=" + lat + ", lon=" + lon + "]";
    }

    public String toCSV() {
        return "" + country + "," + countryCode + "," + iso_country + "," + ipAddrsss + "," + iso_code_2 + ","
                + iso_code_3 + "," + lat + "," + lon;
    }

    public static String toHeader() {
        return "country,countryCode,iso_country,ipAddrsss,iso_code_2,iso_code_3,lat,lon\n";
    }

}

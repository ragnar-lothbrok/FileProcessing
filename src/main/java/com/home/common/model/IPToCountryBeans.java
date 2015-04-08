package com.home.common.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ipToCountries")
public class IPToCountryBeans {
    private List<IPToCountryBean> ipToCountries;

    @XmlElement(name = "ipToCountry")
    public List<IPToCountryBean> getIpToCountries() {
        return ipToCountries;
    }

    public void setIpToCountries(List<IPToCountryBean> ipToCountries) {
        this.ipToCountries = ipToCountries;
    }

}

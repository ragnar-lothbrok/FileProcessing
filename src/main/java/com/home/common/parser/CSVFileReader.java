package com.home.common.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;

import com.home.common.model.IPToCountryBean;

@Service
public class CSVFileReader implements GenericReader {

    public Object parsetoJavaObject(Object obj) {
        List<IPToCountryBean> ipToCountryBeanList = null;
        CSVReader csvReader = new CSVReader((Reader) obj);
        try {
            List<String[]> values = csvReader.readAll();
            if (values.size() > 1) {
                Iterator<String[]> iterator = values.iterator();
                iterator.next();
                String[] data = null;
                IPToCountryBean ipToCountryBean = null;
                while (iterator.hasNext()) {
                    data = iterator.next();
                    if (ipToCountryBeanList == null)
                        ipToCountryBeanList = new ArrayList<IPToCountryBean>();
                    ipToCountryBean = new IPToCountryBean();
                    ipToCountryBean.setCountry(data[0]);
                    ipToCountryBean.setCountryCode(data[1]);
                    ipToCountryBean.setIpAddrsss(data[2]);
                    ipToCountryBean.setIso_code_2(data[3]);
                    ipToCountryBean.setIso_code_3(data[4]);
                    ipToCountryBean.setIso_country(data[5]);
                    ipToCountryBean.setLat(Double.parseDouble(data[6]));
                    ipToCountryBean.setLon(Double.parseDouble(data[7]));
                    ipToCountryBeanList.add(ipToCountryBean);
                }
            }
        } catch (IOException e) {
        }

        return ipToCountryBeanList;
    }

    public Object parseFromJavaObject(Object obj) {
        StringBuffer sb = new StringBuffer();
        if (obj != null) {
            sb.append(IPToCountryBean.toHeader());
            for (IPToCountryBean iptoCountryBean : (List<IPToCountryBean>) obj) {
                sb.append(iptoCountryBean.toCSV() + "\n");
            }
        }
        return sb;
    }

}

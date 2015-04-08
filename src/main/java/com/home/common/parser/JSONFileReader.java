package com.home.common.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.common.model.IPToCountryBean;

@Service
public class JSONFileReader implements GenericReader {

    @Autowired
    JSONParser jsonParser;

    @Autowired
    ObjectMapper objectMapper;

    public Object parsetoJavaObject(Object obj) {
        List<IPToCountryBean> ipToCountryBeanList = null;
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse((String) obj);
            JSONArray jsonArray = (JSONArray) jsonObject.get("results");
            IPToCountryBean ipToCountryBean = null;
            JSONObject tempJsonObject = null;
            @SuppressWarnings("unchecked")
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                if (ipToCountryBeanList == null)
                    ipToCountryBeanList = new ArrayList<IPToCountryBean>();
                tempJsonObject = (JSONObject) iterator.next();
                ipToCountryBean = new IPToCountryBean();
                if (tempJsonObject.get("country") != null)
                    ipToCountryBean.setCountry((String) tempJsonObject.get("country"));
                if (tempJsonObject.get("country") != null)
                    ipToCountryBean.setCountryCode((String) tempJsonObject.get("country"));

                if (tempJsonObject.get("ipAddrsss") != null)
                    ipToCountryBean.setIpAddrsss((String) tempJsonObject.get("ipAddrsss"));

                if (tempJsonObject.get("iso_code_2") != null)
                    ipToCountryBean.setIso_code_2((String) tempJsonObject.get("iso_code_2"));

                if (tempJsonObject.get("iso_code_3") != null)
                    ipToCountryBean.setIso_code_3((String) tempJsonObject.get("iso_code_3"));

                if (tempJsonObject.get("iso_country") != null)
                    ipToCountryBean.setIso_country((String) tempJsonObject.get("iso_country"));

                if (tempJsonObject.get("lat") != null)
                    ipToCountryBean.setLat((Double) tempJsonObject.get("lon"));

                if (tempJsonObject.get("lon") != null)
                    ipToCountryBean.setLon((Double) tempJsonObject.get("lon"));
                ipToCountryBeanList.add(ipToCountryBean);
            }
        } catch (ParseException e) {
            System.out.println("Exception Occured : " + e.getMessage());
        }
        return ipToCountryBeanList;
    }

    public Object parseFromJavaObject(Object obj) {
        String jsonString = null;
        try {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("results", obj);
            jsonString = objectMapper.writeValueAsString(map);
        } catch (JsonGenerationException e) {
        } catch (JsonMappingException e) {
        } catch (IOException e) {
        }
        return jsonString;
    }

}

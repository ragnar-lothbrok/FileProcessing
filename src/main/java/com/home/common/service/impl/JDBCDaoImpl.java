package com.home.common.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.common.model.IPToCountryBean;
import com.home.common.service.JDBCDao;

@Service
public class JDBCDaoImpl implements JDBCDao {

    @Autowired
    DataSource dataSource;  

    public void insert(IPToCountryBean iPtoCountryBean) {

    }

    public List<IPToCountryBean> fetch() {
        List<IPToCountryBean> ipToCountryBeanList = null;
        IPToCountryBean ipToCountryBean = null;
        String sql = "select inet_ntoa(ipn.ip),ipn.country as countryCode,ipc.iso_code_2,ipc.iso_code_3,ipc.iso_country,ipc.country,ipc.lat,ipc.lon from ip2nation ipn left join ip2nation_countries ipc on ipc.code = ipn.country;";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (ipToCountryBeanList == null)
                    ipToCountryBeanList = new ArrayList<IPToCountryBean>();
                ipToCountryBean = new IPToCountryBean();
                ipToCountryBean.setIpAddrsss(rs.getString("inet_ntoa(ipn.ip)"));
                ipToCountryBean.setCountry((rs.getString("country") == null ? "": rs.getString("country").replace(',', '|')));
                ipToCountryBean.setCountryCode(rs.getString("countryCode"));
                ipToCountryBean.setIso_code_2((rs.getString("iso_code_2") == null ? "": rs.getString("iso_code_2").replace(',', '|')));
                ipToCountryBean.setIso_code_3((rs.getString("iso_code_3") == null ? "": rs.getString("iso_code_3").replace(',', '|')));
                ipToCountryBean.setIso_country((rs.getString("iso_country") == null ? "": rs.getString("iso_country").replace(',', '|')));
                ipToCountryBean.setLat(rs.getDouble("lat"));
                ipToCountryBean.setLon(rs.getDouble("lon"));
                ipToCountryBeanList.add(ipToCountryBean);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return ipToCountryBeanList;
    }

}

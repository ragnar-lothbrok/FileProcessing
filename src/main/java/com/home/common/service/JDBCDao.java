package com.home.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.common.model.IPToCountryBean;

@Service
public interface JDBCDao {
    public void insert(IPToCountryBean iPtoCountryBean);
    public List<IPToCountryBean> fetch();
}

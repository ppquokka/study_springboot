package com.example.study_springboot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.study_springboot.dao.SharedDao;

@Service
@Transactional
public class CarCompanyService {
    @Autowired
    SharedDao sharedDao;

    // 검색(조건-search : Company Name, Company ID)
    public Object selectSearch(String search, String words) {
        // getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarInfors.selectSearch";
        HashMap dataMap = new HashMap<>();
        dataMap.put("search", search);
        dataMap.put("words", words);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    // 전체
    public Object selectAll(String COMPANY_ID) {
        // getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "Factorys.selectAll";
        HashMap dataMap = new HashMap<>();
        dataMap.put("COMPANY_ID", COMPANY_ID);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    // 상세
    public Object selectDetail(String COMPANY_ID) {
        // getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "Factorys.selectByUID";
        HashMap dataMap = new HashMap<>();
        dataMap.put("COMPANY_ID", COMPANY_ID);

        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }

    // 입력 insert
    public Object insert(Map dataMap) {
        String sqlMapId = "CarInfors.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

    // update
    public Object update(Map dataMap) {
        String sqlMapId = "CarInfors.update";
        Object result = sharedDao.update(sqlMapId, dataMap);
        return result;
    }

    // delete
    public Object delete(String CAR_INFOR_ID) {
        String sqlMapId = "CarInfors.delete";
        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

        Object result = sharedDao.update(sqlMapId, dataMap);
        return result;
    }

    // 2PC(2 pace commit) : 같은 값 인서트 2번 
    public Object insertDouble(Map dataMap) {
        String sqlMapId = "CarInfors.insert";
        // sucess
        Object result = sharedDao.insert(sqlMapId, dataMap);
        // error
        result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }


}

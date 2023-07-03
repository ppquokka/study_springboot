package com.example.study_springboot.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.study_springboot.dao.SharedDao;

@Service
public class HelloWorldService {
    @Autowired   // shasredDao 인스턴스화 됨
    SharedDao sharedDao;
    public int fakeselect(String companyId){   //2.컴퍼니아이디가 넘어왔는지
        HashMap dataMap = new HashMap<>();
        dataMap.put("companyId",companyId);
        sharedDao.getOne("fake.selectByUID", dataMap);
        return 0; 
    }

    public ArrayList fakeSelect(String currentPage, String perPage){
        // "spm_row": 471, "SN": 1, "CMPNM": "로이유통", "RDNMADR": null     line1
        // "spm_row": 571, "SN": 2, "CMPNM": "의료유통", "RDNMADR": 3        line2
        ArrayList arrayList = new ArrayList<>();                       
        HashMap resultMap = new HashMap<>();  
        resultMap.put("spm_row", 471);            resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");        resultMap.put("RDNMADR", null);
        arrayList.add(resultMap);

        resultMap = new HashMap<>();  
        resultMap.put("spm_row", 571);            resultMap.put("SN", 2);
        resultMap.put("CMPNM", "의료유통");        resultMap.put("RDNMADR", 3);
        arrayList.add(resultMap);

        return arrayList;
    }

    public void fakeSelect(String companyId) {
    }
}

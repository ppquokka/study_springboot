package com.example.study_springboot.restapis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_springboot.service.CarCompanyService;

@RestController
public class CarCompanyController {
    @Autowired
    CarCompanyService carCompanyService;

    // 예) 192.168.0.41:8080/selectSearch/COMPANY/자동차
    // 예) 192.168.0.41:8080/selectSearch/COMPANY_ID/3
    @GetMapping("/selectSearch/{search}/{words}")
    public ResponseEntity selectSearch(@PathVariable String search, @PathVariable String words) {
        Object result = carCompanyService.selectSearch(search, words);
        return ResponseEntity.ok().body(result);
    }

    // 192.168.0.41:8080/selectAll/C001
    @GetMapping("/selectAll/{COMPANY_ID}")
    public ResponseEntity selectAll(@PathVariable String COMPANY_ID) {
        Object result = carCompanyService.selectAll(COMPANY_ID);
        return ResponseEntity.ok().body(result);
    }

    // 192.168.0.41:8080/selectDetail/C004
    @GetMapping("/selectDetail/{COMPANY_ID}")
    public ResponseEntity selectDetail(@PathVariable String COMPANY_ID) {
        Object result = carCompanyService.selectDetail(COMPANY_ID);
        return ResponseEntity.ok().body(result);
    }

    // 192.168.0.41:8080/insert
    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody Map paramMap) {
        Object result = carCompanyService.insert(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // 192.168.0.41:8080/update
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Map paramMap) {
        Object result = carCompanyService.update(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // 192.168.0.41:8080/delete/C006
    @DeleteMapping("/delete/{COMPANY_ID}")
    public ResponseEntity delete(@PathVariable String COMPANY_ID) {
        Object result = carCompanyService.delete(COMPANY_ID);
        return ResponseEntity.ok().body(result);
    }

    // 192.168.0.41:8080/insertDouble
    @PostMapping("/insertDouble")
    public ResponseEntity insertDouble(@RequestBody Map paramMap) {
        Object result = null;
        try {
            result = carCompanyService.insertDouble(paramMap);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok().body(result);
    }
}

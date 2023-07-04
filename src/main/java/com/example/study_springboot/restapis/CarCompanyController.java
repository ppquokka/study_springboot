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
import com.example.study_springboot.service.CarInforsService;

@RestController
public class CarCompanyController {
    @Autowired
    CarCompanyService carCompanyService;

    // 예) /selectSearch/YEAR/2020
    // 예) /selectSearch/CAR_NAME/소
    @GetMapping("/selectSearch/{search}/{words}")
    public ResponseEntity selectSearch(@PathVariable String search, @PathVariable String words) {
        Object result = carCompanyService.selectSearch(search, words);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/selectAll/{CAR_INFOR_ID}")
    public ResponseEntity selectAll(@PathVariable String CAR_INFOR_ID) {
        Object result = carCompanyService.selectAll(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result);
    }

    // /selectDetail/CI002
    @GetMapping("/selectDetail/{CAR_INFOR_ID}")
    public ResponseEntity selectDetail(@PathVariable String CAR_INFOR_ID) {
        Object result = carCompanyService.selectDetail(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result);
    }

    // 입력 create
    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody Map paramMap) {
        Object result = carCompanyService.insert(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // update
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Map paramMap) {
        Object result = carCompanyService.update(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // delete
    @DeleteMapping("/delete/{CAR_INFOR_ID}")
    public ResponseEntity delete(@PathVariable String CAR_INFOR_ID) {
        Object result = carCompanyService.delete(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result);
    }

    // 2PC(2 pace commit)
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

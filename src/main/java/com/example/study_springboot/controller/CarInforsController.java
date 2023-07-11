package com.example.study_springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.study_springboot.service.CarInforsService;

@Controller
@RequestMapping("/carInfor")
public class CarInforsController {
    @Autowired
    CarInforsService carInforsService;

    // foreach문
    @GetMapping("/selectInUID")
    public ResponseEntity selectInUID(@RequestBody Map paramMap) {
        Object result = null;
        try {
            result = carInforsService.selectInUID(paramMap);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok().body(result);
    }

    // SelectSearch
    // 예) /selectSearch/YEAR/2020
    // 예) /selectSearch/CAR_NAME/소
    // @GetMapping("/selectSearch/{search}/{words}")
    // public ResponseEntity selectSearch(@PathVariable String search, @PathVariable
    // String words) {
    // Object result = carInforsService.selectSearch(search, words);
    // return ResponseEntity.ok().body(result);
    // }

    // 예) /selectSearch?search=YEAR%words=2020
    // 위의 url로 날아오면, JS는 search=YEAR를 '이름값이름값'으로
    // hashmap으로 묶어서 들여옴
    // words가 params에 들어옴
    @GetMapping("/selectSearch")
    public ModelAndView selectSearch(@RequestParam Map params, ModelAndView modelAndView) {
        Object result = carInforsService.selectSearch(params);
        modelAndView.addObject("params", params); // 메인컨트롤러에서가져옴
        modelAndView.addObject("result", result);

        // modelAndView.setViewName("/WEB-INF/views/main.jsp");
        modelAndView.setViewName("/WEB-INF/views/carinfor/list.jsp");

        return modelAndView;
    }


     // deleteAndSelectSearch with MVC
     @PostMapping("/deleteAndSelectSearch")
    public ModelAndView deleteAndSelectSearch(@RequestParam Map params, ModelAndView modelAndView) {
        Object result = carInforsService.deleteAndSelectSearch(params);
        modelAndView.addObject("params", params);
        modelAndView.addObject("result", result);

        modelAndView.setViewName("/WEB-INF/views/carinfor/list_map.jsp");
        return modelAndView;
    }


    // delete with MVC 
    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam Map params, ModelAndView modelAndView) {
        Object result = carInforsService.delete(params);
        modelAndView.addObject("params", params);
        modelAndView.addObject("result", result);

        modelAndView.setViewName("/WEB-INF/views/carinfor/list.jsp");
        return modelAndView;
    }

    @GetMapping("/selectAll/{CAR_INFOR_ID}")
    public ResponseEntity selectAll(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.selectAll(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result);
    }

    // /selectDetail/CI002
    @GetMapping("/selectDetail/{CAR_INFOR_ID}")
    public ResponseEntity selectDetail(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.selectDetail(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result);
    }

    // 입력 create
    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody Map paramMap) {
        Object result = carInforsService.insert(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // update
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Map paramMap) {
        Object result = carInforsService.update(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // delete
    @DeleteMapping("/delete/{CAR_INFOR_ID}")
    public ResponseEntity delete(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.delete(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result);
    }

    // 2PC(2 pace commit)
    @PostMapping("/insertDouble")
    public ResponseEntity insertDouble(@RequestBody Map paramMap) {
        Object result = null;
        try {
            result = carInforsService.insertDouble(paramMap);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok().body(result);
    }
}

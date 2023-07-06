package com.example.study_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping({"/", "/home", "/main"})
    public ModelAndView main(ModelAndView modelAndView){
        modelAndView.addObject("name", "JiwonKim :)");  // 자료 넘기기
        modelAndView.setViewName("/WEB-INF/views/main.jsp");  // 뷰 보내기
        return modelAndView;
    }
}




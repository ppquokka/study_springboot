package com.example.study_springboot;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/firstServlets")
public class FirstServlets extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) {
            System.out.println("성공");
        }

    }


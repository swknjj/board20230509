package com.icia.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // 인덱스로
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // 회원가입 창으로 이동
    @GetMapping("memberSave")
    public String memberSaveForm() {
        return "/boardPages/memberSave";
    }

    // 로그인페이지로
    @GetMapping("/memberLogin")
    public String memberLoginForm() {
        return "memberLogin";
    }
}

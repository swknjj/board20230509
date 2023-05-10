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
    @GetMapping("/member/Save")
    public String memberSaveForm() {
        return "/memberPages/memberSave";
    }

    // 로그인페이지로
    @GetMapping("/member/Login")
    public String memberLoginForm() {
        return "/memberPages/memberLogin";
    }

    // 글 작성 페이지로
    @GetMapping("/board/Save")
    public String boardSaveForm() {
        return "/boardPages/boardSave";
    }

//    // 멤버리스트 페이지로
//    @GetMapping("/member/memberList")
//    public String memberList() {
//        return "/memberPages/memberList";
//    }
}

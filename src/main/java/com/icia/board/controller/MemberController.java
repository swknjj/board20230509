package com.icia.board.controller;

import com.icia.board.dto.MemberDTO;
import com.icia.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    // 회원가입 창으로 이동
    @GetMapping("memberSave")
    public String memberSaveForm() {
        return "/boardPages/memberSave";
    }

    // 회원가입 데이터 전달
    @PostMapping("/member/save")
    public String memberSave(@ModelAttribute MemberDTO memberDTO) {
        int result = memberService.memberSave(memberDTO);
        if (result == 1) {
            return "/boardPages/memberList";
        } else {
            return "errorPage";
        }
    }


}

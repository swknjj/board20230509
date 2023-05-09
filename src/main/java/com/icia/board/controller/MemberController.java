package com.icia.board.controller;

import com.icia.board.dto.MemberDTO;
import com.icia.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    // 회원가입 데이터 전달
    @PostMapping("/member/save")
    public String memberSave(@ModelAttribute MemberDTO memberDTO) {
        int result = memberService.memberSave(memberDTO);
        if (result == 1) {
            return "/boardPages/boardList";
        } else {
            return "/response/saveErrorPage";
        }
    }

    // 멤버 로그인
    @PostMapping("/member/login")
    public String memberLogin(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO member = memberService.memberLogin(memberDTO);
        if(member != null){
            session.setAttribute("loginEmail",memberDTO.getMemberEmail());
            return "/boardPages/boardList";
        }else {
            return "/response/loginErrorPage";
        }
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/response/logout";

    }


}

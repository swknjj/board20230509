package com.icia.board.controller;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.MemberDTO;
import com.icia.board.dto.PageDTO;
import com.icia.board.service.BoardService;
import com.icia.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;
    @Autowired
    MemberService memberService;

    @PostMapping("/board/Save")
    public String boardSave(@ModelAttribute BoardDTO boardDTO, HttpSession session) {
        String loginEmail = (String) session.getAttribute("loginEmail");
        MemberDTO memberDTO = memberService.findByEmail(loginEmail);
        if(memberDTO != null){
            boardDTO.setBoardWriter(memberDTO.getId());
            boardService.boardSave(boardDTO);
            return "redirect:/board/boardList";
        }else {
            return "/response/errorPage";
        }
    }
    @GetMapping("/board/boardList")
    public String boardList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                            @RequestParam(value = "q", required = false, defaultValue = "") String q,
                            @RequestParam(value = "type", required = false, defaultValue = "boardTitle") String type, Model model,HttpSession session) {
        List<BoardDTO> boardDTOList = null;
        PageDTO pageDTO = null;
        if(q.equals("")){
            boardDTOList = boardService.boardList(page);
            pageDTO = boardService.pagingParam(page);
        }else {
            boardDTOList = boardService.searchList(page,type,q);
            pageDTO = boardService.pagingSearchParam(page,type,q);
        }
        if(session.getAttribute("loginEmail")!=null) {
            String loginEmail = (String) session.getAttribute("loginEmail");
            MemberDTO memberDTO = memberService.findByEmail(loginEmail);
            Long id = memberDTO.getId();
            model.addAttribute("boardList", boardDTOList);
            model.addAttribute("paging", pageDTO);
            model.addAttribute("q", q);
            model.addAttribute("type", type);
            model.addAttribute("memberId", id);
        }else {
            Long id = null;
            model.addAttribute("boardList", boardDTOList);
            model.addAttribute("paging", pageDTO);
            model.addAttribute("q", q);
            model.addAttribute("type", type);
            model.addAttribute("memberId", id);

        }
        return "/boardPages/boardList";
    }


}

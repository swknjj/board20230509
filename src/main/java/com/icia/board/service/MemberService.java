package com.icia.board.service;

import com.icia.board.dto.MemberDTO;
import com.icia.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public int memberSave(MemberDTO memberDTO) {
        return memberRepository.memberSave(memberDTO);
    }

    public MemberDTO findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}

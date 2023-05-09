package com.icia.board.repository;

import com.icia.board.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public int memberSave(MemberDTO memberDTO) {
        return sql.insert("Member.memberSave",memberDTO);
    }

    public MemberDTO findByEmail(String email) {
        return sql.selectOne("Member.findByEmail",email);
    }

    public MemberDTO memberLogin(MemberDTO memberDTO) {
        return sql.selectOne("Member.memberLogin",memberDTO);
    }
}

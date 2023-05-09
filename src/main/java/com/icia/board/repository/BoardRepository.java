package com.icia.board.repository;

import com.icia.board.dto.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;


    public void boardSave(BoardDTO boardDTO) {
        sql.insert("Board.boardSave",boardDTO);
    }

    public List<BoardDTO> boardList(Map<String, Integer> pagingParams) {
        return sql.selectList("Board.boardList",pagingParams);
    }

    public int boardCount() {
        return sql.selectOne("Board.boardCount");
    }

    public List<BoardDTO> searchList(Map<String, Object> pagingParams) {
        return sql.selectList("Board.search",pagingParams);
    }

    public int boardSearchCount(Map<String, Object> pagingParams) {
        return sql.selectOne("Board.boardSearchCount",pagingParams);
    }
}

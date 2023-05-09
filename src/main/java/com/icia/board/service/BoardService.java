package com.icia.board.service;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;
import com.icia.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    public void boardSave(BoardDTO boardDTO) {
        boardRepository.boardSave(boardDTO);
    }

    public List<BoardDTO> boardList(int page) {
        int pageLimit = 5;
        int pagingStart = (page - 1) * pageLimit;
        Map<String, Integer> pagingParams = new HashMap<>();
        pagingParams.put("start", pagingStart);
        pagingParams.put("limit", pageLimit);
        List<BoardDTO> boardDTOList = boardRepository.boardList(pagingParams);
        return boardDTOList;
    }

    public PageDTO pagingParam(int page) {
        // 한 페이지에 보여줄 글 갯수
        int pageLimit = 5;
        // 하단에 보여줄 페이지 번호 갯수
        int blockLimit = 5;
        // 전체 글 갯수 조회
        int boardCount = boardRepository.boardCount();
        // 전체 페이지 갯수 계산
        int maxPage = (int) (Math.ceil((double) boardCount / pageLimit));
        // 시작 페이지 계산
        int startPage = (((int) (Math.ceil((double) page / blockLimit))) - 1) + blockLimit;
        // 마지막 페이지 값 계산
        int endPage = startPage + blockLimit - 1;
        // 전체 페이지 갯수가 계산한 endPage보다 작을때는 endPage를 maxPage와 같게 세팅
        if (endPage > maxPage) {
            endPage = maxPage;
        }
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setEndPage(endPage);
        pageDTO.setStartPage(startPage);
        return pageDTO;
    }

    public List<BoardDTO> searchList(int page, String type, String q) {
        int pageLimit = 5;
        int pagingStart = (page-1)*pageLimit;
        Map<String, Object> pagingParams = new HashMap<>();
        pagingParams.put("start",pagingStart);
        pagingParams.put("limit",pageLimit);
        pagingParams.put("q",q);
        pagingParams.put("type",type);
        List<BoardDTO> boardDTOList = boardRepository.searchList(pagingParams);
        return boardDTOList;

    }

    public PageDTO pagingSearchParam(int page, String type, String q) {
        // 한 페이지에 보여줄 글 갯수
        int pageLimit = 5;
        // 하단에 보여줄 페이지 번호 갯수
        int blockLimit = 5;
        Map<String,Object> pagingParams = new HashMap<>();
        pagingParams.put("q",q);
        pagingParams.put("type",type);
        // 전체 글 갯수 조회
        int boardCount = boardRepository.boardSearchCount(pagingParams);
        // 전체 페이지 갯수 계산
        int maxPage = (int) (Math.ceil((double) boardCount / pageLimit));
        // 시작 페이지 계산
        int startPage = (((int) (Math.ceil((double) page / blockLimit))) - 1) + blockLimit;
        // 마지막 페이지 값 계산
        int endPage = startPage + blockLimit - 1;
        // 전체 페이지 갯수가 계산한 endPage보다 작을때는 endPage를 maxPage와 같게 세팅
        if (endPage > maxPage) {
            endPage = maxPage;
        }
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setEndPage(endPage);
        pageDTO.setStartPage(startPage);
        return pageDTO;
    }
}

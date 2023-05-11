<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-09
  Time: 오후 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<%@include file="../component/header.jsp" %>
<%@include file="../component/nav.jsp" %>
<div id="section">
    <h2>글 상세보기</h2>
    <form action="#" method="post">
        작성자 = ${BoardDTO.boardWriter}<br>
        조회수 = ${BoardDTO.boardHits}<br>
        작성시간 = ${BoardDTO.boardCreatedDate}<br>
        <label for="board-title">글 제목</label><br>
        <textarea name="boardTitle" id="board-title" style="width: 50%; height: 10%">${BoardDTO.boardTitle}</textarea><br>

        <label for="board-contents">글 내용</label><br>
        <textarea name="boardContents" id="board-contents" placeholder="내용 입력" style="width: 50%; height: 30%">${BoardDTO.boardContents}</textarea><br>
</form>
</div>
<%@include file="../component/footer.jsp" %>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
<%@include file="../component/header.jsp"%>
<%@include file="../component/nav.jsp"%>
<div id="section">
  <h2>My Page</h2>
  <form action="/member/update" method="post">
    <label for="member-id">아이디</label><br>
    <input type="text" id="member-id" name="id" value="${LoginDTO.id}" disabled="disabled"><br>

    <label for="member-email">이메일</label><br>
    <input type="text" id="member-email" name="memberEmail" value="${LoginDTO.memberEmail}" disabled="disabled"><br>

    <label for="member-password">비밀번호</label><br>
    <input type="text" id="member-password" name="memberPassword" value="${LoginDTO.memberPassword}" disabled="disabled"><br>

    <label for="member-name">이름</label><br>
    <input type="text" id="member-name" name="memberName" value="${LoginDTO.memberName}" disabled="disabled"><br>

    <label for="member-mobile">전화번호</label><br>
    <input type="text" id="member-mobile" name="memberMobile" value="${LoginDTO.memberMobile}" disabled="disabled"><br>
    <c:if test="${LoginDTO.fileAttached == 1}">
    <label for="member-profile">프로필 사진</label><br>
      <div id="member-profile">
      <c:forEach items="${memberprofileDTO}" var="memberFile">
        <img src="${pageContext.request.contextPath}/upload/${memberFile.storedFileName}"
             alt="" width="100" height="100">
      </c:forEach>
      </div>
    </c:if>
  </form>
</div>
<%@include file="../component/footer.jsp"%>
</body>
<script>

</script>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>게시판 목록</title>
</head>
<body>
<h2>게시판 목록</h2>
<a href="/posts/write">글쓰기</a>
<table border="1">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>
    <c:forEach var="post" items="${posts}">
        <tr>
            <td>${post.id}</td>
            <td><a href="/posts/${post.id}">${post.title}</a></td>
            <td>${post.nickname}</td>
            <td>${post.uploaddate}</td>
            <td>${post.viewcount}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>게시글 상세</title>
</head>
<body>
<h2>${post.title}</h2>
<p><strong>작성자:</strong> ${post.nickname} (${post.loginid})</p>
<p><strong>작성일:</strong> ${post.uploaddate}</p>
<p><strong>수정일:</strong> ${post.modifydate}</p>
<p><strong>조회수:</strong> ${post.viewcount}</p>
<p><strong>내용:</strong><br>${post.content}</p>

<c:if test="${not empty post.imagepath0}">
    <p><img src="/upload/${post.imagepath0}" width="200"></p>
</c:if>
<c:if test="${not empty post.imagepath1}">
    <p><img src="/upload/${post.imagepath1}" width="200"></p>
</c:if>
<c:if test="${not empty post.imagepath2}">
    <p><img src="/upload/${post.imagepath2}" width="200"></p>
</c:if>
<c:if test="${not empty post.imagepath3}">
    <p><img src="/upload/${post.imagepath3}" width="200"></p>
</c:if>
<c:if test="${not empty post.imagepath4}">
    <p><img src="/upload/${post.imagepath4}" width="200"></p>
</c:if>

<br>
<a href="/posts/edit/${post.id}">수정</a>
<form method="post" action="/posts/delete/${post.id}" style="display:inline;">
    <input type="submit" value="삭제">
</form>
<br><a href="/posts">목록으로</a>
</body>
</html>

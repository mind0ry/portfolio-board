<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>글 수정</title>
</head>
<body>
<h2>게시글 수정</h2>
<form method="post" action="/posts/update/${post.id}">
    <label>제목: <input type="text" name="title" value="${post.title}" required></label><br>
    <label>내용:<br><textarea name="content" rows="5" cols="50">${post.content}</textarea></label><br>
    <input type="submit" value="수정하기">
</form>
<a href="/posts/${post.id}">뒤로</a>
</body>
</html>

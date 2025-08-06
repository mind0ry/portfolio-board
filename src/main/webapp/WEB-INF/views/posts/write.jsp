<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 작성</title>
</head>
<body>
<h2>게시글 작성</h2>
<form method="post" action="/posts/create" enctype="multipart/form-data">
    <label>작성자 ID: <input type="text" name="loginid" required></label><br>
    <label>닉네임: <input type="text" name="nickname"></label><br>
    <label>제목: <input type="text" name="title" required></label><br>
    <label>내용:<br><textarea name="content" rows="5" cols="50"></textarea></label><br>

    <label>이미지 업로드 (최대 5개):</label><br>
    <input type="file" name="images" multiple accept="image/*"><br><br>

    <input type="submit" value="작성하기">
</form>
<a href="/posts">목록으로</a>
</body>
</html>

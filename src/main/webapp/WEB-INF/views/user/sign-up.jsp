<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.2.3/css/bootstrap.css">
</head>
<body>
<div class="container row">
    <div class="w-50 position-absolute top-50 start-50 translate-middle">
        <h1 class="mb-5 d-flex justify-content-center">회원가입</h1>
        <form method="post" action="${pageContext.request.contextPath}/sign-up" name="signUpForm">
            <div class="form-floating mb-3">
                <input class="form-control" id="input-username" type="text" name="username">
                <label for="input-username">로그인 ID</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="input-password" type="password" name="password">
                <label for="input-password">비밀번호</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="input-nickname" type="text" name="nickname">
                <label for="input-nickname">닉네임</label>
            </div>
        </form>
        <div class="float-end">
            <button class="btn btn-secondary" onclick="function back() {
                location.href = '/login'
            } back()">취소
            </button>
            <button class="btn btn-primary" onclick="function signUp() {
                document.signUpForm.submit()
            } signUp()">가입하기
            </button>
        </div>
    </div>
</div>
</body>
</html>

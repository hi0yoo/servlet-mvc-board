<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.2.3/css/bootstrap.css">
</head>
<body>
<div class="container row">
    <div class="w-50 position-absolute top-50 start-50 translate-middle">
        <h1 class="mb-5 d-flex justify-content-center">로그인</h1>
        <form method="post" action="${pageContext.request.contextPath}/login" name="loginForm">
            <div class="form-floating mb-3">
                <input class="form-control" id="input-username" type="text" name="username">
                <label for="input-username">로그인 ID</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="input-password" type="password" name="password">
                <label for="input-password">비밀번호</label>
            </div>
        </form>
        <div class="float-end">
            <button class="btn btn-outline-primary" onclick="function signUpPage() {
                location.href = '${pageContext.request.contextPath}/sign-up'
            } signUpPage()">회원가입
            </button>
            <button class="btn btn-primary" onclick="function login() {
            document.loginForm.submit()
        } login()">로그인
            </button>
        </div>
    </div>
</div>
</body>
</html>

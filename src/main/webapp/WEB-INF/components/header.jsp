<%@ page import="bit.report.servletmvcboard.dto.LoginUserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-3">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/article/list">Servlet MVC Board</a>
        <%
            LoginUserInfo loginUser = (LoginUserInfo) session.getAttribute("loginUser");
            if (loginUser != null) {
        %>
        <div class="float-end nav-item">
            <button class="btn btn-info" onclick="function mypage() {
                location.href = '${pageContext.request.contextPath}/my-page'
            } mypage()">마이페이지</button>
            <button class="btn btn-secondary" onclick="function logout() {
                document.logoutForm.submit()
            } logout()">로그아웃</button>
            <form hidden="hidden" method="post" action="${pageContext.request.contextPath}/logout" name="logoutForm"></form>
        </div>
        <%
        } else {
        %>
        <div class="float-end nav-item">
            <button class="btn btn-dark" onclick="function loginPage() {
                location.href = '${pageContext.request.contextPath}/login'
            } loginPage()">로그인</button>
        </div>
        <%
            }
        %>
    </div>
</nav>

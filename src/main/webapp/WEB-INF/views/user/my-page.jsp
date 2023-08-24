<%@ page import="bit.report.servletmvcboard.dto.ArticleSummary" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="bit.report.servletmvcboard.dto.LoginUserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>마이페이지</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.2.3/css/bootstrap.css">
</head>
<body class="w-50" style="margin: 0 auto;">
<div class="container row">
    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/components/header.jsp"/>
    <div>
        <h1 class="mb-3 d-flex justify-content-center">마이페이지</h1>
        <div>
            <h3>유저 정보</h3>
            <%
                LoginUserInfo loginUserInfo = (LoginUserInfo) session.getAttribute("loginUser");
            %>
            <div class="mb-1 row">
                <label for="username" class="col-sm-2 col-form-label">USERNAME</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control disabled" id="username" value="<%=loginUserInfo.getUsername()%>">
                </div>
            </div>
            <div class="mb-1 row">
                <label for="input-nickname" class="col-sm-2 col-form-label">NICKNAME</label>
                <div class="col-sm-10">
                    <form name="userUpdateForm" method="post" action="${pageContext.request.contextPath}/user/update">
                        <input type="text" class="form-control" id="input-nickname" name="nickname" value="<%=loginUserInfo.getNickname()%>">
                    </form>
                </div>
            </div>
        </div>
        <hr>
        <div>
            <h3>좋아요 리스트</h3>
        </div>
        <hr>
        <div>
            <h3>싫어요 리스트</h3>
        </div>
        <hr>
        <div>
            <h3>스크랩 리스트</h3>
            <%
                List<ArticleSummary> scrapedArticleList = (List<ArticleSummary>) request.getAttribute("scrapedArticleList");
                for (ArticleSummary articleSummary : scrapedArticleList) {
            %>
            <div id="article-<%=articleSummary.getArticleId()%>" class="card" onclick="function detailPage() {
                    location.href = '${pageContext.request.contextPath}/article/detail?article-id=<%=articleSummary.getArticleId()%>'
                    } detailPage()">
                <div class="card-body">
                    <h5 class="card-title">제목 : <%=articleSummary.getTitle()%>
                    </h5>
                    <h6 class="card-subtitle mb-1 text-muted">작성자 : <%=articleSummary.getUserInfo().getNickname()%>
                    </h6>
                    <p class="card-text text-muted text-end">작성일
                        : <%=articleSummary.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))%>
                    </p>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
</body>
<script>
    const enterListener = (event) => {
        if (event.keyCode === 13) {
            event.preventDefault();
            document.userUpdateForm.submit()
        }
    };

    document.getElementById("input-nickname").addEventListener("keyup", enterListener);
</script>
</html>

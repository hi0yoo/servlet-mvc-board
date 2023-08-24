<%@ page import="bit.report.servletmvcboard.dto.ArticleSummaryDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="bit.report.servletmvcboard.dto.LoginUserInfoDto" %>
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
                LoginUserInfoDto loginUserInfo = (LoginUserInfoDto) session.getAttribute("loginUser");
            %>
            <div class="mb-1 row">
                <label for="username" class="col-sm-2 col-form-label">USERNAME</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control disabled" id="username"
                           value="<%=loginUserInfo.getUsername()%>">
                </div>
            </div>
            <div class="mb-1 row">
                <label for="input-nickname" class="col-sm-2 col-form-label">NICKNAME</label>
                <div class="col-sm-10">
                    <form name="userUpdateForm" method="post" action="${pageContext.request.contextPath}/user/update">
                        <input type="text" class="form-control" id="input-nickname" name="nickname"
                               value="<%=loginUserInfo.getNickname()%>">
                    </form>
                </div>
            </div>
        </div>
        <hr>
        <div>
            <h3>좋아요 리스트</h3>
            <%
                List<ArticleSummaryDto> likedArticleList = (List<ArticleSummaryDto>) request.getAttribute("likedArticleList");
                if (likedArticleList.isEmpty()) {
            %>
            <h4>없음!!</h4>
            <%
            } else {
                for (ArticleSummaryDto articleSummary : likedArticleList) {
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
                }
            %>
        </div>
        <hr>
        <div>
            <h3>싫어요 리스트</h3>
            <%
                List<ArticleSummaryDto> unlikedArticleList = (List<ArticleSummaryDto>) request.getAttribute("unlikedArticleList");
                if (unlikedArticleList.isEmpty()) {
            %>
            <h4>없음!!</h4>
            <%
            } else {
                for (ArticleSummaryDto articleSummary : unlikedArticleList) {
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
                }
            %>
        </div>
        <hr>
        <div>
            <h3>스크랩 리스트</h3>
            <%
                List<ArticleSummaryDto> scrapedArticleList = (List<ArticleSummaryDto>) request.getAttribute("scrapedArticleList");
                if (scrapedArticleList.isEmpty()) {
            %>
            <h4>없음!!</h4>
            <%
            } else {
                for (ArticleSummaryDto articleSummary : scrapedArticleList) {
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

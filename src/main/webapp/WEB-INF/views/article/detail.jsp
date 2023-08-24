<%@ page import="bit.report.servletmvcboard.dto.ArticleDetailsDto" %>
<%@ page import="bit.report.servletmvcboard.dto.LoginUserInfo" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 상세</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.2.3/css/bootstrap.css">
</head>
<body class="w-50" style="margin: 0 auto;">
<%
    ArticleDetailsDto articleDetails = (ArticleDetailsDto) request.getAttribute("articleDetails");
%>

<div class="container row">
    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/components/header.jsp"/>
    <h1 class="mb-3 d-flex justify-content-center">게시글 상세</h1>
    <div>
            <span>
                <button class="btn btn-outline-primary" onclick="function listPage() {
                        location.href = '${pageContext.request.contextPath}/article/list'
                        } listPage()">목록으로</button>
            </span>
        <%
            LoginUserInfo userInfo = (LoginUserInfo) session.getAttribute("loginUser");
            if (userInfo != null && articleDetails.getUserInfo().getUserId().equals(userInfo.getUserId())) {
        %>
        <span class="float-end">
                <button class="btn btn-outline-primary" onclick="function articleUpdatePage() {
                        location.href = '${pageContext.request.contextPath}/article/update?article-id=<%=articleDetails.getArticleId()%>'
                        } articleUpdatePage()">수정
                </button>
                <button class="btn btn-outline-primary" onclick="function articleDelete() {
                    document.articleDeleteForm.submit()
                } articleDelete()">삭제
                </button>
                <form name="articleDeleteForm" hidden="hidden" method="post"
                      action="${pageContext.request.contextPath}/article/delete">
                    <input hidden="hidden" name="articleId" type="number" value="<%=articleDetails.getArticleId()%>">
                </form>
            </span>
        <%
            }
        %>
    </div>
    <br>
    <div class="mb-3">
        <table class="table table-bordered w-100">
            <thead>
            <tr>
                <th>작성자</th>
                <th style="width: 35%;">작성일</th>
                <th style="width: 35%;">수정일</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><%=articleDetails.getUserInfo().getNickname()%>
                </td>
                <td><%=articleDetails.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))%>
                </td>
                <td><%=articleDetails.getLastModifiedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))%>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="mb-3">
        <label class="form-label" for="input-title">제목</label>
        <input readonly class="form-control form-control-lg" id="input-title" type="text" name="title"
               value="<%=articleDetails.getTitle()%>">
    </div>
    <div class="mb-3">
        <label class="form-label" for="input-content">내용</label>
        <textarea readonly class="form-control form-control-lg" id="input-content" name="content" rows="10"
                  style="resize: none;"><%=articleDetails.getContent()%>
            </textarea>
    </div>
    <div class="mb-3 d-flex justify-content-center">
            <span>
                <button class="btn btn-outline-primary m-2" onclick="function like() {
                        <!-- articleLikeForm 전송 -->
                        document.articleLikeForm.submit();
                    } like()">좋아요 <span class="badge bg-danger">4</span></button><!-- 여기 span 내부에 count 변수 삽입 -->
                <%-- hidden form이라 안보인다. --%>
                <form name="articleLikeForm" hidden="hidden" method="post"
                      action="${pageContext.request.contextPath}/article/like">
                    <input hidden="hidden" name="articleId" value="<%=articleDetails.getArticleId()%>">
                </form>
            </span>

        <span>
                <button class="btn btn-outline-primary m-2" onclick="function unlike() {
                <%-- articleUnlikeForm 전송 --%>
                        document.articleUnlikeForm.submit();
                        } unlike()">싫어요 <span class="badge bg-danger">4</span></button><!-- 여기 span 내부에 count 변수 삽입 -->
                <%-- hidden form이라 안보인다. --%>
                <form name="articleUnlikeForm" hidden="hidden" method="post"
                      action="${pageContext.request.contextPath}/article/unlike">
                    <input hidden="hidden" name="articleId" value="<%=articleDetails.getArticleId()%>">
                </form>
            </span>

        <span>
                <%
                    if (!articleDetails.isScraped()) {
                %>
                <button class="btn btn-outline-primary m-2" onclick="function scrap() {
                    document.articleScrapForm.submit()
                    } scrap()">스크랩</button>
                <%
                } else {
                %>
                <button class="btn btn-outline-primary m-2" onclick="function scrap() {
                    document.articleScrapForm.submit()
                    } scrap()">스크랩 취소</button>
                <%
                    }
                %>
                <form name="articleScrapForm" hidden="hidden" method="post"
                      action="${pageContext.request.contextPath}/article/scrap">
                    <input hidden="hidden" name="articleId" value="<%=articleDetails.getArticleId()%>">
                </form>
            </span>
    </div>
</div>
</body>
</html>

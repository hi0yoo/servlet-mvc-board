<%@ page import="bit.report.servletmvcboard.dto.ArticleDetailsDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 수정</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.2.3/css/bootstrap.css">
</head>
<body>
<%
    ArticleDetailsDto articleDetails = (ArticleDetailsDto) request.getAttribute("articleDetails");
%>
<div class="container row">
    <div class="w-50 position-absolute top-50 start-50 translate-middle">
        <h1 class="mb-5 d-flex justify-content-center">게시글 수정</h1>
        <form method="post" action="${pageContext.request.contextPath}/article/update" name="articleForm">
            <div class="mb-3">
                <label class="form-label" for="input-title">제목</label>
                <input class="form-control" id="input-title" type="text" name="title"
                       value="<%=articleDetails.getTitle()%>">
            </div>
            <div class="mb-3">
                <label class="form-label" for="input-content">내용</label>
                <textarea class="form-control" id="input-content" name="content" rows="10"
                          style="resize: none;"><%=articleDetails.getContent()%></textarea>
            </div>
            <input hidden="hidden" name="article-id" value="<%=articleDetails.getArticleId()%>">
        </form>
        <div class="float-end">
            <button class="btn btn-secondary" onclick="function back() {
                    location.href = '${pageContext.request.contextPath}/article/detail?article-id=<%=articleDetails.getArticleId()%>'
                    } back()">취소
            </button>
            <button class="btn btn-primary" onclick="function createArticle() {
                document.articleForm.submit()
            } createArticle()">수정 완료
            </button>
        </div>
    </div>
</div>
</body>
</html>

<%@ page import="bit.report.servletmvcboard.dto.ArticleSummary" %>
<%@ page import="bit.report.servletmvcboard.dto.PagingDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 리스트</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.2.3/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
</head>
<body>
<div class="container row">
    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/components/header.jsp"/>
    <div>
        <h1 class="mb-3 d-flex justify-content-center">게시글 리스트</h1>
        <div class="mb-3 float-end">
            <button class="btn btn-primary" onclick="function writePage() {
                location.href = '/article/create'
            } writePage()">게시글 작성</button>
        </div>
        <div>
            <div class="input-group mb-3">
                <input class="form-control" id="input-keyword" type="text" name="keyword" placeholder="검색어">
                <button class="btn btn-outline-primary" type="button" onclick="function search() {
                    let keyword = document.querySelector('#input-keyword').value

                    let path = '/article/list?page=0'
                    if (keyword.length !== 0) path = '/article/list?page=0&keyword=' + keyword

                    location.href = path
                } search()">검색
                </button>
            </div>
        </div>
        <%
            PagingDto<ArticleSummary> pagingDto = (PagingDto<ArticleSummary>) request.getAttribute("pagingDto");
            for (ArticleSummary result : pagingDto.getResults()) {
        %>
        <div id="article-<%=result.getArticleId()%>" class="card" onclick="function detailPage() {
                location.href = '/article/detail?article-id=<%=result.getArticleId()%>'
                } detailPage()">
            <div class="card-body">
                <h5 class="card-title">제목 : <%=result.getTitle()%>
                </h5>
                <h6 class="card-subtitle mb-1 text-muted">작성자 : <%=result.getUserInfo().getNickname()%>
                </h6>
                <p class="card-text text-muted text-end">작성일 : <%=result.getCreatedAt()%>
                </p>
            </div>
        </div>
        <%
            }
        %>
        <div class="mt-3 mb-5 d-flex justify-content-center">
            <button class="btn btn-primary m-2" <%=pagingDto.isFirstPage() ? "disabled" : null%>
                    onclick="function prevPage() {
                            location.href = '/article/list?page=<%=pagingDto.getCurrentPageNumber() - 1%>'
                            } prevPage()">PREV
            </button>
            <button class="btn btn-primary m-2" <%=pagingDto.isLastPage() ? "disabled" : null%>
                    onclick="function nextPage() {
                            location.href = '/article/list?page=<%=pagingDto.getCurrentPageNumber() + 1%>'
                            } nextPage()">NEXT
            </button>
        </div>
    </div>
</div>
</body>
</html>

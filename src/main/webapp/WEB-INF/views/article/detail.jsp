<%@ page import="bit.report.servletmvcboard.dto.ArticleDetailsDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 상세</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.2.3/css/bootstrap.css">
</head>
<body>
<%
    ArticleDetailsDto articleDetails = (ArticleDetailsDto) request.getAttribute("articleDetails");
%>

<div class="container row">
    <div class="w-50 position-absolute top-50 start-50 translate-middle">
        <h1 class="mb-3 d-flex justify-content-center">게시글 상세</h1>
        <div class="mb-3">
            <label class="form-label" for="input-title">제목</label>
            <input readonly class="form-control form-control-lg" id="input-title" type="text" name="title"
                   value="<%=articleDetails.getTitle()%>">
        </div>
        <div class="mb-3">
            <label class="form-label" for="input-content">내용</label>
            <textarea readonly class="form-control form-control-lg" id="input-content" name="content" rows="10"
                      style="resize: none;">
                    <%=articleDetails.getContent()%>
            </textarea>
        </div>
<%--    TODO 수정/삭제 버튼, 좋아요/싫어요 버튼, 스크랩 버튼    --%>
    </div>
</div>
</body>
</html>

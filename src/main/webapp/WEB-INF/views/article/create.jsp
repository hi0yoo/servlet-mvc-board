<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 작성</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.2.3/css/bootstrap.css">
</head>
<body>
<div class="container row">
    <div class="w-50 position-absolute top-50 start-50 translate-middle">
        <h1 class="mb-5 d-flex justify-content-center">게시글 작성</h1>
        <form method="post" action="${pageContext.request.contextPath}/article/create" name="articleForm">
            <div class="mb-3">
                <label class="form-label" for="input-title">제목</label>
                <input class="form-control" id="input-title" type="text" name="title">
            </div>
            <div class="mb-3">
                <label class="form-label" for="input-content">내용</label>
                <textarea class="form-control" id="input-content" name="content" rows="10" style="resize: none;"></textarea>
            </div>
        </form>
        <div class="float-end">
            <button class="btn btn-secondary" onclick="function back() {
                location.href = '${pageContext.request.contextPath}/article/list'
            } back()">취소</button>
            <button class="btn btn-primary" onclick="function createArticle() {
                document.articleForm.submit()
            } createArticle()">작성 완료
            </button>
        </div>
    </div>
</div>
</body>
</html>

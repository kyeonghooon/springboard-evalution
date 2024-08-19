<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- header.jsp -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<!-- start of context.jsp(xxx.jsp) -->
<div class="col-sm-9">
	<h2>글수정</h2>
	<br>
	<form action="/board/${board.id}/update" method="post">
		<div class="form-group">
			<label for="title">title:</label> <input type="text" class="form-control" placeholder="Enter title" id="title" name="title" value="${board.title}">
		</div>
		<div class="form-group">
			<label for="content">content:</label> <input type="text" class="form-control" placeholder="Enter content" id="content" name="content" value="${board.content}">
		</div>
		<div class="form-group">
			<label for="author">author:</label> <input type="text" class="form-control" placeholder="Enter author" id="author" name="author" value="${board.author}">
		</div>
		<div class="text-right">
			<button type="submit" class="btn btn-primary">수정</button>
		</div>
	</form>
</div>
<!-- end of col-sm-8 -->
</div>
</div>
<!-- end of context.jsp(xxx.jsp) -->

</div>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- header.jsp -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<!-- start of context.jsp(xxx.jsp) -->
<div class="col-sm-8">
	<h2>글쓰기</h2>
	
	<form action="/board/save" method="post">
		<div class="form-group">
			<label for="title">title:</label> <input type="text" class="form-control" placeholder="Enter title" id="title" name="title" value="임시제목">
		</div>
		<div class="form-group">
			<label for="content">content:</label> <input type="text" class="form-control" placeholder="Enter content" id="content" name="content" value="임시내용">
		</div>
		<div class="form-group">
			<label for="author">author:</label> <input type="text" class="form-control" placeholder="Enter author" id="author" name="author" value="야스오">
		</div>
		<div class="text-right">
			<button type="submit" class="btn btn-primary">작성</button>
		</div>
	</form>
</div>
<!-- end of col-sm-8 -->
</div>
</div>
<!-- end of context.jsp(xxx.jsp) -->

</div>

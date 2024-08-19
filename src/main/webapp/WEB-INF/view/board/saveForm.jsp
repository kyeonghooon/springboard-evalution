<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<div class="container p-5">
	<div class="card">
		<div class="card-header">
			<b>익명 글쓰기 화면입니다</b>
		</div>
		<div class="card-body">
			<form action="/board/save" method="post">
				<div class="mb-3">
					<label for="author">author:</label> <input type="text" class="form-control" placeholder="Enter author" id="author" name="author" value="야스오">
				</div>
				<div class="mb-3">
					<label for="title">title:</label> <input type="text" class="form-control" placeholder="Enter title" id="title" name="title" value="임시제목">
				</div>
				<div class="mb-3">
					<textarea class="form-control" rows="5" name="content"></textarea>
				</div>
				<button type="submit" class="btn btn-primary form-control">글쓰기완료</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
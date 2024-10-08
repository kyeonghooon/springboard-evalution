<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<div class="container p-5">
	<c:choose>
		<c:when test="${boardList != null}">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>내용</th>
						<th>작성자</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${boardList}">
						<tr>
							<td>${board.id}</td>
							<td>${board.title}</td>
							<td>${board.content}</td>
							<td>${board.author}</td>
							<td>
								<div class="d-flex">
									<form action="/board/${board.id}/delete" method="post">
										<button type="submit" class="btn btn-danger">삭제</button>
									</form>
									<form action="/board/${board.id}/updateForm" method="get">
										<button type="submit" class="btn btn-warning">수정</button>
									</form>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<div class="d-flex justify-content-center">
				<ul class="pagination">
					<li class="page-item ${currentPage == 0 ? 'disabled' : ''}"><a class="page-link" href="?&page=0">First</a></li>
					<li class="page-item ${currentPage == 0 ? 'disabled' : ''}"><a class="page-link" href="?&page=${currentPage - 1}">Previous</a></li>
					<c:forEach begin="${startPage}" end="${endPage}" var="page">
						<li class="page-item ${page == currentPage ? 'active' : ''}"><a class="page-link" href="?&page=${page}">${page}</a></li>
					</c:forEach>
					<li class="page-item ${currentPage == totalPage ? 'disabled' : ''}"><a class="page-link" href="?&page=${currentPage + 1}">Next</a></li>
					<li class="page-item ${currentPage == totalPage ? 'disabled' : ''}"><a class="page-link" href="?&page=${totalPage}">End</a></li>
				</ul>
			</div>
		</c:when>
		<c:otherwise>
			<div class="jumbotron display-4">
				<h5>아직 작성된 글이 없습니다.</h5>
			</div>
		</c:otherwise>
	</c:choose>

</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- header.jsp -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<!-- start of context.jsp(xxx.jsp) -->
<div class="col-sm-8">
	<h2>글목록</h2>

	<c:choose>
		<c:when test="${boardList != null}">
			<%-- 계좌 존재 : html 주석을 사용하면 오류 발생 (jstl 태그 안에서) --%>
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
							<td class="d-flex">
								<form action="/board/${board.id}/delete" method="post">
									<button type="submit" class="btn btn-danger">삭제</button>
								</form>
								<form action="/board/${board.id}/update" method="post">
									<button type="submit" class="btn btn-warning">수정</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<div class="jumbotron display-4">
				<h5>아직 작성된 글이 없습니다.</h5>
			</div>
		</c:otherwise>
	</c:choose>

</div>
<!-- end of col-sm-8 -->
</div>
</div>
<!-- end of context.jsp(xxx.jsp) -->

</div>

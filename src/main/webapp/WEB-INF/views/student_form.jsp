<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@include file="./base.jsp"%>

</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">

				<h1 class="text-center mb-3">Student Debate Event</h1>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">StudID</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Course</th>
							<th scope="col">Country</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${students }" var="i">
							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/Student/delete">
								<c:param name="id" value="${i.id}" />
							</c:url>
							<c:url var="updateLink" value="/Student/updateForm">
								<c:param name="id" value="${i.id}" />
							</c:url>
							<tr>
								<th scope="row">${i.id}</th>
								<td>${i.firstName }</td>
								<td>${i.lastName }</td>
								<td>${i.course }</td>
								<td>${i.country}</td>

								<td><a href="${deleteLink}"><i
										class="fa-solid fa-trash-can text-danger"></i></a> <a
									href="${updateLink}"><i class="fas fa-pen-nib text-primary"></i></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div class="container text-center">
					<a href="registeration_form" class="btn btn-outline-success">Add
						Student</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
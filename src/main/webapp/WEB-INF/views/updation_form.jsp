<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
</head>

<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Fill the Student Details</h1>
				<form action="handle-studentUpdation/${student.id}" method="post">
					<input type="hidden"  value="${student.id}" name="id" />
					<div class="form-group">
						<label for="f_name">Student First Name</label> <input type="text"
							class="form-control" id="firstName" aria-describedby="emailhelp"
							name="firstName" value="${student.firstName}"
							placeholder="Enter the student first name here">
					</div>
					<div class="form-group">
						<label for="l_name">Student Last Name</label><input type="text"
							class="form-control" id="lastName" name="lastName"
							value="${student.lastName}"
							placeholder="Enter the student last name here">
					</div>
					<div class="form-group">
						<label for="email">Student Course</label><input type="text"
							class="form-control" id="course" name="course"
							value="${student.course}" placeholder="Enter student course here">
					</div>
					<div class="form-group">
						<label for="email">Student Country</label><input type="text"
							class="form-control" id=country name="country"
							value="${student.country}"
							placeholder="Enter the student country here">
					</div>
					<div class="container text-center">
						<a href="view-students" class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-primary">Update
							</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<h1></h1>
</body>
</html>
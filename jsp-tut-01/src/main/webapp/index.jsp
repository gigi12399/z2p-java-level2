<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bootstrap</title>
<!--  Bootstrap  -->
<link rel="stylesheet"
	href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" />
<script type="text/javascript"
	src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>

<!--  jQuery -->
<script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>

<!-- Font awesome -->
<link rel="stylesheet"
	href="webjars/font-awesome/6.1.1/css/fontawesome.min.css" />
</head>
<body>
	<div class="container">
		<h3 class="mt-3">Register Form</h3>
		<hr />
		<div class="row">
			<form action="register" method="post" class="form row">
				<div class="col-6">
					<div class="mb-3">
						<label for="name" class="form-label">User Name</label> <input
							id="name" type="text" class="form-control" placeholder="username"
							name="username" />
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Email</label> <input name="email"
							type="email" class="form-control" placeholder="Example@gmail.com"
							required />
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Age</label> <input name="age"
							type="number" class="form-control" placeholder="age" required />
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Birthday</label> <input
							name="dob" type="date" class="form-control"
							placeholder="choose birthday" />
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Region</label> <select
							name="region" id="" class="form-select">
							<option value="mandalay">Mandalay</option>
							<option value="yangon">Yangon</option>
							<option value="sagaing">Sagaing</option>
						</select>
					</div>
					<div class="row mb-3">
						<div class="col-2">
							<span>Gender</span>
						</div>
						<div class="col-2">
							<div class="form-check">
								<input value="male" name="gender" id="male" type="radio"
									class="form-check-input" checked="checked" /> <label
									for="male" class="form-check-label">Male</label>
							</div>
						</div>
						<div class="col">
							<div class="form-check">
								<input value="female" name="gender" id="female" type="radio"
									class="form-check-input" /> <label for="female"
									class="form-check-label">Female</label>
							</div>
						</div>
					</div>

				</div>
				<div class="col-6">
					<div class="mb-3">
						<label for="" class="form-label">Address</label>
						<textarea name="address" id="" cols="30" rows="10"
							placeholder="Enter address detail" class="form-control"></textarea>
					</div>
					<div class="mb-3 form-check">
						<input name="old_student" type="checkbox" class="form-check-input"
							id="chk" /> <label for="chk" class="form-check label">Old
							Student</label>
					</div>
					<div class="row">
						<div class="col">
							<button class="btn btn-danger w-100" type="reset">Reset</button>
						</div>
						<div class="col">
							<button class="btn btn-success w-100" type="submit" ><i class="fa-solid fa-plus"></i>Register</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
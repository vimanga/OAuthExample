<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OAuth</title>

	<style>
		body {font-family: Arial, Helvetica, sans-serif;}

		div.ex1 {
			width:500px;
			margin: auto;
			border: 3px solid steelblue;
		}

		input[type=text] {
			width: 100%;
			padding: 12px 20px;
			margin: 8px 0;
			display: inline-block;
			border: 1px solid #ccc;
			box-sizing: border-box;
		}

		button {
			background-color: steelblue;
			color: white;
			padding: 14px 20px;
			margin: 8px 0;
			border: none;
			cursor: pointer;
			width: 100%;
		}

		button:hover {
			opacity: 0.8;
		}

		.imgcontainer {
			text-align: center;
			margin: 24px 0 12px 0;
		}

		img.avatar {
			width: 40%;
			border-radius: 50%;
		}

		.container {
			padding: 16px;
		}

	</style>
</head>
<body>

	<div class="ex1">

		<h3 align="center">You have successfully logged in</h3>

		<div class="imgcontainer">
			<img src=${picture} alt="Avatar" class="avatar">
		</div>

		<div class="container">
			<label><b>First Name</b></label>
			<input type="text" placeholder="Enter Username" name="name" value=${name} required>

			<label><b>Last Name</b></label>
			<input type="text" placeholder="Enter Username" name="lname" value=${family_name} required>

			<label><b>Email</b></label>
			<input type="text" placeholder="Enter Password" name="psw" value=${email} required>

			<button type="submit">Save</button>
		</div>
	</div>

</body>
</html>
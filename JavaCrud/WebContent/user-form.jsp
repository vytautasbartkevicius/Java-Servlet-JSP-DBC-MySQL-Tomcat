<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> User Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>
				<form>
					<c:if test="${user != null}">
						<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
					</c:if>
	
					<fieldset class="form-group">
						<label>Vardas</label> <input type="text"
							value="<c:out value='${user.name}' />" class="form-control"
							name="name" required="required">
					</fieldset>
	
					<fieldset class="form-group">
						<label>Pavarde</label> <input type="text"
							value="<c:out value='${user.lastname}' />" class="form-control"
							name="lastname" required="required">
					</fieldset>
	
					<fieldset class="form-group">
						<label>Amzius</label> <input type="text"
							value="<c:out value='${user.age}' />" class="form-control"
							name="age" required="required">
					</fieldset>
					
					
					<fieldset class="form-group">
						<label>Atlyginimas</label> <input type="text"
							value="<c:out value='${user.salary}' />" class="form-control"
							name="salary" required="required">
					</fieldset>
					
					
					<fieldset class="form-group">
						<label>Objektas</label> <input type="text"
							value="<c:out value='${user.objektas}' />" class="form-control"
							name="objektas" required="required">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Pareigos</label> <input type="text"
							value="<c:out value='${user.pareigos}' />" class="form-control"
							name="pareigos" required="required">
					</fieldset>
					
					
	
					<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
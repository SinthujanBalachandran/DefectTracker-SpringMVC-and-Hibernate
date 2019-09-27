<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project Management </title>
</head>
<body>
	<div align="center">
		<h1>Project list</h1>
		
		<table border="1">

			<th> project_name</th>
			<th>project_description</th>
			
			<th>Action</th>

			<c:forEach var="project" items="${listProject}">
				<tr>

					<td>${project. project_name}</td>
					<td>${project.project_description}</td>
					<td><a href="editProject?id=${project.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteProject?id=${project.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Project Register <a href="newProject">here</a>
		</h4>
	</div>
</body>
</html>
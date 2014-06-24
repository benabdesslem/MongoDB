<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h2>List of companies</h2>

		<form action="company/save" method="post">
			<input type="hidden" name="id">
			<label for="name">name</label>
			<input type="text" id="name" name="name"/>
			<label for="name">location</label>
			<input type="text" id="location" name="location"/>
			
			<input type="submit" value="Submit"/>
		</form>

	<table border="1">
	<tr>
	<td>name</td> <td>location</td> <td colspan="2">Action</td>
	</tr>
		<c:forEach var="company" items="${companylist}">
			<tr>
				<td>${company.name}</td><td>${company.location}</td><td><input type="button" value="delete" onclick="window.location='company/delete?id=${company.id}'"/></td><td><input type="button" value="List of Employe" onclick="window.location='listemp?id=${company.id}&idd=${company.id}'" /></td>
			</tr>
		</c:forEach>
	</table>	
</body>
</html>
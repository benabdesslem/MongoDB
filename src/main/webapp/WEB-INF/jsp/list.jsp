<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>


	<table border="1">
	<tr>
	<td>cin</td> <td>nom</td><td>prenom</td> 
	</tr>
		<c:forEach var="emp" items="${listemps}">
			<tr>
		<td>${emp.cin}</td><td>${emp.nom}</td><td>${emp.prenom}</td>
			</tr>
		</c:forEach>
	</table>
</body></html>
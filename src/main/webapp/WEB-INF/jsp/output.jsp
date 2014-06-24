<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
	<h2>List Of employees</h2>

		<form action="person/save" method="post">
			<input type="hidden" name="id">
			<label for="name">cin</label>
			<input type="text" id="cin" name="cin"/>
			<label for="name">nom</label>
			<input type="text" id="nom" name="nom"/>
			<label for="name">prenom</label>
			<input type="text" id="prenom" name="prenom"/>

<label for="name" >Company:</label>

<form:select path="Companies" items="${Companies}"  name="vvv" />

<!--   <form:select path="Companies"  id="companyy">
    <form:option value="">Select company: </form:option>
        <c:forEach items="${Companies}" var="company">
          <form:option value="${company}" name="companyy" id="companyy">${company}</form:option>
        </c:forEach>

     </form:select>
     
     -->
<!--
<select >
<c:forEach var="company" items="${Companies}"> 
<option value="${company}">${company.id}</option>
</c:forEach>
</select>
-->
			<input type="submit" value="Submit"/>
		</form>
	

	<table border="1">
	<tr>
	<td>cin</td> <td>nom</td><td>prenom</td> <td>Company</td> <td>Action</td> 
	</tr>
		<c:forEach var="person" items="${personList}">
			<tr>
		<td>${person.cin}</td><td>${person.nom}</td><td>${person.prenom}</td><td>${person.company}</td><td><input type="button" value="delete" onclick="window.location='person/delete?id=${person.id}'"/></td>
			</tr>
		</c:forEach>
	</table>	
</body>
</html>
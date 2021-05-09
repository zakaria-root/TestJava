
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>

<jsp:declaration>
GestionEtudiant ges =new GestionEtudiant();
Etudiant u = new Etudiant(); 
</jsp:declaration>>


voisi les informations de l'itudiant de Id: <%=u.getId() %> 

<table id="customers" >
		<tr>
		<th>Id</th>
		<th>Nom</th>
		<th>Prenom</th>
		<th>Age</th>
		</tr>
		<tr>
		<td><%= u.getId()%></td>
		<td><%= u.getFname()%></td>
		<td><%= u.getLname()%></td>
	    <td><%= u.getAge()%></td>
		</tr>
	</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<body>

<div>
  <h4>Entrer les informations de l'etudiant :</h4>
	<form action="create" method ="Post">
	  <label for="nom"> Nom :</label><br>
	  <input type="text" id="nom" name="fname"><br>
	  <label for="prenom"> Prenom :</label><br>
	  <input type="text" id="prenom" name="lname"><br>
	  <label for="Age"> Age :</label><br>
	  <input type="text" id="Age" name="age"><br>
	  <input type="submit" value="save">
	</form> 
</div>

</body>
</html>

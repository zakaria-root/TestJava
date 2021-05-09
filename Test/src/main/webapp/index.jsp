<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
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
  <h4>Entrer le id de l'etudiant qui vous voulez afficher :</h4>
	<form action="sorte" method ="Post">
	  <label for="id"> ID :</label><br>
	  <input type="text" id="id" name="id"><br>
	  <input type="submit" value="send">
	  <a href="ajouterEtudiant.jsp" class="button">Ajouter un nouveau etudiant</a>
	  <a href="list" class="button">afficher la list de etudiants</a>

	</form> 
</div>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.awt.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="co.simplon.poleEmploi.decouverte.jsp.Utilisateur"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="chaineMessage" scope="request" class="java.lang.String" />
<jsp:useBean id="listeNoms" scope="session" class="java.util.ArrayList" />

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page JSP</title>
</head>

<body>

	<br>Nous allons calculer côté serveur cette opération : 1 + 1
	<br> Nous trouvons le résultat suivant :
	<%=1 + 1%>
	<br>

	<h1>Passage par setAttribute / getAttribute</h1>
	<%=request.getAttribute("message")%><br>

	<h1>Jsp Bean</h1>

	Nous avons reçu un message :
	<%=chaineMessage%>
	<br> De taille :
	<%=chaineMessage.length()%>

	<h1>Expression langage</h1>
	<a href="http://adiguba.developpez.com/tutoriels/j2ee/jsp/el/">Voir
		la doc sur les expressions langage sur developpez.com</a>

	<br>On peut récupérer avec les expressions langage les objets
	passés par setAttribute dans la servlet, sans même utiliser de
	getAttribute :

	<h2>${message}</h2>
	Objet chaine passé sous le nom "nomObjetChaine": ${nomObjetChaine}
	<br> Utilisateur récupéré : ${utilisateur}
	<h2>Objets implicites :</h2>
	<br>Content type de la réponse: ${ pageContext.response.contentType }
	<br>Attribut "name" du scope page : ${ pageScope["name"] }
	<br>Valeur du paramètre "page" : ${ param["page"] }
	<br>Header "user-agent" envoyé par le navigateur : ${ header["user-agent"] }

	<br> Pour que les annotations Expression Langage ne perturbent pas
	Eclipse, intégrer "JSP" dans les
	<a
		href="http://mvnrepository.com/artifact/javax.servlet.jsp/jsp-api/2.2.1-b03">dépendances
		Maven</a>

	<h2>Liste des utilisateurs</h2>

	<%
		// out.println("Il y 	a " + listeNoms.size() + " dans la liste");
		for (Utilisateur unUtilisateur : (ArrayList<Utilisateur>)listeNoms){
			// out.println(unUtilisateur);
			request.setAttribute("unUtilisateur",unUtilisateur);
	%>
	
	<br> ${unUtilisateur.prenom} <b>${unUtilisateur.nom} </b> 
	
	<%
		}
	%>

</body>
</html>
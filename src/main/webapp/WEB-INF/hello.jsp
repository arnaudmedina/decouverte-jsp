<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="chaineMessage" scope="request" class="java.lang.String" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bonjour monde !</title>
</head>
<body>
<%= request.getAttribute("message")%><br>
Nous allons calculer côté serveur cette opération : 1 + 1 
Nous trouvons le résultat suivant : <%=1+1%>

<h1>Jsp Bean</h1>

Nous avons reçu un message <%= chaineMessage %> <br>
De taille : <%= chaineMessage.length() %>

</body>
</html>
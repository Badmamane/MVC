<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Badam
  Date: 02/01/2016
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lister utilisateurs par évènement</title>
</head>
<body>
<h1> Consultation de la liste de tous les utilisateurs par évènement</h1>
<table>
    <tr>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Adresse Mail</th>
        <th>Date Inscription</th>
    </tr>
    <s:iterator value="%{utilisateursListParEvt}" var="utilisateur">
        <tr>
            <td><s:property value="nom"/></td>
            <td><s:property value="prenom"/></td>
            <td><s:property value="adressemail"/></td>
            <td><s:property value="dateInscription"/></td>
            <td>
        </tr>
    </s:iterator>
</table>
<a href="login.jsp">Vous autentifier</a>

</body>
</html>

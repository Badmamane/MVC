<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Badam
  Date: 02/01/2016
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userNonAuth</title>
</head>
<body>
<h1>Consulutation des Evènements passés et à venir</h1>
<table>
    <tr>
        <th>Nom</th>
        <th>Sujet</th>
        <th>Salle</th>
        <th>Animateur</th>
    </tr>
    <s:iterator value="%{evenementList}" var="evenement">
        <tr>
            <td><s:property value="nomevent"/></td>
            <td><s:property value="sujet"/></td>
            <td><s:property value="salle"/></td>
            <td><s:property value="idAnimateur"/></td>
            <td><s:url id="visualiserPersonnesParEvt" action="visualisPersonnesParEvt">
                <s:param name="codeevent" value="%{codeevent}"></s:param>
                <s:a href="%{visualiserPersonnesParEvt}">Voir les personnes Inscrites et leur date d'inscription</s:a>
            </s:url></td>
        </tr>
    </s:iterator>
</table>
<a href="login.jsp">Vous authentifier</a>
</body>
</html>

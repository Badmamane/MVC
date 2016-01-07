<%--
  Created by IntelliJ IDEA.
  User: Badam
  Date: 06/01/2016
  Time: 00:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Evènements</h2>
<table>
    <tr>
        <th>Nom</th>
        <th>Sujet</th>
        <th>Salle</th>
    </tr>
    <s:iterator value="%{evenementList}" var="evenement">
    <tr>
        <td><s:property value="nomevent"/></td>
        <td><s:property value="sujet"/></td>
        <td><s:property value="salle"/></td>
        <td>
            <s:url id="desinscrireURL" action="desinscrire">
                <s:param name="evt" value="%{codeevent}"></s:param>
                <s:a href="%{desinscrireURL}">Se desinscrire</s:a>
            </s:url>
        </td>
        <td><s:url id="sinscrireURL" action="sinscrire">
            <s:param name="evt" value="%{codeevent}"></s:param>
            <s:a href="%{sinscrireURL}">S'inscrire à l'évènement</s:a>
        </s:url></td>
        <td><s:url id="visualiseEvt" action="visualiseevt">
            <s:param name="evt" value="%{codeevent}"></s:param>
            <s:a href="%{visualiseEvt}">Visualiser</s:a>
        </s:url></td>
    </tr>
    </s:iterator>
    </table>
<a href="CreationEvt.jsp">Créer un evenement</a>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Badam
  Date: 06/01/2016
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Créer evt</title>
</head>
<body>
<h1 style="align:center">Créer un nouvel évènement</h1>
<s:form action="CreerEvtAction">
    <h2>Sair votre évènement</h2>
    <s:textfield name="evenement.nomevent" label="Login" />
    <s:textfield name="evenement.sujet" label="Login" />
    <s:textfield name="evenement.salle" label="Login" />
    <s:textfield name="evenement.note" label="Login" />
    <s:password name="evenement.idAnimateur" label="Login"/>
    <s:submit label="Submit" />
    </s:form>
    </br>
</body>
</html>

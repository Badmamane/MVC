
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
</head>
<body>

<h1 style="align:center">Bienvenue sur L'appli</h1>
<s:form action="LoginAction">
    <h2>Bienvenue</h2>
       <h2>Vous autentifier</h2>
    <s:textfield name="utilisateur.nom" label="Login" />
    <s:textfield name="evenement.codeEvent" label="Login" />
    <s:password name="utilisateur.motdePasse" label="Password"/>
    <s:submit label="Submit" />
</s:form>
    <s:form action="InscriptionAction">
</br>
    Vous n'êtes pas encore utilisateur ? Vous inscrire :
</br>
    <s:textfield name="utilisateur.nom" label="Login" />
    <s:textfield name="utilisateur.prenom" label="Login" />
    <s:password name="utilisateur.motdePasse" label="Password"/>
    <s:textfield name="utilisateur.adresseMail" label="" />
    <s:submit label="Submit" />
</s:form>
    <a href="nonAuth.jsp"> Merci je souhaite continuer sans authentification </a>
</body>
</html>



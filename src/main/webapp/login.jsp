
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <link rel="stylesheet" href="/BankonetStruts2/css/main.css"
          type="text/css" />
</head>
<body>

<h1 style="align:center;">Bienvenue sur L'appli</h1>
<s:fielderror/>
<s:if test="hasActionErrors()">

    <div class="errors">
        <s:actionerror/>
    </div>
</s:if>
<s:form action="Login">
    <s:textfield name="utilisateur.nom" label="Login" />
    <s:textfield name="evenement.codeEvent" label="Login" />
    <s:password name="utilisateur.motdePasse" label="Password"/>
    <s:submit label="Submit" />
    </s:form>
</br>
    Vous n'êtes pas encore inscrit à un évènement ? Vous inscrire :
</br>
<s:form action="Inscription">
    <s:textfield name="utilisateur.nom" label="Login" />
    <s:textfield name="utilisateur.prenom" label="Login" />
    <s:password name="utilisateur.motdePasse" label="Password"/>
    <s:textfield name="utilisateur.adresseMail" label="" />
    <s:submit label="Submit" />
</s:form>
</body>
</html>



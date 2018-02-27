<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="Add-ons/vendor/bootstrap/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<link href="Add-ons/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
<link href="Add-ons/css/creative.min.css" rel="stylesheet">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <s:a class="navbar-brand" href="home">Karate Do Web</s:a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <s:if test="#session.userType==1"><li><s:a href="contribution">Mis Aportaciones</s:a></li></s:if>
                <s:if test="#session.userType==2"><li><s:a href="userPostulant">Eventos elegidos</s:a></li></s:if>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><s:a href="self">${sessionScope.username}</s:a></li>
                <li><s:a href="logout">Cerrar sesión</s:a></li>
            </ul>
            <div class="navbar-header">
                <s:form theme="simple" action="searchVideo">
                    <ul class="nav navbar-nav">
                        <li><s:textfield class="form-control" placeholder="Buscar"/></li>
                        <li><s:submit type="submit" class="btn btn-default" value="Buscar"/></li>
                    </ul>
                </s:form>
            </div>
        </div>
    </div>
</nav>
<div class="container">
    <ul class="nav nav-pills">
        <li role="presentation" class="active"><a href="home">Últimos</a></li>
        <s:if test="#session.userType==1"><li role="presentation"><s:a href="redirectCreatePost">Enviar Video</s:a></li></s:if>
        <s:if test="#session.userType==1"><li role="presentation"><s:a href="redirectCreateEvent">Crea un evento</s:a></li></s:if>
        <s:if test="#session.userType==2"><li role="presentation"><s:a href="listEvents">Eventos disponibles</s:a></li></s:if>
    </ul>
</div>
<center>
    <div class="container">
        <div class="row">
            <br><br>
            <div class="col-md-4">
                <s:url action="profile" var="profileLink"><s:param name="username"><s:property value="model.user.username"/></s:param></s:url>
                <p class="navbar-text">Publicado por <a href="${profileLink}"><s:property value="model.user.username"/></a> en <s:property value="model.date"/></p>
                <s:url action="postDetails" var="showPostDetails"><s:param name="postId"><s:property value="id"/></s:param></s:url>
                <a href="${showPostDetails}"><h4><s:property value="title"/></h4></a>
                <p>
                    <s:property value="model.description"/>
                </p>
            </div>
            <div class="col-md-8">
                <div class="vid">
                    <iframe width="560" height="315" src="<s:property value='model.url'/>" allowfullscreen=""></iframe>
                </div>
            </div>
        </div>
    </div>
</center>
<center>
    <br><br>
    <div class="container">
        <div class="col-md-8">
            <s:form  theme="simple" cssClass="well" action="createComment">
                <s:hidden name="postId" value="%{model.id}"/>
                <div class="form-group">
                    <s:textarea placeholder="Deja un comentario publico" cssClass="form-control" rows="2"/>
                </div>
                <div class="form-group">
                    <s:submit value="Comentar" cssClass="btn btn-default"/>
                    <s:reset value="Cancelar" cssClass="btn btn-default"/>
                </div>
            </s:form>
        </div>
    </div>
</center>
<s:iterator value="comments">
    <div class="container">
        <table>
            <tr>
                <td><s:url action="profile" var="profileLink"><s:param name="username"><s:property value="model.user.username"/></s:param></s:url>
                    <p class="navbar-text">Comentario hecho por <a href="${profileLink}"><s:property value="model.user.username"/></a> en <s:property value="model.date"/></p></td>
            </tr>
            <tr>
                <td><s:property value="description"/></td>
                <hr>
            </tr>
        </table>
    </div>
</s:iterator>

<script src="Add-ons/vendor/jquery/jquery.min.js"></script>
<script src="Add-ons/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="Add-ons/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="Add-ons/vendor/scrollreveal/scrollreveal.min.js"></script>
<script src="Add-ons/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

<!-- Custom scripts for this template -->
<script src="Add-ons/js/creative.min.js"></script>
</body>
</html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Compartir video</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="Add-ons/vendor/bootstrap/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link href="Add-ons/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
    <link href="Add-ons/css/creative.min.css" rel="stylesheet">
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
                        <li><s:textfield name="model.title"  class="form-control" placeholder="Buscar"/></li>
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
<div class="container">
    <h2>Envia un video</h2>
    <div>Haznos llegar todos aquellos vídeos que crees que pueden ser interesantes para publicar. </div>

    <div class="col-md-8">
        <s:form theme="bootstrap" role="form" action="createPost">
            <div class="form-group">
                <s:textfield id="title" name="model.title" placeholder="Ingresa el titulo de tu publicacion" class="form-control"/>
            </div>
            <div  class="form-group">
                <s:textfield id="url" name="model.url" placeholder="Ingresa la Url" cssClass="form-control"/>
            </div>
            <div>
                <s:textarea id="exampleFormControlTextarea1" name="model.description" placeholder="Describe tu video" cssClass="form-control" rows="3"/>
            <div  class="form-group">
            <s:submit value="Enviar" cssClass="btn btn-outline-primary"/>
        </s:form>
    </div>
</div>
</body>
</html>

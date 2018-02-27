<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="Add-ons/vendor/bootstrap/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link href="Add-ons/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
    <link href="Add-ons/css/creative.min.css" rel="stylesheet">
    <title>Crear evento</title>
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
<h2>Publica un Evento</h2>
<h3>Publica un evento para poder capturar la atencion de los mejores alumnos</h3>
<div class="col-md-8">
<s:form theme="bootstrap" role="form" action="createEvent">
    <div class="form-group">
    <s:textfield id="title" name="model.title" cssClass="form-control" placeholder="Ingresa un titulo" requerid="true" />
    </div>
    <div class="form-group">
    <s:textfield id="ubication" name="model.ubication" cssClass="form-control" placeholder="¿Donde se realizara tu evento?" requerid="true" />
    </div>
    <div class="form-group">
    <s:textfield id="url" name="model.pictureUrl" cssClass="form-control" placeholder="Ingresa la url de tu imagen" requerid="true" />
    </div>
    <div class="form-group">
    <s:textfield id="evntime" name="model.date" cssClass="form-control" placeholder="Fecha incio" requerid="true" />
    </div>
    <div class="form-group">
    <s:textfield id="evntimelimit" name="model.dateLimit" cssClass="form-control" placeholder="Fecha fin" requerid="true" />
    </div>
    <div>
    <s:textarea id="description" name="model.description" cssClass="form-control" placeholder="Describe lo que tendra tu publicacion" requerid="true" rows="3"/>
    </div class="form-group">
    <div class="form-group">
    <s:textfield id="tags" name="model.tags" cssClass="form-control" placeholder="Etiquetas" requerid="true"/>
    </div>
    <div class="form-group">
    <s:textfield id="websites" name="model.websites" cssClass="form-control" placeholder="Ingresa algun sitio web asociado a tu evento" requerid="true"/>
    </div>
    <s:submit value="Publicar" cssClass="btn btn-outline-primary"/>
</s:form>
</div>
</div>
</body>
</html>
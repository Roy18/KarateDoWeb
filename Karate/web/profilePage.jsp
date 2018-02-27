<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<link href="Add-ons/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
<link href="Add-ons/css/creative.min.css" rel="stylesheet">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Perfil</title>
    <sb:head/>
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
    <div class="row">
        <div class="col-md-4">
            <h4>Edita tu perfil</h4>
            <img data-src="holder.js/140x140" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIwAAACMCAYAAACuwEE+AAADnklEQVR4Xu3YUU4bARAD0HI3js2ZuEIrkCKlNGRjCazFff1sJpmM/bSUPr2+vv7+5Y8EHkzgCZgHkzL2ngAwIEQJABPFZRgYBqIEgIniMgwMA1ECwERxGQaGgSgBYKK4DAPDQJQAMFFchoFhIEoAmCguw8AwECUATBSXYWAYiBIAJorLMDAMRAkAE8VlGBgGogSAieIyDAwDUQLARHEZBoaBKAFgorgMA8NAlAAwUVyGgWEgSgCYKC7DwDAQJQBMFJdhYBiIEgAmisswMAxECQATxWUYGAaiBICJ4jIMDANRAsBEcRkGhoEoAWCiuAwDw0CUADBRXIaBYSBKAJgoLsPAMBAlAEwUl2FgGIgSACaKyzAwDEQJABPFZRgYBqIEgIniMgwMA1ECwERxGQaGgSgBYKK4DAPDQJQAMFFchoFhIEoAmCguw8AwECUATBSXYWAYiBKYAPPy8vJ+9PPz8z/H33rt8neX4Vvvu5die1/U6DcP/3gw1+V/LP7Wax/Lvlf+rezb+765//jjfzSYoydFCuYI01fvi9s6wRt+PJi3p8pnP3ZuvXYPxSNgvnLfCfqPv8KPBnO59qvAvH3e0VPkeub6R+Db+1KgcVsneMMkmEt5t8o9eop8BuK6q1ufccFz9Pnpv5lOYOSvrzAL5lbQyRPg3m9Qn6H4uPORfWcDcfR9JsEcPQ2ufwW/Lv/o6XDvR+Bnrz36mUdFneX1/w7MvX+nPFqu/4c5C1/f4/QJTDxhTp/y0BcEZqjMxinANFIe2gHMUJmNU4BppDy0A5ihMhunANNIeWgHMENlNk4BppHy0A5ghspsnAJMI+WhHcAMldk4BZhGykM7gBkqs3EKMI2Uh3YAM1Rm4xRgGikP7QBmqMzGKcA0Uh7aAcxQmY1TgGmkPLQDmKEyG6cA00h5aAcwQ2U2TgGmkfLQDmCGymycAkwj5aEdwAyV2TgFmEbKQzuAGSqzcQowjZSHdgAzVGbjFGAaKQ/tAGaozMYpwDRSHtoBzFCZjVOAaaQ8tAOYoTIbpwDTSHloBzBDZTZOAaaR8tAOYIbKbJwCTCPloR3ADJXZOAWYRspDO4AZKrNxCjCNlId2ADNUZuMUYBopD+0AZqjMxinANFIe2gHMUJmNU4BppDy0A5ihMhunANNIeWgHMENlNk4BppHy0A5ghspsnAJMI+WhHcAMldk4BZhGykM7gBkqs3EKMI2Uh3YAM1Rm4xRgGikP7fgDC/oXpnZMYeUAAAAASUVORK5CYII=" class="img-thumbnail" alt="140x140" style="width: 200px; height: 200px;">
            <s:if test="model.user.username!=#session.username">
                <h3>Califica:</h3>
                <s:form action="point">
                    <s:hidden name="target" value="%{model.user.id}"/>
                    <s:radio name="quantity" list="#{'1':'1','2':'2','2':'2','3':'3','4':'4','5':'5'}"/>
                    <s:submit value="Enviar Calificacion"/>
                </s:form>
                <h3>Mi calificacion: <s:property value="value"/> </h3>
            </s:if>
                <h3>Calificacion promedio:</h3>
                <div id="rateYo2"></div>
                <h3>de <s:property value="model.voteQuantity"/> <s:if test="model.voteQuantity==1">voto</s:if><s:else>votos</s:else>.</h3>
        </div>
        <div class="col-md-8">
                <s:form theme="bootstrap" class="well form-vertical" method="POST" enctype="multipart/form-data">
                    <div class="form-group">
                        <s:if test="model.userType.id==1">Artista</s:if><s:if test="model.userType.id==2">Empresario</s:if> <s:property value="model.username"/>
                    </div>
                    <s:textfield name="model.user.name" placeholder="Nombres" label="Nombres" disabled="true"/>
                    <s:textfield name="model.user.lastName" placeholder="Apellidos" label="Apellidos" disabled="true"/>
                    <s:textfield name="model.user.email" placeholder="Email" label="E-mail" disabled="true"/>
                    <s:textfield name="model.user.birthDate" placeholder="Fecha de Nacimiento" label="Fecha de Nacimiento" disabled="true"/>
                    <s:select name="model.user.genre"
                              label="Selecciona tu genero"
                              headerKey="0"
                              headerValue="--- Select ---"
                              list="#{'M':'Masculino', 'F':'Femenino'}"
                              disabled="true"/>
                    <s:textfield name="model.user.phone" placeholder="Telefono" label="Telefono" disabled="true"/>
                </s:form>
        </div>
    </div>
</div>
<script>
    $(function () {
        $("#rateYo2").rateYo({
            readOnly: true
        });
    });
    $(document).ready(function(){
        $("#rateYo2").rateYo("option", "rating", ${model.averagePoints});
    });
</script>
<script src="jquery.js"></script>
<script src="jquery.rateyo.js"></script>
</body>
</html>
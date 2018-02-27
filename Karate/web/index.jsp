
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">


    <title>Karate Do Web</title>
    <!-- Bootstrap core CSS -->
    <link href="Add-ons/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template -->
    <link href="Add-ons/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <!-- Plugin CSS -->
    <link href="Add-ons/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="Add-ons/css/creative.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
        <a class="navbar-brand js-scroll-trigger" href="index.jsp">
            <img src="Add-ons/img/karate-do-web.jpg" alt="Karate do Web" >
        </a>
        <div class="navbar-right">
            <s:form theme="simple" action="login">
                <s:textfield id="username" name="model.username" placeholder="Nombre de usuario"/>
                <s:password id="password" name="model.password" placeholder="Contraseña"/>
                <s:submit value="Ingresar" cssClass="btn btn-outline-secondary"/>
                <a href="userRegister.jsp"><s:label cssClass="btn btn-outline-secondary" value="Registrarse"/></a>
                <a href="email.jsp">¿Olvido su contraseña?</a>
            </s:form>
        </div>
    </nav>

<header class="masthead text-center text-white d-flex">
    <div class="container my-auto">
        <div class="row">
            <div class="col-lg-10 mx-auto">
                <h1 class="text-uppercase">
                    <strong>Te damos la bienvenida</strong>
                </h1>
                <hr>
            </div>
            <div class="col-lg-10 mx-auto">
                <p class="text-faded mb-5">
                    Bienvenido, disfruta la nueva experiencia de nuestra plataforma,
                    la cual te brinda diversos anuncios adaptados a tus necesidades de
                    este maravilloso deporte llamado karate
                </p>
                <a class="btn btn-primary btn-xl js-scroll-trigger" href="userRegister.jsp">Registrate Ahora</a>
            </div>
        </div>
    </div>
</header>

<section class="bg-primary" id="about">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mx-auto text-center">
                <p class="text-faded mb-4">Simple, Rápido, Ilimitado y sin costos adicionales.</p>
                <a class="btn btn-light btn-xl js-scroll-trigger" href="#contact">¿Desea mas informacion?</a>
            </div>
        </div>
    </div>
</section>

<section id="services">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading">Tambien en todos tus dispositivos</h2>
                <hr class="my-4">
                <img  src="Add-ons/img/iphone2.png" alt="">
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6 text-center">
                <div class="service-box mt-5 mx-auto">
                    <i class="fa fa-4x fa-diamond text-primary mb-3 sr-icons"></i>
                    <h3 class="mb-3"></h3>
                    <p class="text-muted mb-0">Adaptabilidad en todos tus dispositivos.</p>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 text-center">
                <div class="service-box mt-5 mx-auto">
                    <i class="fa fa-4x fa-paper-plane text-primary mb-3 sr-icons"></i>
                    <h3 class="mb-3"></h3>
                    <p class="text-muted mb-0">Promociona tus videos y eventos.</p>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 text-center">
                <div class="service-box mt-5 mx-auto">
                    <i class="fa fa-4x fa-newspaper-o text-primary mb-3 sr-icons"></i>
                    <h3 class="mb-3"></h3>
                    <p class="text-muted mb-0">Conocer más acerca del mundo del Karate.</p>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 text-center">
                <div class="service-box mt-5 mx-auto">
                    <i class="fa fa-4x fa-heart text-primary mb-3 sr-icons"></i>
                    <h3 class="mb-3"></h3>
                    <p class="text-muted mb-0">Estar al dia de con la comunidad del Karate</p>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="p-0" id="portfolio">
    <div class="container-fluid p-0">
        <div class="row no-gutters popup-gallery">
            <div class="col-lg-4 col-sm-6">
                <a class="portfolio-box" href="Add-ons/img/11.jpg">
                    <img class="img-fluid" src="Add-ons/img/11.jpg" alt="">
                    <div class="portfolio-box-caption">
                        <div class="portfolio-box-caption-content">
                            <div class="project-name">
                                Aprende participando en diversos eventos
                            </div>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-4 col-sm-6">
                <a class="portfolio-box" href="Add-ons/img/12.jpg">
                  <img class="img-fluid" src="Add-ons/img/12.jpg" alt="">
                  <div class="portfolio-box-caption">
                      <div class="portfolio-box-caption-content">
                          <div class="project-name">
                              Encuentra a las personas que se dedican a esta disciplina
                          </div>
                      </div>
                  </div>
              </a>
          </div>
          <div class="col-lg-4 col-sm-6">
              <a class="portfolio-box" href="Add-ons/img/14.jpg">
                  <img class="img-fluid" src="Add-ons/img/14.jpg" alt="">
                  <div class="portfolio-box-caption">
                      <div class="portfolio-box-caption-content">
                          <div class="project-name">
                              Tablon informativo de difusiones y acontecimientos que te pueden interesar
                          </div>
                      </div>
                  </div>
              </a>
          </div>
          <div class="col-lg-4 col-sm-6">
              <a class="portfolio-box" href="Add-ons/img/13.jpg">
                  <img class="img-fluid" src="Add-ons/img/13.jpg" alt="">
                  <div class="portfolio-box-caption">
                      <div class="portfolio-box-caption-content">
                          <div class="project-name">
                              Muestra y difunde todas tus técnicas aprendidas para que te conozcan mejor
                          </div>
                      </div>
                  </div>
              </a>
          </div>
          <div class="col-lg-4 col-sm-6">
              <a class="portfolio-box" href="Add-ons/img/16.jpg">
                  <img class="img-fluid" src="Add-ons/img/16.jpg" alt="">
                  <div class="portfolio-box-caption">
                      <div class="portfolio-box-caption-content">
                          <div class="project-name">
                              Sigue esta disciplina tan hermosa y atrévete a participar en eventos
                          </div>
                      </div>
                  </div>
              </a>
          </div>
          <div class="col-lg-4 col-sm-6">
              <a class="portfolio-box" href="Add-ons/img/15.jpg">
                  <img class="img-fluid" src="Add-ons/img/15.jpg" alt="">
                  <div class="portfolio-box-caption">
                      <div class="portfolio-box-caption-content">
                          <div class="project-name">
                              Aprende nuevas técnicas
                          </div>
                      </div>
                  </div>
              </a>
          </div>
      </div>
  </div>
</section>

<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mx-auto text-center">
                <h2 class="section-heading">Contacto</h2>
                <hr class="my-4">
                <a href="aboutUs.jsp">Acerca de KDW</a>
                <a href="privacyPolicy.jsp">Politicas de privacidad</a>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 ml-auto text-center">
                <i class="fa fa-phone fa-3x mb-3 sr-contact"></i>
                <p></p>
            </div>
            <div class="col-lg-4 mr-auto text-center">
                <i class="fa fa-envelope-o fa-3x mb-3 sr-contact"></i>
                <p>
                    <a href="mailto:your-email@your-domain.com"></a>
                </p>
            </div>
        </div>
    </div>
</section>

<!-- Bootstrap core JavaScript -->
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


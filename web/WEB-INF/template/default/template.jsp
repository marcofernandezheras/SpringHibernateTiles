<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true" defaultValue="Spring Tiles"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
    <%-- Nav bar --%>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/index.form">Inicio</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/book/list.form">Ver Libros</a></li>
                    <c:if test="${sessionScope.actualUser.valid}">
                        <li><a href="${pageContext.request.contextPath}/bill/list.form">Mis facturas</a></li>
                    </c:if>
                </ul>
                <c:choose>
                    <c:when test="${not sessionScope.actualUser.valid}">
                        <form class="navbar-form navbar-right" method="post" action="${pageContext.request.contextPath}/user/login.form">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Dni" name="dni">
                                <input type="password" class="form-control" placeholder="Password" name="password">
                            </div>
                            <button type="submit" class="btn btn-default">Login</button>
                            <a href="${pageContext.request.contextPath}/user/register.form" class="btn btn-primary">Registrarse</a>
                        </form>
                    </c:when>

                    <c:otherwise>
                        <form class="navbar-form navbar-right" method="post" action="${pageContext.request.contextPath}/user/logout.form">
                            <button type="submit" class="btn btn-default">Logout</button>
                        </form>
                    </c:otherwise>
                </c:choose>
                <form class="navbar-form navbar-right" method="get" action="${pageContext.request.contextPath}/cart/view.form">
                    <button type="submit" class="btn btn-default" >Carrito <span class="badge" id="cartCountBadge" data-container="body" data-toggle="popover" data-placement="bottom" data-content="Carrito actualizado">${sessionScope.cart.count()}</span></button>
                </form>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
    <%-- /Nav bar --%>
    <div class="container-fluid">
        <tiles:insertAttribute name="content" />
    </div>

    <footer class="footer">
        <div class="container text-center">
            <p class="text-muted">Marco A. Fernández Heras<sup>©</sup>      2015-2016</p>
        </div>
    </footer>

    <script src="https://code.jquery.com/jquery-1.12.2.min.js"
            integrity="sha256-lZFHibXzMHo3GGeehn1hudTAP3Sc0uKXBXAzHX1sjtk="
            crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <tiles:insertAttribute name="extraScripts" ignore="true" defaultValue=""/>
    </body>
</html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="defaultTemplate">

    <tiles:putAttribute name="title">Librería Spring - Tiles</tiles:putAttribute>

    <tiles:putAttribute name="content">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="jumbotron"><img src="/img/tiles.png" alt="tiles" class="img-responsive"/>
                    <p>Un framework de plantillas de código abierto.</p></div>
            </div>
            <div class="col-xs-12 col-sm-4">
               <div class="jumbotron"> <img src="/img/spring.png" alt="spring" class="img-responsive"/>
                <p>Un framework para el desarrollo de aplicaciones y
                    contenedor de inversión de control, de código abierto.</p></div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="jumbotron"><img src="/img/hibernate.png" alt="hibernate" class="img-responsive"/>
                <p>Un framework de persistencia de código abierto.</p></div>
            </div>
        </div>
    </tiles:putAttribute>

</tiles:insertDefinition>
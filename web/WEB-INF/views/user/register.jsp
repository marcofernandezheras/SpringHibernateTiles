<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="title">Librería Spring - Tiles</tiles:putAttribute>

    <tiles:putAttribute name="content">
        <c:import url="../messages.jsp" />
        <h2>Registro de usuarios:</h2>
        <div class="col-xs-12 col-md-6 col-md-offset-3">
            <form action="${pageContext.request.contextPath}/user/register.form" method="post">
                <div class="form-group">
                    <label class="control-label">Nombre:</label>
                    <form:input path="user.name" type="text" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Apellidos:</label>
                    <form:input path="user.surname" type="text"  cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <label class="control-label">DNI:</label>
                    <form:input path="user.dni" type="text"  cssClass="form-control"/>
                </div>
                <hr/>
                <label class="control-label">Password:</label>
                <form:input path="user.password" type="password"  cssClass="form-control"/>
                <hr/>
                <input class="btn btn-success pull-right" type="submit" value="Registrarse"/>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>

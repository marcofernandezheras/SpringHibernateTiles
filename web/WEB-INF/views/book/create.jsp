<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="title">Librería Spring - Tiles</tiles:putAttribute>

    <tiles:putAttribute name="content">
        <c:import url="../messages.jsp" />
        <div class="col-xs-12 col-md-6 col-md-offset-3">
            <h2 class="text-center">Nuevo libro</h2>
            <h3>Datos:</h3>
            <form:form action="${pageContext.request.contextPath}/book/create.form" method="post" modelAttribute="book">
                <%-- Importamos la tabla del libro --%>
                <c:import url="editbookData.jsp"/>
                <input class="btn btn-success pull-right" type="submit" value="Guardar"/>
            </form:form>
            <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/book/list.form">Volver</a>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
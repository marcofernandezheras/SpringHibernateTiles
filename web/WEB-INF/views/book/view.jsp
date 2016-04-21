<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="title">Librería Spring - Tiles</tiles:putAttribute>

    <tiles:putAttribute name="content">
        <c:import url="../messages.jsp" />
        <div class="col-xs-12 col-md-6 col-md-offset-3">
            <h2 class="text-center">${book.title}</h2>
            <h3>Datos:</h3>
            <table class="table-striped">
                <tbody>
                <tr>
                    <td>Título</td>
                    <td>${ book.title }</td>
                </tr>
                <tr>
                    <td>Autor</td>
                    <td>${ book.author }</td>
                </tr>
                <tr>
                    <td>Tema</td>
                    <td>${book.topic}</td>
                </tr>
                <tr>
                    <td>Numero de páginas</td>
                    <td>${ book.pages }</td>
                </tr>
                <tr>
                    <td>Cartone</td>
                    <td><form:checkbox path="book.formatOne"  value="${ !book.formatOne }" disabled="true" /></td>
                </tr>
                <tr>
                    <td>Rustica</td>
                    <td><form:checkbox path="book.formatTwo"  value="${ !book.formatTwo }"  disabled="true" /></td>
                </tr>
                <tr>
                    <td>Tapa dura</td>
                    <td><form:checkbox path="book.formatThree"  value="${ !book.formatThree }"  disabled="true"/></td>
                </tr>
                <tr>
                    <td>Estado</td>
                    <td>
                        <form:radiobutton path="book.isNew" value="true" label="Novedad" disabled="true"/>
                        <form:radiobutton path="book.isNew" value="false" label="Reedicion" disabled="true"/>
                    </td>
                </tr>
                <td>Precio</td>
                <td>${ book.price }</td>
                </tbody>
            </table>
            <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/book/list.form">Volver</a>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
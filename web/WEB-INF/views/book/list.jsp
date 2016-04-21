<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="defaultTemplate">

    <tiles:putAttribute name="title">Librería Spring - Tiles</tiles:putAttribute>

    <tiles:putAttribute name="content">
        <c:import url="../messages.jsp" />
        <h2>Lista de libros:</h2>
        <div class="col-xs-12">
            <c:set var="user" value="${sessionScope.get('user')}"/>
            <c:if test="${books.isEmpty() }">
                <p>No hay Libros que mostrar</p>
            </c:if>
            <c:if test="${not books.isEmpty() }">
            <table class="table table-striped centered">
                <tbody>
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td>${book.title}</td>
                            <c:if test="${user.isValid()}"><td class="pull-right">
                                <form action="${pageContext.request.contextPath}/book/delete.form" method="post">
                                    <input type="hidden" name="id" value="${book.id}" >
                                    <button type="submit" class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-remove"></span></button>
                                </form>
                            </td>
                            <td class="pull-right"><a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/book/edit.form?id=${book.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
                            </c:if><td class="pull-right"><a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/book/view.form?id=${book.id}"><span class="glyphicon glyphicon-eye-open"></span></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            </c:if>
            <c:if test = "${user.isValid()}">
                <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/book/create.form">Añadir libro</a>
            </c:if>
        </div>
    </tiles:putAttribute>

</tiles:insertDefinition>
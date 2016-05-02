<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="defaultTemplate">

    <tiles:putAttribute name="title">Librería Spring - Tiles</tiles:putAttribute>

    <tiles:putAttribute name="content">
        <c:import url="../messages.jsp" />
        <div class="col-xs-12 col-md-6 col-md-offset-3">
        <h2>Tus facturas:</h2>
        <div class="col-xs-12">
            <c:set var="user" value="${sessionScope.get('user')}"/>
            <c:if test="${bills.isEmpty() }">
                <p>No hay facturas que mostrar</p>
            </c:if>
            <c:if test="${not bills.isEmpty() }">
                <table class="table table-striped centered">
                    <thead>
                        <tr>
                            <th>Nº</th>
                            <th>Fecha</th>
                            <th>Importe</th>
                            <th>Ver</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="bill" items="${bills}">
                        <tr>
                            <td>${bill.id}</td>
                            <td>${bill.date}</td>
                            <td>${bill.total()}</td>
                            <td><a href="${pageContext.request.contextPath}/bill/view.form?id=${bill.id}" class="btn btn-sm btn-success"><span class="glyphicon glyphicon-eye-open"></span></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
        </div>
    </tiles:putAttribute>

</tiles:insertDefinition>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="title">Librería Spring - Tiles</tiles:putAttribute>

    <tiles:putAttribute name="content">
        <c:import url="../messages.jsp" />
        <div class="col-xs-12 col-md-6 col-md-offset-3">
            <h3>Factura Nº ${bill.id}</h3>
            <table class="table table-striped centered">
                <thead>
                <tr>
                    <th>Título</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Subtotal</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="detail" items="${bill.details}">
                    <tr>
                        <td>${detail.title}</td>
                        <td>${detail.price}</td>
                        <td>${detail.amount}</td>
                        <td>${detail.total()}</td>
                    </tr>
                </c:forEach>
                    <tr class="info">
                        <td></td><td></td>
                        <td>TOTAL</td>
                        <td>${bill.total()}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>

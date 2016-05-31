<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="title">Librería Spring - Tiles</tiles:putAttribute>

    <tiles:putAttribute name="content">
        <c:import url="../messages.jsp" />
        <div class="col-xs-12 col-md-6 col-md-offset-3">
            <table class="table table-striped centered">
                <thead>
                <tr>
                    <th></th>
                    <th>Título</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Subtotal</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="detail" items="${sessionScope.cart.details}">
                    <tr data-title="${detail.title}">
                        <td>
                            <form action="${pageContext.request.contextPath}/cart/remove.form" method="post" name="cartAjaxForm">
                                <input type="hidden" name="title" value="${detail.title}">
                                <button type="submit" class="btn btn-sm btn-danger pull-right"><span class="glyphicon glyphicon-minus-sign"></span></button>
                            </form>
                        </td>
                        <td>${detail.title}</td>
                        <td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${detail.price}" /></td>
                        <td>${detail.amount}</td>
                        <td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${detail.total()}" /></td>
                    </tr>
                </c:forEach>
                <tr class="info">
                    <td></td><td></td><td></td>
                    <td>TOTAL</td>
                    <td id="tdTotal"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${sessionScope.cart.total()}" /></td>
                </tr>
                </tbody>
            </table>
        </div>
        <c:if test="${sessionScope.actualUser.valid && sessionScope.cart.count() != 0}">
        <div class="col-xs-12 col-md-6 col-md-offset-3">
            <form action="${pageContext.request.contextPath}/cart/buy.form" method="post">
                <button type="submit" class="btn btn-sm btn-success pull-right">Comprar <span class="glyphicon glyphicon-thumbs-up"></span></button>
            </form>
        </div>
        </c:if>
    </tiles:putAttribute>

    <tiles:putAttribute name="extraScripts">
        <script src="${pageContext.request.contextPath}/js/cartController.js"></script>
    </tiles:putAttribute>
</tiles:insertDefinition>

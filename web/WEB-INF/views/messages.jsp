<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test = "${message != null}">
    <div class="col-xs-12 col-md-10 col-md-offset-1 alert alert-dismissible alert-success">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <strong>¡Todo Correcto!</strong> <c:out value="${message}" />
    </div>
</c:if>
<c:if test="${error != null}">
    <div class="col-xs-12 col-md-10 col-md-offset-1 alert alert-dismissible alert-danger">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <strong>¡Error!</strong> <c:out value="${error}"/>
    </div>
</c:if>
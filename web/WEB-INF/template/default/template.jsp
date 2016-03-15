<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true" defaultValue="Spring Tiles"/></title>
</head>
<body>
    <tiles:insertAttribute name="content" />
</body>
</html>
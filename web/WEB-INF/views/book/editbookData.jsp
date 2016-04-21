<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- Importamos el core de JSTL --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table class="table-striped">
    <tbody>
    <tr>
        <td>Título</td>
        <td>
            <form:input path="title" cssClass="form-control" type="text" value="${ title }"/>
        </td>
    </tr>
    <tr>
        <td>Autor</td>
        <td>
            <form:input path="author" cssClass="form-control" type="text"  value="${ author }"/>
        </td>
    </tr>
    <tr>
        <td>Tema</td>
        <td>
            <form:select path="topic" cssClass="form-control" >
                <form:option value="Accion" label="Accion" />
                <form:option value="Aventuras" label="Aventuras" />
                <form:option value="Biografía" label="Biografía" />
                <form:option value="Ciencia" label="Ciencia" />
                <form:option value="Ciencia Ficción" label="Ciencia Ficción" />
                <form:option value="Cine" label="Cine" />
                <form:option value="Economía" label="Economía" />
                <form:option value="Gastronomía" label="Gastronomía" />
                <form:option value="Historia" label="Historia" />
                <form:option value="Informática" label="Informática" />
                <form:option value="Medicina" label="Medicina" />
                <form:option value="Misterio" label="Misterio" />
                <form:option value="Naturaleza" label="Naturaleza" />
                <form:option value="Policíaco" label="Policíaco" />
                <form:option value="Política" label="Política" />
                <form:option value="Romántica" label="Romántica" />
                <form:option value="Teatro" label="Teatro" />
                <form:option value="Terror" label="Terror" />
            </form:select>
        </td>
    </tr>
    <tr>
        <td>Numero de páginas</td>
        <td>
            <form:input cssClass="form-control" type="number" path="pages" value="${ pages }"/>
        </td>
    </tr>
    <tr>
        <td>Cartone</td>

        <td><form:checkbox path="formatOne"  value="${ !formatOne }" /></td>
    </tr>
    <tr>
        <td>Rustica</td>
        <td><form:checkbox path="formatTwo"  value="${ !formatTwo }" /></td>
    </tr>
    <tr>
        <td>Tapa dura</td>
        <td><form:checkbox path="formatThree"  value="${ !formatThree }" /></td>
    </tr>
    <tr>
        <td>Estado</td>
        <td>
            <form:radiobutton path="isNew" value="true" label="Novedad"/>
            <form:radiobutton path="isNew" value="false" label="Reedicion"/>
        </td>
    </tr>
    <td>Precio</td>
    <td>
        <form:input cssClass="form-control" type="number" step="0.01" path="price" value="${ price }"/>
    </td>
    </tbody>
</table>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<div>
    <table>
        <thead>
            <tr>
                <th><s:text name="listado.nombre"/></th>
                <th><s:text name="listado.appaterno"/></th>
                <th><s:text name="listado.apmaterno"/></th>
                <th><s:text name="listado.modalidad"/></th>
                <th><s:text name="listado.estado"/></th>
                <th><s:text name="listado.nivel"/></th>
                <th><s:text name="listado.fechaIngreso"/></th>
                <th colspan="2"><s:text name="listado.accion"/></th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="listadoProfesor">
                <tr>
                    <td><s:property value="nombre"/></td>
                    <td><s:property value="apPaterno"/></td>
                    <td><s:property value="apMaterno"/></td>
                    <td>
                        <s:if test="modalidad=='T'">
                            <s:text name="modalidad.titular"/>
                        </s:if>
                        <s:if test="modalidad=='A'">
                            <s:text name="modalidad.agregado"/>
                        </s:if>
                        <s:if test="modalidad=='H'">
                            <s:text name="modalidad.ayudante"/>
                        </s:if>
                        <s:if test="modalidad=='I'">
                            <s:text name="modalidad.interno"/>
                        </s:if>
                    </td>
                    <td>
                        <s:if test="estado=='A'">
                            <s:text name="estadoProfesor.activo"/>
                        </s:if>
                        <s:if test="estado=='I'">
                            <s:text name="estadoProfesor.inactivo"/>
                        </s:if>
                        <s:if test="estado=='C'">
                            <s:text name="estadoProfesor.capacitacion"/>
                        </s:if>
                        <s:if test="estado=='V'">
                            <s:text name="estadoProfesor.vacaciones"/>
                        </s:if>
                    </td>
                    <td>
                        <s:if test="nivel=='T'">
                            <s:text name="nivelAcademico.tecnico"/>
                        </s:if>
                        <s:if test="nivel=='S'">
                            <s:text name="nivelAcademico.superior"/>
                        </s:if>
                        <s:if test="nivel=='M'">
                            <s:text name="nivelAcademico.master"/>
                        </s:if>
                    </td>
                    <td><s:date format="dd/MM/yyyy" name="fcIngreso"/></td>
                    <td>
                        <s:url action="paginaModificar" var="paginaModificar">
                            <s:param name="id" value="idProfesor"/>
                        </s:url>
                        <s:a href="%{paginaModificar}"><s:text name="listado.editar"/></s:a>
                        </td>
                        <td>
                        <s:url action="eliminar" var="eliminar">
                            <s:param name="id" value="idProfesor"/>
                        </s:url>
                        <s:a href="%{eliminar}"><s:text name="listado.eliminar"/></s:a>
                        </td>
                    </tr>
            </s:iterator>
        </tbody>
    </table>
    <div>
        <s:url action="paginaInsertar" var="paginaInsertar"></s:url>
        <s:a href="%{paginaInsertar}"><s:text name="listado.insertar"/></s:a>
        <s:url action="indice" namespace="/" id="indice"></s:url>
        <s:a href="%{indice}"><s:text name="volver"/></s:a>
    </div>
</div>
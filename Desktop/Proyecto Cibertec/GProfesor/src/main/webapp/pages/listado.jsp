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
                <th><s:text name="listado.fechaRegistro"/></th>
                <th><s:text name="listado.fechaActualizacion"/></th>
                <th colspan="3"><s:text name="listado.accion"/></th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="listadoProfesor">
                <tr>
                    <td><s:property value="nombre"/></td>
                    <td><s:property value="apPaterno"/></td>
                    <td><s:property value="apMaterno"/></td>
                    <td><s:property value="modalidad"/></td>
                    <td><s:property value="estado"/></td>
                    <td><s:property value="nivel"/></td>
                    <td><s:date format="dd/MM/yyyy" name="fcIngreso"/></td>
                    <td><s:date format="dd/MM/yyyy" name="fcRegistro"/></td>
                    <td><s:date format="dd/MM/yyyy" name="fcActualizacion"/></td>
                    <td>
                        <s:url var="editar">
                            <s:param name="id" value="idProfesor"/>
                        </s:url>
                        <s:a href="#"><s:text name="listado.editar"/></s:a>
                        </td>
                        <td>
                        <s:url var="eliminar">
                            <s:param name="id" value="idProfesor"/>
                        </s:url>
                        <s:a href="#"><s:text name="listado.eliminar"/></s:a>
                        </td>
                        <td>
                        <s:url var="detalle">
                            <s:param name="id" value="idProfesor"/>
                        </s:url>
                        <s:a href="#"><s:text name="listado.detalle"/></s:a>
                        </td>
                    </tr>
            </s:iterator>
        </tbody>
    </table>
    <div>
        <s:url action="paginaInsertar" var="paginaInsertar"></s:url>
        <s:a href="%{paginaInsertar}"><s:text name="listado.insertar"/></s:a>
    </div>
</div>
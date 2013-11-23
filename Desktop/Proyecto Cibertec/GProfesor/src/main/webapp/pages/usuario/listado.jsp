<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<a href="<c:url value='j_spring_security_logout' />"><s:text name="enlace.salir"></s:text></a>
<div>
    <table>
        <thead>
            <tr>
                <th><s:text name="listado.usuario.nombre"/></th>
                <th><s:text name="listado.usuario.activo"/></th>
                <th><s:text name="listado.usuario.roles"/></th>
                <th colspan="3"><s:text name="accion"/></th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="listaUsuarios">
                <tr>
                    <td><s:property value="nombre"/></td>
                    <td><s:property value="activo"/></td>
                    <td><s:iterator value="roles">
                            <s:property value="nombre"/><br/>
                        </s:iterator>
                    </td>
                    <td><s:url action="eliminarUsuario" id="eliminar">
                        <s:param name="usuario.id">
                            <s:property value="id"/>
                        </s:param>
                        </s:url>
                        <s:a href="%{eliminar}">
                            <s:text name="listado.eliminar"/>
                        </s:a>
                    </td>
                    </tr>
            </s:iterator>
        </tbody>
    </table>
    <div>
        <s:url action="nuevoUsuario" id="nuevo"></s:url>
        <s:a href="%{nuevo}"><s:text name="enlace.usuario.nuevo"/></s:a>
        <s:url action="indice" id="indice"></s:url>
        <s:a href="%{indice}"><s:text name="volver"/></s:a>
    </div>
</div>

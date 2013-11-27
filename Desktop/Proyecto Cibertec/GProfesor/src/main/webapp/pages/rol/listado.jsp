<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<a href="<c:url value='j_spring_security_logout' />"><s:text name="enlace.salir"></s:text></a>
<div>
    <table>
        <thead>
            <tr>
                <th><s:text name="listado.rol.nombre"/></th>
                <th colspan="3"><s:text name="accion"/></th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="listaRoles">
                <tr>
                    <td><s:property value="nombre"/></td>
                    <td><s:url action="eliminarRol" id="eliminar">
                        <s:param name="rol.id">
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
        <s:url action="nuevoRol" id="nuevo"></s:url>
        <s:a href="%{nuevo}"><s:text name="enlace.rol.nuevo"/></s:a>
        <s:url action="indice" namespace="/" id="indice"></s:url>
        <s:a href="%{indice}"><s:text name="volver"/></s:a>
    </div>
</div>


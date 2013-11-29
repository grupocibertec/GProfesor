<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:head/>
<s:form action="insertarUsuario">
        <s:textfield label="%{getText('listado.usuario.nombre')}" name="usuario.nombre"/>
        <s:password label="%{getText('listado.usuario.clave')}" name="usuario.clave"></s:password>
        <s:checkbox  label="%{getText('listado.usuario.activo')}" name="usuario.activo"></s:checkbox>
         <s:select multiple="true" size="3" label="%{getText('listado.usuario.roles')}"  
                   list="listaRoles" listKey="id" listValue="nombre" name="usuario.roles.id"></s:select>
	<s:submit value="%{getText('listado.aceptar')}"/>
</s:form>
 <s:url action="listarUsuarios" id="listar"></s:url>
 <s:a href="%{listar}"><s:text name="volver"/></s:a>
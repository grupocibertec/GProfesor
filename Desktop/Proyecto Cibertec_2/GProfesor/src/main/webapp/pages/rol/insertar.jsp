<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:head/>
<s:form action="insertarRol">
        <s:textfield label="%{getText('listado.rol.nombre')}" name="rol.nombre"/>
	<s:submit value="%{getText('listado.aceptar')}"/>
</s:form>
 <s:url action="listarRoles" id="listar"></s:url>
 <s:a href="%{listar}"><s:text name="volver"/></s:a>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<h3><s:text name="indice.titulo"></s:text></h3>
<a href="<c:url value='j_spring_security_logout' />"><s:text name="enlace.salir"></s:text></a>
<ul>
     <li>
     <s:url action="verListado" namespace="/" id="profesores" />
        <s:a href="%{profesores}"><s:text name="enlace.profesores"/></s:a>
      </li>
      <li>
      <s:url action="listarUsuarios" namespace="/admin" id="usuarios" />
        <s:a href="%{usuarios}"><s:text name="enlace.usuarios"/></s:a>
      </li>
      <li>
      <s:url action="listarRoles" namespace="/admin" id="roles" />
        <s:a href="%{roles}"><s:text name="enlace.roles"/></s:a>
      </li>
</ul>   


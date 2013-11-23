<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title></title>
<s:head/>
</head>
<body onload='document.frmlogin.j_username.focus();'>
    <h3><s:text name="login.titulo"></s:text></h3>
    <form name='frmlogin' action="<c:url value='j_spring_security_check' />" method='POST'>
        <table>
            <tr>
                    <td><s:text name="login.etiqueta.usuario"></s:text> :</td>
                    <td><input type='text' name='j_username' value=''>
                    </td>
            </tr>
            <tr>
                    <td><s:text name="login.etiqueta.clave"></s:text> :</td>
                    <td><input type='password' name='j_password' />
                    </td>
            </tr>
            <tr>
                    <td colspan='2'><input name="submit" type="submit" value="<s:text name="login.boton.aceptar"></s:text>" />
                    </td>
            </tr>
            <tr>
                <td colspan='2'><input name="reset" type="reset" value="<s:text name="login.boton.reiniciar"></s:text>" />
                    </td>
            </tr>
        </table>
 
   </form>
</body>
</html>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<div>
    <table>
        <tbody>
            <tr><td><s:text name="listado.nombre"/>: <s:property value="profesor.nombre"/></td></tr>
            <tr><td><s:text name="listado.appaterno"/>: <s:property value="profesor.apPaterno"/></td></tr>
            <tr><td><s:text name="listado.apmaterno"/>: <s:property value="profesor.apMaterno"/></td></tr>
            
        </tbody>
    </table>
</div>
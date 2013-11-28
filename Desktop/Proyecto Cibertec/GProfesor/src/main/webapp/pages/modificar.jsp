<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
    <head>
        <script src="../js/jquery-2.0.3.min.js" type="text/javascript"></script>
        <sj:head jqueryui="true" jquerytheme="cupertino" locale="es"/>
        <s:head/>
    </head>
    <body>
        <div>
            <s:form action="modificarProfesor" autocomplete="off">
                <s:hidden name="profesor.idProfesor"/>
                <s:textfield required="true" label="%{getText('listado.nombre')}" maxlength="50" name="profesor.nombre"/>
                <s:textfield required="true" label="%{getText('listado.appaterno')}" maxlength="50" name="profesor.apPaterno"/>
                <s:textfield required="true" label="%{getText('listado.apmaterno')}" maxlength="50" name="profesor.apMaterno"/>
                <sj:datepicker maxlength="10" name="fechaNacimiento" 
                               displayFormat="dd/mm/yy" label="%{getText('listado.fechanacimiento')}" 
                               showAnim="slideDown" duration="fast"  required="true"/>

                <s:select list="listadoGenero" 
                          listKey="idGenero" 
                          listValue="Genero" 
                          headerKey="-1" 
                          headerValue="%{getText('combo.header')}"
                          label="%{getText('listado.genero')}"
                          name="profesor.genero" required="true"></s:select>

                <s:textfield required="true" label="%{getText('listado.dni')}" maxLength="8" name="profesor.dni"/>
                <s:textfield label="%{getText('listado.email')}" maxlength="50" name="profesor.email"/>
                <s:textfield label="%{getText('listado.direccion')}" maxlength="50" name="profesor.direccion"/>

                <s:select list="listadoModalidad" 
                          listKey="idModalidad" 
                          listValue="Modalidad" 
                          headerKey="-1" 
                          headerValue="%{getText('combo.header')}"
                          label="%{getText('listado.modalidad')}"
                          name="profesor.modalidad" required="true"></s:select>

                <s:select list="listadoNivelAcademico" 
                          listKey="idNivelAcademico" 
                          listValue="NivelAcademico" 
                          headerKey="-1" 
                          headerValue="%{getText('combo.header')}"
                          label="%{getText('listado.nivel')}"
                          name="profesor.nivel" required="true"></s:select>

                <s:select list="listadoEstadoProfesor" 
                          listKey="idEstadoProfesor" 
                          listValue="EstadoProfesor" 
                          headerKey="-1" 
                          headerValue="%{getText('combo.header')}"
                          label="%{getText('listado.estado')}"
                          name="profesor.estado" required="true"></s:select>


                <sj:datepicker maxlength="10" name="fechaIngreso" 
                               displayFormat="dd/mm/yy" label="%{getText('listado.fechaIngreso')}" 
                               showAnim="slideDown" duration="fast" />

                <s:submit value="%{getText('listado.aceptar')}"/>
            </s:form>
        </div>
        <div>
            <s:url action="verListado" var="verListado"></s:url>
            <s:a href="%{verListado}"><s:text name="volver"/></s:a>
        </div>
    </body>
</html>


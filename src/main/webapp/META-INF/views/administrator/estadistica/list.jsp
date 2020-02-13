<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
<acme:list-column code="administrator.estadistica.list.label.nombre" path="nombre" width="50%"/>
<acme:list-column code="administrator.estadistica.list.label.valor" path="valor" width="50%"/>

</acme:list>
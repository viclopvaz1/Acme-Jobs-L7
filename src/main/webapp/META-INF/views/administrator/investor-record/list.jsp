<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
<acme:list-column code="administrator.investor-record.list.label.investor" path="investor" width="20%"/>
<acme:list-column code="administrator.investor-record.list.label.sector" path="sector" width="30%"/>
<acme:list-column code="administrator.investor-record.list.label.statement" path="statement" width="20%"/>
<acme:list-column code="administrator.investor-record.list.label.star" path="star" width="30%"/>
</acme:list>
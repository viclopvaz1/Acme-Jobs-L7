<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.investor-record.form.label.investor" path="investor"/>
	<acme:form-textbox code="administrator.investor-record.form.label.sector" path="sector"/>
	<acme:form-textarea code="administrator.investor-record.form.label.statement" path="statement"/>
	<acme:form-integer code="administrator.investor-record.form.label.star" path="star"/>
	

	<acme:form-submit test="${command == 'create'}" code="administrator.investor-record.form.buttom.create" action="create"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.investor-record.form.buttom.update" action="update"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.investor-record.form.buttom.delete" action="delete"/>
	<acme:form-submit test="${command == 'update'}" code="administrator.investor-record.form.buttom.update" action="update"/>
	<acme:form-submit test="${command == 'delete'}" code="administrator.investor-record.form.buttom.delete" action="delete"/>
	<acme:form-return code="administrator.investor-record.form.button.return"/>
</acme:form>
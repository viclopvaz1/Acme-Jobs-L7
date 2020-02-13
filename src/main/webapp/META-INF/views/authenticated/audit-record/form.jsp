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

	<acme:form-textbox code="authenticated.audit-record.form.label.title" path="title"/>
	<acme:form-textarea code="authenticated.audit-record.form.label.body" path="body"/>
	<acme:form-moment code="authenticated.audit-record.form.label.moment" path="moment"/>
	<acme:form-checkbox code="authenticated.audit-record.form.label.status" path="status"/>
	<acme:form-textbox code="authenticated.audit-record.form.label.auditor" path="auditor.identity.fullName"/>
	<acme:form-textbox code="authenticated.audit-record.form.label.job" path="job.reference"/>

	<acme:form-return code="authenticated.job.form.button.return"/>
</acme:form> 
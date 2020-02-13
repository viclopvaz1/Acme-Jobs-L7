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

	<jstl:if test="${command!='update' }">
		<acme:form-textbox code="auditor.audit-record.form.label.title" path="title"/>
		<acme:form-textarea code="auditor.audit-record.form.label.body" path="body"/>
		<jstl:if test="${command!='create' }">
			<acme:form-moment code="auditor.audit-record.form.label.moment" path="moment"/>
			<acme:form-textbox code="auditor.audit-record.form.label.auditor" path="auditor.identity.fullName" readonly="true"/>
			<acme:form-textbox code="auditor.audit-record.form.label.job" path="job.reference" readonly="true"/>
		</jstl:if>
	</jstl:if>
	<acme:form-checkbox code="auditor.audit-record.form.label.status" path="status"/>
	<acme:form-hidden path="jobid"/> 
	
	<acme:form-submit test="${command == 'create' }"
		code="auditor.audit-record.form.button.create" 
		action="/auditor/audit-record/create"/>
		
	<acme:form-submit test="${command == 'show' && status ==false}"
		code="auditor.audit-record.form.button.update" 
		action="/auditor/audit-record/update"/>
		
	<acme:form-return code="auditor.audit-record.form.button.return"/>
</acme:form> 
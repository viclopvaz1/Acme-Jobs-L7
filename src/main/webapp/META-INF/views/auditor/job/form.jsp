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

	<acme:form-textbox code="auditor.job.form.label.reference" 
		placeholder="auditor.job.form.placeolder.reference" path="reference"/>
	<acme:form-textbox code="auditor.job.form.label.title" path="title"/>
	<acme:form-moment code="auditor.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="auditor.job.form.label.salary" path="salary"/>
	<acme:form-textarea code="auditor.job.form.label.description" path="description"/>
	<acme:form-url code="auditor.job.form.label.moreInfo" path="moreInfo"/>
	<acme:form-textbox code="auditor.job.form.label.employer" path="employer.identity.fullName" />	
	<acme:form-submit code="auditor.job.form.button.audit-record" action="/authenticated/audit-record/list-mine?jobid=${id}"  method="get"/>
	<acme:form-submit code="auditor.job.form.button.duty" action="/authenticated/duty/list-mine?jobid=${id}"  method="get"/>
	<acme:form-submit code="auditor.job.form.button.create-audit-record" action="/auditor/audit-record/create?jobid=${id}" method="get"/>
  	<%--<acme:form-submit code="auditor.job.form.button.list.audit-record" action="/auditor/audit-record/list-mine?jobid=${id}"  method="get"/> --%>
  	<acme:form-return code="auditor.job.form.button.return"/>
</acme:form>
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

	<acme:form-textbox code="employer.job.form.label.reference" 
		placeholder="EEEE-JJJJ" path="reference"/>
	<acme:form-textbox code="employer.job.form.label.title" path="title"/>
	<acme:form-moment code="employer.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="employer.job.form.label.salary" path="salary"/>
	<acme:form-textarea code="employer.job.form.label.description" path="description"/>
	<acme:form-url code="employer.job.form.label.moreInfo" path="moreInfo"/>
	<jstl:if test="${command != 'create'}">
		<%-- <acme:form-textbox code="employer.job.form.label.status" path="status"/> --%>
		<acme:form-checkbox code="employer.job.form.label.status" path="status"/>
	    <acme:form-textbox code="employer.job.form.label.employer" path="employer.identity.fullName" readonly="true" />	
	</jstl:if>

	
	<acme:form-submit test="${command == 'show' && status == false}"
		code="employer.job.form.button.update" 
		action="/employer/job/update"/>
	<acme:form-submit test="${command == 'show' }"
		code="employer.job.form.button.delete" 
		action="/employer/job/delete"/>
	<acme:form-submit test="${command == 'create'}"
		code="employer.job.form.button.create" 
		action="/employer/job/create"/>
	<acme:form-submit test="${command == 'update' }"
		code="employer.job.form.button.update" 
		action="/employer/job/update"/>
	<acme:form-submit test="${command == 'delete' }"
		code="employer.job.form.button.delete" 
		action="/employer/job/delete"/>

	
	<acme:form-submit test="${command == 'show' && status == true}" code="employer.job.form.button.audit-record" action="/authenticated/audit-record/list-mine?jobid=${id}"  method="get"/>
	<acme:form-submit test="${command == 'show' || command == 'update' }" code="employer.job.form.button.duty" action="/employer/duty/list-mine?jobid=${id}"  method="get"/>
	<acme:form-submit test="${command == 'show' || command == 'update' && status == false }" code="employer.job.form.button.create-duty" action="/employer/duty/create?jobid=${id}" method="get"/>
  	<acme:form-return code="employer.job.form.button.return"/>
</acme:form>
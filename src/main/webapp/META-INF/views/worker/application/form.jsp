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

	<input name="jobId" id="jobId" type="hidden" value="${param.jobId}" />
	<acme:form-textbox code="worker.application.form.label.referenceNumber" path="referenceNumber" placeholder="EEEE-JJJJ:WWWW" />

	<jstl:if test="${command != 'create'}">
	     <acme:form-moment code="worker.application.form.label.moment"
	      path="moment" 
	      readonly="true"/>
	      <acme:form-textbox code="worker.application.form.sponsor" path="worker.identity.fullName" readonly="true"/>
	</jstl:if>
	<acme:form-textarea code="worker.application.form.label.statement" path="statement"/>
	<acme:form-textarea code="worker.application.form.label.skills" path="skills" readonly="true"/>
	<acme:form-textarea code="worker.application.form.label.qualifications" path="qualifications" readonly="true"/>

	
	<acme:form-submit test="${command == 'create' }" code="worker.application.form.button.createApplication" action="/worker/application/create" method ="post" />
	<acme:form-return code="worker.application.form.button.return" />
</acme:form>
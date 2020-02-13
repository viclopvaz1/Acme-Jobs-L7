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
	<jstl:if test="${command!='update'}">
		<acme:form-textbox code="employer.application.form.label.referenceNumber" path="referenceNumber"/>
		<acme:form-moment code="employer.application.form.label.moment" path="moment"/>
		<acme:form-textarea code="employer.application.form.label.statement" path="statement" />
		<acme:form-textbox code="employer.application.form.label.skills" path="skills"/>
		<acme:form-textbox code="employer.application.form.label.qualifications" path="qualifications"/>
		<acme:form-textbox code="employer.application.form.label.worker" path="worker.identity.fullName"/>
		<acme:form-textarea code="employer.application.form.label.statement" path="statement"/>
	</jstl:if>
	<acme:form-select code="employer.application.form.label.status" path="status">
    	<jstl:if test="${command!='update'}"> 
    		<option value="pending" <jstl:if test="${status =='pending'}">selected</jstl:if>>pending</option>
    	</jstl:if>
    	<option value="accepted" <jstl:if test="${status =='accepted'}">selected</jstl:if>>accepted</option>
    	<option value="rejected" <jstl:if test="${status =='rejected'}">selected</jstl:if>>rejected</option>
	</acme:form-select>
	<jstl:if test="${status!='pending' || command=='update'}">
		<acme:form-textarea code="employer.application.form.label.reason" path="reason"/>
	</jstl:if>
	<acme:form-submit test="${command == 'show' && status=='pending'}" code="employer.application.form.button.status" action="/employer/application/update?id=${id}" method = "get"/>
	<acme:form-submit test="${command == 'update'}" code="employer.application.form.button.statement" action="/employer/application/update"/>
  	<acme:form-return code="employer.application.form.button.return"/>
</acme:form>
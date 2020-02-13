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
	<acme:form-textbox code="administrator.challenge.form.label.title" path="title"/>
	<acme:form-textarea code="administrator.challenge.form.label.description" path="description"/>
	<acme:form-moment code="administrator.challenge.form.label.deadline" path="deadline"/>
	<acme:form-money code="administrator.challenge.form.label.goldReward" path="goldReward"/>
	<acme:form-money code="administrator.challenge.form.label.silverReward" path="silverReward"/>
	<acme:form-money code="administrator.challenge.form.label.bronzeReward" path="bronzeReward"/>
	<acme:form-textarea code="administrator.challenge.form.label.goldGoal" path="goldGoal"/>
	<acme:form-textarea code="administrator.challenge.form.label.silverGoal" path="silverGoal"/>
	<acme:form-textarea code="administrator.challenge.form.label.bronzeGoal" path="bronzeGoal"/>
	
	<acme:form-submit test="${command == 'show' }"
		code="administrator.challenge.form.button.update" 
		action="/administrator/challenge/update"/>
	<acme:form-submit test="${command == 'show' }"
		code="administrator.challenge.form.button.delete" 
		action="/administrator/challenge/delete"/>
	<acme:form-submit test="${command == 'create' }"
		code="administrator.challenge.form.button.create" 
		action="/administrator/challenge/create"/>
	<acme:form-submit test="${command == 'update' }"
		code="administrator.challenge.form.button.update" 
		action="/administrator/challenge/update"/>
	<acme:form-submit test="${command == 'delete' }"
		code="administrator.challenge.form.button.delete" 
		action="/administrator/challenge/delete"/>
	
	<acme:form-return code="administrator.challenge.form.button.return"/>
</acme:form>

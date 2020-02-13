<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<input name="threadId" id="threadId" type="hidden" value="${param.threadId}" />
	
	<acme:form-textbox code="authenticated.thread.form.label.title" path="title" />

<jstl:if test="${command != 'create'}">
	     <acme:form-moment code="authenticated.message.form.label.moment"
	      path="moment" 
	      readonly="true"/>     
		<acme:form-textarea code="authenticated.message.form.label.user.identity.fullName" path="author" />
	</jstl:if>

	<acme:form-textarea code="authenticated.message.form.label.body" path="body" />
	<acme:form-textarea code="authenticated.message.form.label.tags" path="tags" />
	<jstl:if test="${command == 'create'}">
	<acme:form-checkbox code="authenticated.message.form.label.check" path="check" />
	</jstl:if>
	
	<acme:form-return code="authenticated.message.form.button.return" />
	
	<acme:form-submit test="${command == 'create' }" code="authenticated.message.form.button.create" action="/authenticated/message/create?threadId=${threadId}" method ="post" />
</acme:form>
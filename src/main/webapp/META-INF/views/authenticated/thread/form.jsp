<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-textbox code="authenticated.thread.form.label.title" path="title" />

	<jstl:if test="${command == 'show' }">
	<acme:form-moment code="authenticated.thread.form.label.moment" path="moment" readonly="true" />
	</jstl:if>
<acme:menu-separator/>

<acme:form-submit test="${command == 'create'}"
		code="authenticated.thread.form.button.create" 
		action="/authenticated/thread/create"/>

<jstl:if test="${command == 'show' }">
<acme:form-hidden path="creador"/>
<button type="button" onclick="javascript: pushReturnUrl('/authenticated/thread/show?id=${id}');
	redirect('/authenticated/message/list?id=${id}')" class="btn btn-primary">
	<acme:message code="authenticated.thread.form.button.message"/>
	</button>		
	<button type="button" onclick="javascript: pushReturnUrl('/authenticated/thread/show?id=${id}');
	redirect('/authenticated/participation/list?threadId=${id}')" class="btn btn-primary">
	<acme:message code="authenticated.thread.form.button.participation.list"/>
	</button>		
	<acme:form-submit
	code="authenticated.participation.form.button.create" 
	action="/authenticated/participation/create?threadId=${id}" method="get"/>
	<acme:form-submit
	code="authenticated.message.form.button.create" 
	action="/authenticated/message/create?threadId=${id}" method="get"/>
	</jstl:if>		
	<acme:form-return code="authenticated.thread.form.button.return" />
</acme:form>
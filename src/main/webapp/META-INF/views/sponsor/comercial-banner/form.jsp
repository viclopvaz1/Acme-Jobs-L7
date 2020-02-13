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
	<acme:form-url code="sponsor.comercial-banner.form.picture" path="picture"/>
	<acme:form-textarea code="sponsor.comercial-banner.form.slogan" path="slogan"/>
	<acme:form-url code="sponsor.comercial-banner.form.targetUrl" path="targetUrl"/>
	<acme:form-textbox code="sponsor.comercial-banner.form.creditCard" path="creditCard"/>
	<acme:form-textbox code="sponsor.comercial-banner.form.name" path="name"/>
	<acme:form-textbox code="sponsor.comercial-banner.form.network" path="network"/>
	<acme:form-textbox code="sponsor.comercial-banner.form.monthExp" path="monthExp"/>
	<acme:form-textbox code="sponsor.comercial-banner.form.yearExp" path="yearExp"/>
	<acme:form-textbox code="sponsor.comercial-banner.form.cvv" path="cvv"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-textbox code="sponsor.comercial-banner.form.sponsor" path="sponsor.identity.fullName" readonly="true"/>
	</jstl:if>
	

	<acme:form-submit test="${command == 'show' }"
		code="sponsor.comercial-banner.form.button.update" 
		action="/sponsor/comercial-banner/update"/>
	<acme:form-submit test="${command == 'show' }"
		code="sponsor.comercial-banner.form.button.delete" 
		action="/sponsor/comercial-banner/delete"/>
	<acme:form-submit test="${command == 'create' }"
		code="sponsor.comercial-banner.form.button.create" 
		action="/sponsor/comercial-banner/create"/>
	<acme:form-submit test="${command == 'update' }"
		code="sponsor.comercial-banner.form.button.update" 
		action="/sponsor/comercial-banner/update"/>
	<acme:form-submit test="${command == 'delete' }"
		code="sponsor.comercial-banner.form.button.delete" 
		action="/sponsor/comercial-banner/delete"/>
	
	<acme:form-return code="sponsor.comercial-banner.form.button.return"/>
</acme:form>

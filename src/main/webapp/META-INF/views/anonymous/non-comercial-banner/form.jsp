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

<acme:form readonly="true">
	<acme:form-textbox code="anonymous.non-comercial-banner.form.picture" path="picture"/>
	<acme:form-textbox code="anonymous.non-comercial-banner.form.slogan" path="slogan"/>
	<acme:form-url code="anonymous.non-comercial-banner.form.targetUrl" path="targetUrl"/>
	<acme:form-url code="anonymous.non-comercial-banner.form.jingle" path="jingle"/>	
	<acme:form-textbox code="anonymous.non-comercial-banner.form.sponsor" path="sponsor.identity.fullName"/>

  	<acme:form-return code="anonymous.non-comercial-banner.form.button.return"/>
</acme:form>
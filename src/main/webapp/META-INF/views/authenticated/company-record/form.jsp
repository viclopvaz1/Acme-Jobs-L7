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
	<acme:form-textbox code="authenticated.company-record.label.name" path="name"/>
	<acme:form-textbox code="authenticated.company-record.label.sector" path="sector"/>
	<acme:form-textbox code="authenticated.company-record.label.ceo" path="ceo"/>
	<acme:form-textbox code="authenticated.company-record.label.description" path="description"/>
	<acme:form-url code="authenticated.company-record.label.webSite" path="webSite"/>
	<acme:form-textbox code="authenticated.company-record.label.phone" path="phone"/>
	<acme:form-textbox code="authenticated.company-record.label.email" path="email"/>
	<acme:form-checkbox code="authenticated.company-record.label.indication" path="indication"/>
	<acme:form-textbox code="authenticated.company-record.label.star" path="star"/>
	
  	<acme:form-return code="authenticated.company-record.form.button.return"/>
</acme:form>
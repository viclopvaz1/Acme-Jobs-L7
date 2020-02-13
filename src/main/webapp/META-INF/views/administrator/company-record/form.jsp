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
	<acme:form-textbox code="administrator.company-record.label.name" path="name"/>
	<acme:form-textbox code="administrator.company-record.label.sector" path="sector"/>
	<acme:form-textbox code="administrator.company-record.label.ceo" path="ceo"/>
	<acme:form-textarea code="administrator.company-record.label.description" path="description"/>
	<acme:form-url code="administrator.company-record.label.webSite" path="webSite"/>
	<acme:form-textbox code="administrator.company-record.label.phone" path="phone"/>
	<acme:form-textbox code="administrator.company-record.label.email" path="email"/>
	<acme:form-textbox code="administrator.company-record.label.star" path="star"/>	
	<acme:form-checkbox code="administrator.company-record.label.indication" path="indication"/>

	
	
	<acme:form-submit test="${command == 'show'}" code="administrator.company-record.form.buttom.update" action="/administrator/company-record/update"/>
  	<acme:form-submit test="${command == 'show'}" code="administrator.company-record.form.buttom.delete" action="/administrator/company-record/delete"/>
  	<acme:form-submit test="${command == 'create'}" code="administrator.company-record.form.buttom.create" action="/administrator/company-record/create"/>
  	<acme:form-submit test="${command == 'update'}" code="administrator.company-record.form.buttom.update" action="/administrator/company-record/update"/>
  	<acme:form-submit test="${command == 'delete'}" code="administrator.company-record.form.buttom.delete" action="/administrator/company-record/delete"/>
  	
  	<acme:form-return code="authenticated.company-record.form.button.return"/>
</acme:form>
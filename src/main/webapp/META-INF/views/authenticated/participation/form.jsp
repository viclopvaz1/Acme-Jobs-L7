<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="false">
	
	<input name="threadId" id="threadId" type="hidden" value="${param.threadId}" />
	
	<input name="allAuthenticated" id="allAuthenticated" type="hidden" value="" />
	<input name="nUsers" id="nUsers" type="hidden" value="" />
	
	<jstl:if test="${command == 'show' }">	
	<acme:form-textbox code="authenticated.participation.form.label.authenticated" path="authenticated" readonly="true"/>
	</jstl:if>
	<jstl:if test="${command == 'create' }">
	<acme:form-select code="authenticated.participation.form.label.authenticated" path="authenticated">
			<jstl:forEach var="iterator" items="${allAuthenticated}">
					<acme:form-option code="${iterator}" value="${iterator}"/>
			</jstl:forEach>
	
		<%-- <jstl:forEach items="allAuthenticated" var="item">
		<option value="${item.id}" > <%=${item.id}; %>
			 </option>
		</jstl:forEach>--%>
	</acme:form-select>
<acme:menu-separator/>


	
		<jstl:if test="${nUsers != 0 }">
	
			<acme:form-submit
			code="authenticated.participation.form.button.create" 
			action="/authenticated/participation/create?threadId=${threadId}" method="post"/>	
			</jstl:if>		
		</jstl:if>		

<jstl:if test="${command == 'show' }">	
	<acme:form-submit
		code="authenticated.participation.form.button.delete" 
		action="/authenticated/participation/delete?id=${id}" method="post"/>	
	</jstl:if>		
	<acme:form-return code="authenticated.participation.form.button.return" />
</acme:form>
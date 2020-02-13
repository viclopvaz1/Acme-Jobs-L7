<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>

		<%--josruialb--%>
		<%--viclopvaz1--%>
		<%--albcorare26--%>
		<%--dansangar2--%>

		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.shout" action="/anonymous/shout/create" />
			<acme:menu-suboption code="master.menu.anonymous.list-shout" action="/anonymous/shout/list" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.list-announcement" action="/anonymous/announcement/list" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.list-company-record" action="/anonymous/company-record/list" />
			<acme:menu-suboption code="master.menu.anonymous.listtop-company-record" action="/anonymous/company-record/stars" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.list-investor-record" action="/anonymous/investor-record/list" />
			<acme:menu-suboption code="master.menu.anonymous.listtop-investor-record" action="/anonymous/investor-record/stars" />


			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.list-comercial-banner" action="/anonymous/comercial-banner/list" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.list-non-comercial-banner" action="/anonymous/non-comercial-banner/list" />


		</acme:menu-option>

		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.request.list-request" action="/authenticated/request/list" />
			<acme:menu-separator />

			<acme:menu-suboption code="master.menu.authenticated.offer.list-offer" action="/authenticated/offer/list" />
			<acme:menu-separator />

			<acme:menu-suboption code="master.menu.authenticated.list-announcement" action="/authenticated/announcement/list" />
			<acme:menu-separator />

			<acme:menu-suboption code="master.menu.authenticated.list-company-record" action="/authenticated/company-record/list" />
			<acme:menu-separator />

			<acme:menu-suboption code="master.menu.authenticated.list-investor-record" action="/authenticated/investor-record/list" />
			<acme:menu-separator />

			<acme:menu-suboption code="master.menu.authenticated.list-challenge" action="/authenticated/challenge/list" />
			<acme:menu-separator />

			<acme:menu-suboption code="master.menu.authenticated.list-job" action="/authenticated/job/list" />

			<acme:menu-suboption code="master.menu.authenticated.list-mine-thread" action="/authenticated/thread/list-mine" />

			<acme:menu-suboption code="master.menu.authenticated.list-thread" action="/authenticated/thread/list" />
			
			<acme:menu-suboption code="master.menu.authenticated.create-thread" action="/authenticated/thread/create" />
      

		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown" />
			<acme:menu-separator />

			<acme:menu-suboption code="master.menu.administrator.configuration" action="/administrator/configuration/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.dashboard" action="/administrator/dashboard/show" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.estadistica" action="/administrator/estadistica/list" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.estadistica-average" action="/administrator/estadistica/list-avg" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.announcement" action="/administrator/announcement/create" />
			<acme:menu-suboption code="master.menu.administrator.list-announcement" action="/administrator/announcement/list" />


			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.list-investor-record" action="/administrator/investor-record/list" />
			<acme:menu-suboption code="master.menu.administrator.create-investor-record" action="/administrator/investor-record/create" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.list-company-record" action="/administrator/company-record/list" />
			<acme:menu-suboption code="master.menu.administrator.create-company-record" action="/administrator/company-record/create" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.list-challenge" action="/administrator/challenge/list" />
			<acme:menu-suboption code="master.menu.administrator.challenge" action="/administrator/challenge/create" />

            <acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.list.auditor" action="/administrator/auditor-request/list" />
		




		</acme:menu-option>
		<acme:menu-option code="master.menu.worker" access="hasRole('Worker')">
			<acme:menu-suboption code="master.menu.worker.application.list-mine" action="/worker/application/list-mine" />
			<acme:menu-suboption code="master.menu.worker.job.list" action="/worker/job/list" />



		</acme:menu-option>

		<acme:menu-option code="master.menu.employer" access="hasRole('Employer')">
			<acme:menu-suboption code="master.menu.employer.list-mine-job" action="/employer/job/list-mine" />
			<acme:menu-suboption code="master.menu.employer.create-job" action="/employer/job/create" />
			<acme:menu-suboption code="master.menu.employer.list-mine-application" action="/employer/application/list-mine" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.auditor" access="hasRole('Auditor')">
			<acme:menu-suboption code="master.menu.auditor.list-mine-job" action="/auditor/job/list-mine" />
			<acme:menu-suboption code="master.menu.auditor.list-mine-audit-record" action="/auditor/audit-record/list-mine" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.auditor.list-no-mine-job" action="/auditor/job/list-no-mine" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.sponsor" access="hasRole('Sponsor')">
			<acme:menu-suboption code="master.menu.sponsor.list-mine-comercial-banner" action="/sponsor/comercial-banner/list-mine" />
			<acme:menu-suboption code="master.menu.sponsor.create-comercial-banner" action="/sponsor/comercial-banner/create"/>
			<acme:menu-suboption code="master.menu.sponsor.list-mine-non-comercial-banner" action="/sponsor/non-comercial-banner/list-mine" />
			<acme:menu-suboption code="master.menu.sponsor.create-non-comercial-banner" action="/sponsor/non-comercial-banner/create"/>
		</acme:menu-option>


	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()" />
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()" />

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update" />

			<acme:menu-suboption code="master.menu.user-account.become-employer" action="/authenticated/employer/create"
				access="!hasRole('Employer')" />
			<acme:menu-suboption code="master.menu.user-account.employer" action="/authenticated/employer/update"
				access="hasRole('Employer')" />

			<acme:menu-suboption code="master.menu.user-account.become-worker" action="/authenticated/worker/create"
				access="!hasRole('Worker')" />
			<acme:menu-suboption code="master.menu.user-account.worker" action="/authenticated/worker/update"
				access="hasRole('Worker')" />
				
			<acme:menu-suboption code="master.menu.user-account.become-sponsor" action="/authenticated/sponsor/create"
				access="!hasRole('Sponsor')" />
			<acme:menu-suboption code="master.menu.user-account.sponsor" action="/authenticated/sponsor/update"
				access="hasRole('Sponsor')" />


			<acme:menu-suboption code="master.menu.user-account.become-auditor" action="/authenticated/auditor-request/create"
				access="!hasRole('Auditor')" />
			<acme:menu-suboption code="master.menu.user-account.auditor" action="/authenticated/auditor/update" access="hasRole('Auditor')" />
		
		
		</acme:menu-option>







		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()" />

	</acme:menu-right>
</acme:menu-bar>

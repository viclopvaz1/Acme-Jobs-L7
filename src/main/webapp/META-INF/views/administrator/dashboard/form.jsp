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

<h2>
	<acme:message code="administrator.dashboard.form.message"/>
</h2>
<div>
	<canvas id="canvas" style="width: 50%; height: 100px;"></canvas>
</div>
</br>
<h2>
	<acme:message code="administrator.dashboard.form.message2"/>
</h2>
<div>
	<canvas id="canvas2" style="width: 50%; height: 100px;"></canvas>
</div>
</br>
<h2>
	<acme:message code="administrator.dashboard.form.message3"/>
</h2>
<div>
	<canvas id="canvas3" style="width: 50%; height: 100px;"></canvas>
</div>
</br>
<h2>
	<acme:message code="administrator.dashboard.form.message4"/>
</h2>
<div>
	<canvas id="canvas4" style="width: 50%; height: 100px;"></canvas>
</div>
</br>
<h2>
	<acme:message code="administrator.dashboard.form.message5"/>
</h2>
<div>
	<canvas id="canvas8" style="width: 50%; height: 100px;"></canvas>
</div>

</br>

<script type="text/javascript">
	$(document).ready(function() {
		var data = {
			labels: [
				<jstl:forEach var="iterator" items="${numberOfCompaniesGroupedBySector}">
					"<jstl:out value="${iterator[0]}"/>" ,
				</jstl:forEach>
			],
			datasets: [
				{
					data: [
						<jstl:forEach var="iterator" items="${numberOfCompaniesGroupedBySector}">
							<jstl:out value="${iterator[1]}"/> ,
						</jstl:forEach>
					],
					backgroundColor: [
				          "#f38b4a",
				          "#56d798",
				          "#ff8397",
				          "#6970d5" 
				        ],
				}
			]
		};
		
		
		
		var options = {
			scales : {
				yAxes:[
					{
						ticks : {
							suggestedMin : 0.0,
							suggestedMax : 1.0
						}
					}
				]
			},
			legend : {
				display : false
			}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
		new Chart(context, {
			type: "pie",
			data: data,
			options: options
		});
		
	});
		
</script>

<script type="text/javascript">	
	$(document).ready(function() {
		var data = {
				labels: [
					<jstl:forEach var="iterator" items="${numberOfInvestorsGroupedBySector}">
						"<jstl:out value="${iterator[0]}"/>" ,
					</jstl:forEach>
				],
				datasets: [
					{
						data: [
							<jstl:forEach var="iterator" items="${numberOfInvestorsGroupedBySector}">
								<jstl:out value="${iterator[1]}"/> ,
							</jstl:forEach>
						],
						backgroundColor: [
					          "#f38b4a",
					          "#56d798",
					          "#ff8397",
					          "#6970d5" 
					        ],
					}
				]
			};
		
		var options = {
				scales : {
					yAxes:[
						{
							ticks : {
								suggestedMin : 0.0,
								suggestedMax : 1.0
							}
						}
					]
				},
				legend : {
					display : false
				}
			};
			
		var canvas, context;
			
		canvas = document.getElementById("canvas2");
		context = canvas.getContext("2d");
		new Chart(context, {
			type: "pie",
			data: data,
			options: options
		});
			
	});
</script>

<script type="text/javascript">	
	$(document).ready(function() {
		var data = {
				labels: [
					<jstl:forEach var="iterator" items="${ratioOfJobsGroupedByStatus}">
						"<jstl:out value="${iterator[0]}"/>" ,
					</jstl:forEach>
				],
				datasets: [
					{
						data: [
							<jstl:set var="total" value="${TotalJobs}"/>
							
							<jstl:forEach var="iterator" items="${ratioOfJobsGroupedByStatus}">
								<jstl:out value="${Math.round((iterator[1] / total)*100)}"/>,
							</jstl:forEach>
						],
						backgroundColor: [
					          "#f38b4a",
					          "#56d798",
					          "#ff8397",
					          "#6970d5" 
					        ],
					}
				]
			};
		
		var options = {
				scales : {
					yAxes:[
						{
							ticks : {
								suggestedMin : 0.0,
								suggestedMax : 1.0
							}
						}
					]
				},
				legend : {
					display : false
				}
			};
			
		var canvas, context;
			
		canvas = document.getElementById("canvas3");
		context = canvas.getContext("2d");
		new Chart(context, {
			type: "doughnut",
			data: data,
			options: options
		});
			
	});
</script>

<script type="text/javascript">	
	$(document).ready(function() {
		var data = {
				labels: [
					<jstl:forEach var="iterator" items="${ratioOfApplicationsGroupedByStatus}">
						"<jstl:out value="${iterator[0]}"/>" ,
					</jstl:forEach>
				],
				datasets: [
					{
						data: [
							<jstl:set var="total" value="${TotalApplications}"/>
							
							<jstl:forEach var="iterator" items="${ratioOfApplicationsGroupedByStatus}">
								<jstl:out value="${Math.round((iterator[1] / total)*100)}"/>,
							</jstl:forEach>
						],
						backgroundColor: [
					          "#f38b4a",
					          "#56d798",
					          "#ff8397",
					          "#6970d5" 
					        ],
					}
				]
			};
		
		var options = {
				scales : {
					yAxes:[
						{
							ticks : {
								suggestedMin : 0.0,
								suggestedMax : 1.0
							}
						}
					]
				},
				legend : {
					display : false
				}
			};
			
		var canvas, context;
			
		canvas = document.getElementById("canvas4");
		context = canvas.getContext("2d");
		new Chart(context, {
			type: "doughnut",
			data: data,
			options: options
		});
			
	});
</script>





<script type="text/javascript">
	$(document).ready(function() {
		var data = {
			labels: [
				"Rejected",
				"Accepted",
				"Pending"
			],
			datasets: [
				{
					data: [
						<jstl:forEach var="iterator" items="${Rejected}">
							<jstl:out value="${iterator[1]}"/> ,
						</jstl:forEach>
						<jstl:forEach var="iterator2" items="${Accepted}">
							<jstl:out value="${iterator2[1]}"/> ,
						</jstl:forEach>
						<jstl:forEach var="iterator3" items="${Pending}">
							<jstl:out value="${iterator3[1]}"/> ,
						</jstl:forEach>
					],
					backgroundColor: [
				          "#f38b4a",
				          "#56d798",
				          "#ff8397",
				          "#6970d5" 
				        ],
				}
			]
		};
		
		
		
		var options = {
			scales : {
				yAxes:[
					{
						ticks : {
							suggestedMin : 0.0,
							suggestedMax : 1.0
						}
					}
				]
			},
			legend : {
				display : false
			}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas8");
		context = canvas.getContext("2d");
		new Chart(context, {
			type: "bar",
			data: data,
			options: options
		});
		
	});
		
</script>




















<%@ page import="java.util.*,com.test.model.EmployeeWork"%>
<html>
<head>
<title>Employee Work Report</title>
</head>
<body>

	<div style="width: 600px; margin: 50px auto; text-align: center;">

		<h2>Employee Work Report</h2>

		<a href="EmployeeWorkServlet?action=form">Add New Entry</a> <br>
		<br>

		<table border="1" cellpadding="5" cellspacing="0"
			style="margin: auto;">
			<tr>
				<th>Work ID</th>
				<th>Employee Name</th>
				<th>City</th>
				<th>Work Date</th>
				<th>Department</th>
				<th>Project</th>
			</tr>

			<%
			List<EmployeeWork> reportList = (List<EmployeeWork>) request.getAttribute("reportList");
			for (EmployeeWork w : reportList) {
			%>
			<tr>
				<td><%=w.getWorkId()%></td>
				<td><%=w.getEmpName()%></td>
				<td><%=w.getCity()%></td>
				<td><%=w.getWorkDate()%></td>
				<td><%=w.getDeptName()%></td>
				<td><%=w.getProjectName()%></td>
			</tr>
			<%
			}
			%>
		</table>

	</div>

</body>
</html>

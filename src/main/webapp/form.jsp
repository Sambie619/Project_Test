<%@ page import="java.util.*,com.test.model.Department,com.test.model.Project" %>
<html>
<head>
    <title>Employee Work Entry</title>
</head>
<body>

<h2>Employee Work Entry</h2>

<form action="EmployeeWorkServlet" method="post">
    <input type="hidden" name="action" value="save">

    <table border="1" cellpadding="5">
        <tr>
            <td>Employee Name</td>
            <td><input type="text" name="empName"></td>
        </tr>
        <tr>
            <td>City</td>
            <td><input type="text" name="city"></td>
        </tr>
        <tr>
            <td>Work Date</td>
            <td><input type="date" name="workDate"></td>
        </tr>
        <tr>
            <td>Department</td>
            <td>
                <select name="deptId">
                    <option value="">Select Department</option>
                    <%
                        List<Department> deptList = (List<Department>)request.getAttribute("deptList");
                        for(Department d : deptList) {
                    %>
                    <option value="<%=d.getDeptId()%>"><%=d.getDeptName()%></option>
                    <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td>Project</td>
            <td>
                <select name="projectId">
                    <option value="">Select Project</option>
                    <%
                        List<Project> projectList = (List<Project>)request.getAttribute("projectList");
                        for(Project p : projectList) {
                    %>
                    <option value="<%=p.getProjectId()%>"><%=p.getProjectName()%></option>
                    <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save">
                <a href="EmployeeWorkServlet?action=report">View Report</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>

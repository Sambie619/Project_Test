package com.test.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.EmployeeWorkDAO;
import com.test.model.Department;
import com.test.model.Project;
import com.test.model.EmployeeWork;

@WebServlet("/EmployeeWorkServlet")
public class EmployeeWorkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    EmployeeWorkDAO dao = new EmployeeWorkDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if(action == null) {
            action = "form";
        }

        if(action.equals("form")) {
            List<Department> deptList = dao.getAllDepartments();
            List<Project> projectList = dao.getAllProjects();

            request.setAttribute("deptList", deptList);
            request.setAttribute("projectList", projectList);

            RequestDispatcher rd = request.getRequestDispatcher("form.jsp");
            rd.forward(request, response);
        }

        else if(action.equals("save")) {
            String empName = request.getParameter("empName");
            String city = request.getParameter("city");
            String workDate = request.getParameter("workDate");
            int deptId = Integer.parseInt(request.getParameter("deptId"));
            int projectId = Integer.parseInt(request.getParameter("projectId"));

            EmployeeWork w = new EmployeeWork(empName, city, workDate, deptId, projectId);
            dao.saveWork(w);

            response.sendRedirect("EmployeeWorkServlet?action=report");
        }

        else if(action.equals("report")) {
            List<EmployeeWork> reportList = dao.getReport();
            request.setAttribute("reportList", reportList);
            RequestDispatcher rd = request.getRequestDispatcher("report.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

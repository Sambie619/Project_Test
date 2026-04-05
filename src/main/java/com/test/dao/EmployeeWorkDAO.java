package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.test.model.Department;
import com.test.model.Project;
import com.test.model.EmployeeWork;
import com.test.util.DBConnection;

public class EmployeeWorkDAO {

    public List<Department> getAllDepartments() {
        List<Department> list = new ArrayList<Department>();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from department");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Department d = new Department();
                d.setDeptId(rs.getInt("dept_id"));
                d.setDeptName(rs.getString("dept_name"));
                list.add(d);
            }
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Project> getAllProjects() {
        List<Project> list = new ArrayList<Project>();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from project");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Project p = new Project();
                p.setProjectId(rs.getInt("project_id"));
                p.setProjectName(rs.getString("project_name"));
                list.add(p);
            }
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int saveWork(EmployeeWork w) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into employee_work(emp_name, city, work_date, dept_id, project_id) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, w.getEmpName());
            ps.setString(2, w.getCity());
            ps.setString(3, w.getWorkDate());
            ps.setInt(4, w.getDeptId());
            ps.setInt(5, w.getProjectId());

            status = ps.executeUpdate();
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public List<EmployeeWork> getReport() {
        List<EmployeeWork> list = new ArrayList<EmployeeWork>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select w.work_id, w.emp_name, w.city, w.work_date, d.dept_name, p.project_name "
                       + "from employee_work w "
                       + "join department d on w.dept_id = d.dept_id "
                       + "join project p on w.project_id = p.project_id "
                       + "order by w.work_id";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                EmployeeWork w = new EmployeeWork(
                    rs.getInt("work_id"),
                    rs.getString("emp_name"),
                    rs.getString("city"),
                    rs.getString("work_date"),
                    rs.getString("dept_name"),
                    rs.getString("project_name")
                );
                list.add(w);
            }
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

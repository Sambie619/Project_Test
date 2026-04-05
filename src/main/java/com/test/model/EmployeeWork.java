package com.test.model;

public class EmployeeWork {
    private int workId;
    private String empName;
    private String city;
    private String workDate;
    private int deptId;
    private int projectId;
    private String deptName;
    private String projectName;

    public EmployeeWork() {
    }

    public EmployeeWork(String empName, String city, String workDate, int deptId, int projectId) {
        this.empName = empName;
        this.city = city;
        this.workDate = workDate;
        this.deptId = deptId;
        this.projectId = projectId;
    }

    public EmployeeWork(int workId, String empName, String city, String workDate, String deptName, String projectName) {
        this.workId = workId;
        this.empName = empName;
        this.city = city;
        this.workDate = workDate;
        this.deptName = deptName;
        this.projectName = projectName;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}

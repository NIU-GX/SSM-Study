package com.example.bean;

public class Department {
    private Integer id;

    private String departmentname;

    public Department() {
    }
    // 为了插入数据方便提供有参构造器，如果有有参构造器，必须提供无参构造器
    public Department(Integer id, String departmentname) {
        this.id = id;
        this.departmentname = departmentname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname == null ? null : departmentname.trim();
    }
}
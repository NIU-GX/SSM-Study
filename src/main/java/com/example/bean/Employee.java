package com.example.bean;

public class Employee {
    private Integer id;

    private String lastname;

    private String email;

    private Integer gender;

    private Integer dId;

    // 希望查询员工的时候部门信息也查询好
    private Department department;

    public Employee() {
    }

    public Employee(Integer id, String lastname, String email, Integer gender, Integer dId) {
        this.id = id;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.dId = dId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname == null ? null : lastname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}
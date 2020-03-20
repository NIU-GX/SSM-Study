package com.example.service;

import com.example.bean.Employee;
import com.example.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 查询所有员工
     * @return
     */
    public List<Employee> getAll() {
        List<Employee> employees = employeeMapper.selectByExampleWithDept(null);
        return employees;
    }
}

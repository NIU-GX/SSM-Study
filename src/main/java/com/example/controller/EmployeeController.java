package com.example.controller;

import com.example.bean.Employee;
import com.example.dao.EmployeeMapper;
import com.example.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 牛高翔
 * @date 2020/3/20 15:31
 *
 * 处理员工crud 请求
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    /**
     * 查询所有员工（分页查询）
     * @return
     */

    @RequestMapping("/emps")
    @ResponseBody
    public PageInfo getEmpsWithJson(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model) {
        // 引入pagehelper 分页查询,  传入页码和每页的大小
        PageHelper.startPage(pn,5);
        // startPage紧跟的查询就是分页查询
        List<Employee> all = employeeService.getAll();

        // 使用pageInfo包装查询结果,只需要将pageInfo交给页面
        // 分装了详细的分页信息，包括我们查询的结果，连续显示5页 navigatePage 5
        PageInfo pageInfo = new PageInfo(all,5);
        return pageInfo;
    }

    @GetMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model) {
        // 引入pagehelper 分页查询,  传入页码和每页的大小
        PageHelper.startPage(pn,5);
        // startPage紧跟的查询就是分页查询
        List<Employee> all = employeeService.getAll();

        // 使用pageInfo包装查询结果,只需要将pageInfo交给页面
        // 分装了详细的分页信息，包括我们查询的结果，连续显示5页 navigatePage 5
        PageInfo pageInfo = new PageInfo(all,5);
        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }
}

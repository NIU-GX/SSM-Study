package com.example.test;

import com.example.bean.Employee;
import com.example.dao.DepartmentMapper;
import com.example.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author 牛高翔
 * @date 2020/3/20 12:59
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MapperTest {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    SqlSession session;

    @Test
    public void mapperTest(){
        System.out.println(employeeMapper);
        System.out.println(departmentMapper);

        // 1.插入几个部门
//        departmentMapper.insertSelective(new Department(1,"AA"));
//        departmentMapper.insertSelective(new Department(null,"BB"));

        // 2.生成员工数据,插入
//        employeeMapper.insertSelective(new Employee(1,"lbw","lbw@QQ.com",1,1));

        // 3. 插入多个员工
        //  这样会连接1000次数据库，
//        for (int i = 0; i < 1000; i++) {
//            employeeMapper.insertSelective()
//        }
        
        //  使用批量操作
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString().substring(0, 5);
            mapper.insertSelective(new Employee(null,uuid,uuid + "@qq.com",1,1));
        }

    }
}

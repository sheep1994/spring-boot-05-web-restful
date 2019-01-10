package com.talent.controller;

import com.talent.bean.Employee;
import com.talent.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Map;

/**
 * @author guobing
 * @Title: EmployeeController
 * @ProjectName spring-boot-02-config
 * @Description: TODO
 * @date 2018/12/29下午1:45
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 查询所有员工
     * @return
     */
    @GetMapping("/emps")
    public String list(Map<String, Object> map) {
        Collection<Employee> emps = employeeDao.getAll();
        map.put("emps", emps);
        return "emp/list";
    }
}

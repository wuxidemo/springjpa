package com.yf.japtemp.controller;

import com.yf.japtemp.dao.EmployeeRepository;
import com.yf.japtemp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;




    @RequestMapping("/queryall")
    @ResponseBody
    public List<Employee> queryAll(){
        List<Employee> list = new ArrayList<Employee>();
        list = employeeRepository.findAll();
        return list;
    }

    @RequestMapping("/querybyid")
    @ResponseBody
    public Employee queryById(@RequestParam String id){
        Employee employee = employeeRepository.findById(id).get();
        return employee;
    }

    @RequestMapping("/deletebyid")
    public void deleteById(@RequestParam String id){
        employeeRepository.deleteById(id);
    }

    @RequestMapping("/insert")
    public void insert(@RequestParam String id,@RequestParam String name,@RequestParam String gender,@RequestParam String age){
        Employee employee = new Employee();
        employee.setAge(Integer.valueOf(age));
        employee.setId(id);
        employee.setGender(gender);
        employee.setName(name);
        employeeRepository.save(employee);

    }

    @RequestMapping("/update")
    public void update(@RequestParam String id,@RequestParam String name,@RequestParam String gender,@RequestParam String age){
        Employee employee = employeeRepository.findById(id).get();
        employee.setAge(Integer.valueOf(age));
        employee.setGender(gender);
        employee.setName(name);
        employeeRepository.save(employee);

    }

}

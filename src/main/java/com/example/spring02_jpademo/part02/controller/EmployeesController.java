package com.example.spring02_jpademo.part02.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.example.spring02_jpademo.part02.service.EmployeesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor //스프링컨테이너 안에 저장된 객체 
public class EmployeesController {

    private final EmployeesService employeesService;
    
    // @Autowired
    // private EmployeesService employeesService;

    // http://localhost:8090/api/employees/with-department-jpql
    // JPQL 방식
    @GetMapping("/with-department-jpql")
    public List<Map<String, Object>> getEmployeesWithDepartmentJPQL() {
        return employeesService.getAllEmployeesWithDepartmentJPQL();
    }

    
 // http://localhost:8090/api/employees/with-department-native
    //  Native SQL 방식
    @GetMapping("/with-department-native")
    public List<Map<String, Object>> getEmployeesWithDepartmentNative() {
        return employeesService.getAllEmployeesWithDepartmentNative();
    }
}

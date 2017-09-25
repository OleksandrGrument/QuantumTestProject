package test.quantum.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import test.quantum.configuration.AppStaticVariableSettings;
import test.quantum.domain.Employee;
import test.quantum.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeViewController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView employeeList() {

        ModelAndView employeeListView = new ModelAndView("employee_list");

        List<Employee> employees = employeeService.getAllEmployees();

        employeeListView.addObject("employees" , employees);

        return employeeListView;
    }
}


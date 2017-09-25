package test.quantum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import test.quantum.configuration.AppStaticVariableSettings;
import test.quantum.domain.Employee;
import test.quantum.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeManagingController {

    @Autowired
    private EmployeeService employeeService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/set-employee-count", method = RequestMethod.POST)
    public void setCountEmployees(@RequestParam("count_employees") Integer countEmployees){
        AppStaticVariableSettings.setCountGenerateEmployee(countEmployees);
    }


    @RequestMapping(value = "/get-employee/{is_all_employee_return}/{name_surname}/{city}/{salary}/{position}/", method = RequestMethod.GET)
    public List<Employee> setCountEmployees(@PathVariable("is_all_employee_return") Boolean isAllEmployeeReturn,
                                            @PathVariable("name_surname") String nameSurname ,
                                            @PathVariable("city") String city,
                                            @PathVariable("salary") Integer salary,
                                            @PathVariable("position") String position){

        System.out.println(isAllEmployeeReturn + nameSurname + city + salary + position);

        List<Employee> employeesToReturn =  employeeService.getAllEmployees();

        if(!isAllEmployeeReturn){

            // Another way is to get employees by HQL query

           /* List<Employee> employeesToReturn = employeeService.findEmployeeByParams(nameSurname , city , salary , position);*/

            employeesToReturn = employeesToReturn.stream()
                    .filter((emp) -> emp.getNameSurname().contains(nameSurname) ||
                            emp.getCity().contains(city) ||
                            emp.getPosition().contains(position) ||
                            emp.getSalary() == salary.intValue())
                    .collect(Collectors.toList());

        }
        return employeesToReturn;
    }





}

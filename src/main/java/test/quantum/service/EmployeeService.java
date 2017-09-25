package test.quantum.service;


import test.quantum.domain.Employee;

import java.util.List;

public interface EmployeeService {

    void addNewEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    void saveCollection(List <Employee> employees);

    void deleteAllEntity ();

    List findEmployeeByParams(String nameSurname , String city , int salary , String position);

}

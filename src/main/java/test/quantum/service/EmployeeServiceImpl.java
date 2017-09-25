package test.quantum.service;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.quantum.dao.EmployeeDao;
import test.quantum.domain.Employee;

import java.util.List;

@Transactional
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void addNewEmployee(Employee employee) {
        employeeDao.create(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDao.read(id);
    }

    @Override
    public void saveCollection(List<Employee> employees) {
        employeeDao.saveCollection(employees);
    }

    @Override
    public void deleteAllEntity() {
        employeeDao.deleteAllEntity();
    }

    @Override
    public List<Employee> findEmployeeByParams(String nameSurname, String city, int salary, String position) {
        return employeeDao.findEmployeeBySpecialParams(nameSurname,city,salary,position);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDao.delete(employee);
    }

}


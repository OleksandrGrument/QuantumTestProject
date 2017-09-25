package test.quantum.dao;




import test.quantum.domain.Employee;

import java.util.List;

public interface EmployeeDao {

    Long create(Employee employee);

    Employee read(Long id);

    void update(Employee employee);

    void delete(Employee employee);

    List<Employee> findAll();

    void deleteAllEntity ();

    void saveCollection(List <Employee> employees);

    List findEmployeeBySpecialParams(String nameSurname, String city, int salary, String position);

}

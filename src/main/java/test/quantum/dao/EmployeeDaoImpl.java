package test.quantum.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import test.quantum.domain.Employee;

import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(employee);
        return id;
    }

    @Override
    public Employee read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void update(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
    }

    @Override
    public void delete(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(employee);
    }

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Employee");
        return query.list();
    }

    @Override
    public void deleteAllEntity() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Employee");
        query.executeUpdate();
    }

    @Override
    public void saveCollection(List<Employee> employees) {
        Session session = sessionFactory.getCurrentSession();
        for (Employee employee : employees){
            session.save(employee);
        }
    }

    @Override
    public List<Employee> findEmployeeBySpecialParams(String nameSurname, String city, int salary, String position) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("SELECT DISTINCT emp FROM Employee emp " +
                "WHERE emp.nameSurname LIKE :nameSurname " +
                "OR emp.city LIKE :city " +
                "OR emp.salary = :salary " +
                "OR emp.position LIKE :position")
                .setParameter("nameSurname" , "%" + nameSurname + "%")
                .setParameter("city", city)
                .setParameter("salary" , salary)
                .setParameter("position" , position);

        return query.list();
    }


}
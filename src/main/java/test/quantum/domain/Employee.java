package test.quantum.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    public Employee() {
    }

    public Employee(String nameSurname, String city, Integer salary, String position) {
        this.nameSurname = nameSurname;
        this.city = city;
        this.salary = salary;
        this.position = position;
    }

    @Id
    @GeneratedValue(generator = "increment2")
    @GenericGenerator(name = "increment2", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "name_surname")
    private String nameSurname;

    @Column(name = "city")
    private String city;

    @Column(name = "salary")
    private Integer salary;

    @Column(name="position")
    private String position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", nameSurname='" + nameSurname + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }
}

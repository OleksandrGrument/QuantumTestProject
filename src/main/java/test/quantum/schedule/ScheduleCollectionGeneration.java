package test.quantum.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import test.quantum.configuration.AppStaticVariableSettings;
import test.quantum.domain.Employee;
import test.quantum.service.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ScheduleCollectionGeneration {

    @Autowired
    private EmployeeService employeeService;

    private final static String[] POSITIONS = {"Manager", "Developer", "HR", "Designer", "PR"};

    private final static String[] CITY = {"Kyiv", "Odessa", "Lviv", "Amsterdam", "Baku", "New-York", "Elley", "Krakow", "Zhashkow"};

    private final static String[] SURNAMES = {"Abell", "Ackworth", "Adams", "Addicock",
            "Alban", "Aldebourne", "Alfray", "Alicock",
            "Allard", "Allen", "Allington", "Amberden",};

    private final static String[] MALE_NAMES = {"Aaron", "Enlightened", "Abbott", "Abel",
            "Breath", "Abner", "Light", "Abraham",
            "Exalted", "Father", "Adam", "Earth", "Addison", "Adam"};

    private final static String[] FEMALE_NAMES = {"Emma", "Olivia", "Sophia", "Ava",
            "Isabella", "Mia", "Abigail", "Emily",
            "Charlotte", "Harper", "Madison", "Amelia"};


    private Random random = new Random();

    // minutes seconds
    @Scheduled(fixedDelay = 60 * 60 * 1000)
    public void generateEmployeeCollection() {

        long totalEmployeeCount = AppStaticVariableSettings.getCountGenerateEmployee();

        List<String> surnames = Stream.of(SURNAMES).collect(Collectors.toList());
        List<Employee> employees = new ArrayList<>();


        boolean isWorking = true;

       do {

            for (int sex = 0; sex < 5; sex++) {

                //check is all conditions is done
                if (surnames.size() == 0 || employees.size() == totalEmployeeCount) {
                    isWorking = false;
                    break;
                }

                // get surname
                int randomSurnameIndex = random.nextInt(surnames.size());
                String currentSurname = surnames.get(randomSurnameIndex);

                long surnamesCount = employees.stream().filter((emp) -> emp.getNameSurname().contains(currentSurname)).count();
                if (surnamesCount == 2) {
                    surnames.remove(currentSurname);
                    continue;
                }

                //get name
                int randomNameIndex;
                String currentName = "";
                if (sex % 2 == 0) {
                    randomNameIndex = random.nextInt(MALE_NAMES.length);
                    currentName = MALE_NAMES[randomNameIndex];
                } else {
                    randomNameIndex = random.nextInt(FEMALE_NAMES.length);
                    currentName = FEMALE_NAMES[randomNameIndex];
                }

                String nameSurname = currentName + " " + currentSurname;

                boolean isNameSurnameDuplication = employees.stream().anyMatch((emp) -> emp.getNameSurname().equals(nameSurname));
                if (isNameSurnameDuplication) continue;

                //Generate full new Employee
                Employee employee = new Employee();
                employee.setNameSurname(nameSurname);
                employee.setCity(CITY[random.nextInt(CITY.length)]);
                employee.setPosition(POSITIONS[random.nextInt(POSITIONS.length)]);
                employee.setSalary(random.nextInt(15000 - 5000 + 1) + 5000);

                employees.add(employee);

            }
        } while (isWorking);

        for (Employee emp : employees) {
            System.out.println(emp.getNameSurname());
        }

        employeeService.deleteAllEntity();
        employeeService.saveCollection(employees);

    }

}

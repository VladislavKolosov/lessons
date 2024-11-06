package employeemanager;

import employeemanager.position.Position;
import employeemanager.position.development.JuniorDeveloper;
import employeemanager.position.development.MiddleDeveloper;
import employeemanager.position.development.SeniorDeveloper;
import employeemanager.position.development.TeamLead;
import employeemanager.position.hr.HeadOfHR;
import employeemanager.position.hr.Manager;
import employeemanager.position.hr.SeniorManager;
import employeemanager.position.marketing.HeadOfMarketing;
import employeemanager.position.marketing.Specialist;
import employeemanager.position.marketing.Trainee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileManager {
    public static List<Employee> employees = new ArrayList<>(){{
        add(new Employee("Vladislav","Kolosov",new JuniorDeveloper(),BigDecimal.valueOf(400)));
    }};

    public static Map<String, Position> position = new HashMap<>() {{
        put("junior developer", new JuniorDeveloper());
        put("middle developer", new MiddleDeveloper());
        put("senior developer", new SeniorDeveloper());
        put("team lead", new TeamLead());
        put("head of hr", new HeadOfHR());
        put("manager", new Manager());
        put("senior manager", new SeniorManager());
        put("head of marketing", new HeadOfMarketing());
        put("specialist", new Specialist());
        put("trainee", new Trainee());
    }};

    public static void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public static void removeEmployee(Employee employee) {
        employees.remove(employee);
    }
}

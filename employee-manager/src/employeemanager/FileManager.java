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

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileManager {
    public static List<Employee> employees = readEmployees();

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

    public static List<Employee> readEmployees() {
        Path path = Path.of("employees.data");
        if (!Files.exists(path)) {
            createDataFile(path);
            return new ArrayList<>();
        }
        
        List<Employee> employees;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            employees = (List<Employee>) inputStream.readObject();
            Employee.setCountId(employees.size());
        }catch (EOFException e) {
            return new ArrayList<>();
        }catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }


    private static void createDataFile(Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при создании файла", e);
        }
    }



    public static void saveEmployees() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employees.data"))) {
            outputStream.writeObject(employees);
            Path path = Paths.get("employees.data");
            System.out.println(Files.size(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

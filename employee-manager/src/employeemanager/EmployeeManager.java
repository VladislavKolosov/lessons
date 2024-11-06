package employeemanager;

import employeemanager.position.Position;
import employeemanager.position.development.JuniorDeveloper;
import employeemanager.position.development.TeamLead;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Scanner;


public class EmployeeManager {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();

        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;

        while (!isExit) {

            System.out.println("1. Распечатать сотрудников.");
            System.out.println("2. Добавить сотрудника");
            System.out.println("3. Уволить сотрудника");
            System.out.println("4. Изменение департамента");
            System.out.println("5. Выйти.");

            switch (scanner.nextInt()) {
                case 1:
                    employeeManager.printAllEmployee(FileManager.employees);
                    break;
                case 2:
                    FileManager.addEmployee(employeeManager.createEmployee(FileManager.employees));
                    break;
                case 3:
                    employeeManager.printAllEmployee(FileManager.employees);
                    if (!FileManager.employees.isEmpty()){
                        FileManager.removeEmployee(employeeManager.removeEmployee(FileManager.employees, scanner.nextInt()));
                    }
                    break;
                case 4:
                    employeeManager.printAllEmployee(FileManager.employees);
                    if (!FileManager.employees.isEmpty()) {
                        DepartmentManager.changeDepartment(employeeManager.changeDepartment(FileManager.employees, scanner.nextInt()));
                    }
                    break;
                case 5:
                    isExit = true;
                    break;
            }
        }


    }

    public Employee createEmployee(List<Employee> employees) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя работника");
        String name = sc.nextLine();

        System.out.println("Введите фамилию работника");
        String surname = sc.nextLine();

        System.out.println("Введите позицию");
        Position position = FileManager.position.get(sc.nextLine().toLowerCase());

        System.out.println("Введите зарплату");
        BigDecimal salary = sc.nextBigDecimal();

        return new Employee(name, surname, position, salary);
    }

    public Employee removeEmployee(List<Employee> employees, int employeeNumber) {
        return employees.get(--employeeNumber);
    }

    public Employee changeDepartment(List<Employee> employees, int employeeNumber) {
        return employees.get(--employeeNumber);
    }


    public void printAllEmployee(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("Сотрудников нет");
            return;
        }
        System.out.println("Список работающих сотрудников");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        System.out.println("__________");
    }
}
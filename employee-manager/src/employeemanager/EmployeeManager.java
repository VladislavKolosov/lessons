package employeemanager;

import employeemanager.position.Position;
import employeemanager.position.development.JuniorDeveloper;
import employeemanager.position.development.TeamLead;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EmployeeManager {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        FileManager fileManager = new FileManager();
        Accounting accounting = new Accounting();
        DepartmentManager departmentManager = new DepartmentManager(fileManager,accounting);

        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;

        while (!isExit) {

            System.out.println("1. Распечатать сотрудников.");
            System.out.println("2. Добавить сотрудника");
            System.out.println("3. Уволить сотрудника");
            System.out.println("4. Изменение департамента");
            System.out.println("5. Изменение зарплаты");
            System.out.println("6. Повысить должность");
            System.out.println("7. Понизить должность");
            System.out.println("8. Выйти.");

            switch (scanner.nextInt()) {
                case 1:
                    employeeManager.printAllEmployee(fileManager.getEmployees());
                    break;
                case 2:
                    fileManager.addEmployee(employeeManager.createEmployee(fileManager.getEmployees()));
                    fileManager.saveEmployees();
                    break;
                case 3:
                    employeeManager.printAllEmployee(fileManager.getEmployees());
                    if (!fileManager.getEmployees().isEmpty()) {
                        fileManager.removeEmployee(employeeManager.selectEmployee(fileManager.getEmployees(), scanner.nextInt()));
                        fileManager.saveEmployees();
                    }
                    break;
                case 4:
                    employeeManager.printAllEmployee(fileManager.getEmployees());
                    if (!fileManager.getEmployees().isEmpty()) {
                        departmentManager.changeDepartment(employeeManager.selectEmployee(fileManager.getEmployees(), scanner.nextInt()), scanner);
                        fileManager.saveEmployees();
                    }
                    break;
                case 5:
                    employeeManager.printAllEmployee(fileManager.getEmployees());
                    if (!fileManager.getEmployees().isEmpty()) {
                        Employee employee = employeeManager.selectEmployee(fileManager.getEmployees(), scanner.nextInt());
                        System.out.println("Введите новую зарплату");
                        accounting.changeSalary(employee, scanner.nextBigDecimal());

                        fileManager.saveEmployees();
                    }
                    break;

                case 6:
                    employeeManager.printAllEmployee(fileManager.getEmployees());
                    if (!fileManager.getEmployees().isEmpty()) {
                        departmentManager.raisePosition(employeeManager.selectEmployee(fileManager.getEmployees(), scanner.nextInt()), scanner);
                        fileManager.saveEmployees();
                    }
                    break;
                case 7:
                    employeeManager.printAllEmployee(fileManager.getEmployees());
                    if (!fileManager.getEmployees().isEmpty()) {
                        departmentManager.lowerPosition(employeeManager.selectEmployee(fileManager.getEmployees(), scanner.nextInt()), scanner);

                        fileManager.saveEmployees();
                    }
                    break;
                case 8:
                    isExit = true;
                    break;
                default:
                    System.out.println("Выбран неверный пункт");
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
        Position position = FileManager.getPosition().get(sc.nextLine().toLowerCase());

        System.out.println("Введите зарплату");
        BigDecimal salary = sc.nextBigDecimal();

        return new Employee(name, surname, position, salary);
    }

    public Employee selectEmployee(List<Employee> employees, int employeeNumber) {
        return employees.get(--employeeNumber);
    }

    public void printAllEmployee(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("Сотрудников нет");
            return;
        }
        System.out.println("Список работающих сотрудников");
        for (int i = 1; i <= employees.size(); i++) {
            System.out.println(i + ". " + employees.get(i - 1));
        }
        System.out.println("__________");
    }
}
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
        FileManager.readEmployees();

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
                    employeeManager.printAllEmployee(FileManager.employees);
                    break;
                case 2:
                    FileManager.addEmployee(employeeManager.createEmployee(FileManager.employees));
                    FileManager.saveEmployees();
                    break;
                case 3:
                    employeeManager.printAllEmployee(FileManager.employees);
                    if (!FileManager.employees.isEmpty()) {
                        FileManager.removeEmployee(employeeManager.selectEmployee(FileManager.employees, scanner.nextInt()));
                        FileManager.saveEmployees();
                    }
                    break;
                case 4:
                    employeeManager.printAllEmployee(FileManager.employees);
                    if (!FileManager.employees.isEmpty()) {
                        DepartmentManager.changeDepartment(employeeManager.selectEmployee(FileManager.employees, scanner.nextInt()), scanner);
                        FileManager.saveEmployees();
                    }
                    break;
                case 5:
                    employeeManager.printAllEmployee(FileManager.employees);
                    if (!FileManager.employees.isEmpty()) {
                        Employee employee = employeeManager.selectEmployee(FileManager.employees, scanner.nextInt());
                        System.out.println("Введите новую зарплату");
                        Accounting.changeSalary(employee, scanner.nextBigDecimal());

                        FileManager.saveEmployees();
                    }
                    break;

                case 6:
                    employeeManager.printAllEmployee(FileManager.employees);
                    if (!FileManager.employees.isEmpty()) {
                        DepartmentManager.raisePosition(employeeManager.selectEmployee(FileManager.employees, scanner.nextInt()), scanner);

                        FileManager.saveEmployees();
                    }
                    break;
                case 7:
                    employeeManager.printAllEmployee(FileManager.employees);
                    if (!FileManager.employees.isEmpty()) {
                        DepartmentManager.lowerPosition(employeeManager.selectEmployee(FileManager.employees, scanner.nextInt()), scanner);

                        FileManager.saveEmployees();
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
        Position position = FileManager.position.get(sc.nextLine().toLowerCase());

        System.out.println("Введите зарплату");
        BigDecimal salary = sc.nextBigDecimal();

        return new Employee(name, surname, position, salary);
    }

    /*public Employee removeEmployee(List<Employee> employees, int employeeNumber) {
        return employees.get(--employeeNumber);
    }

    public Employee changeDepartment(List<Employee> employees, int employeeNumber) {
        return employees.get(--employeeNumber);
    }
    public Employee changeSalary(List<Employee> employees, int employeeNumber){
        return employees.get(--employeeNumber);
    }*/
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
            System.out.println(i + ". " + employees.get(i-1));
        }
        System.out.println("__________");
    }
}
package employeemanager;

import employeemanager.position.Position;
import employeemanager.position.development.JuniorDeveloper;
import employeemanager.position.development.TeamLead;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;


public class EmployeeManager {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        FileManager fileManager = new FileManager();
        Accounting accounting = new Accounting();
        DepartmentManager departmentManager = new DepartmentManager(fileManager, accounting);

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
            System.out.println("8. Групировка по отделам");////////////////
            System.out.println("9. Сортировать список по зарплате");
            System.out.println("10. Начальники отделов");
            System.out.println("11. Выйти.");

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
                    if (fileManager.getEmployees().isEmpty()) {
                        System.out.println("Список пуст");
                        break;
                    }
                    employeeManager.printDepartmentWithEmployee(employeeManager.groupByDepartment(fileManager.getEmployees()));
                    break;

                case 9:
                    if (fileManager.getEmployees().isEmpty()) {
                        System.out.println("Список пуст");
                        break;
                    }
                    employeeManager.sortedBySalary(employeeManager.groupByDepartment(fileManager.getEmployees()));
                    break;

                case 10:
                    if (fileManager.getEmployees().isEmpty()) {
                        System.out.println("Список пуст");
                        break;
                    }
                    employeeManager.filterByHighestSalary(employeeManager.groupByDepartment(fileManager.getEmployees()));

                    break;

                case 11:
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

    public Map<Department, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<Department, List<Employee>> departments =
                employees.stream().collect(Collectors.groupingBy(el -> el.getPosition().getDepartment()));

        return departments;
    }


    public void sortedBySalary(Map<Department, List<Employee>> departments) {
        for (Map.Entry<Department, List<Employee>> entry : departments.entrySet()) {
            List<Employee> employees = entry.getValue()
                    .stream()
                    .sorted((empl1,empl2) ->empl2.getSalary().compareTo(empl1.getSalary()))
                    .toList();
            departments.put(entry.getKey(), employees);
        }
        printDepartmentWithEmployee(departments);
    }

    public void filterByHighestSalary(Map<Department, List<Employee>> departments) {
        for (Map.Entry<Department, List<Employee>> entry : departments.entrySet()) {
            List<Employee> employees = entry.getValue();
            employees.sort((emp1, emp2) -> emp2.getPosition().getMinSalary().compareTo(emp1.getPosition().getMinSalary()));
            Position position = employees.get(0).getPosition();

            employees = employees.stream()
                    .filter(employee -> employee.getPosition().getMinSalary().equals(position.getMinSalary()))
                    .toList();

            departments.put(entry.getKey(), employees);
        }
        printDepartmentWithEmployee(departments);
    }

    public void printAllEmployee(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("Сотрудников нет");
            return;
        }
        System.out.println("Список сотрудников");
        for (int i = 1; i <= employees.size(); i++) {
            System.out.println(i + ". " + employees.get(i - 1));
        }
        System.out.println("__________");
    }

    public void printDepartmentWithEmployee(Map<Department, List<Employee>> departments) {
        departments.entrySet().stream().forEach(entry -> {
            System.out.println("Department: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        });
    }
}
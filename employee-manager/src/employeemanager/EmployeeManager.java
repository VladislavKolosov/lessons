package employeemanager;


import employeemanager.position.development.JuniorDeveloper;
import employeemanager.position.development.TeamLead;
import employeemanager.position.hr.HeadOfHR;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        List<Employee> employees = new ArrayList<>();
        employeeManager.createEmployee(employees);

        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;

        while (!isExit) {
            System.out.println("1. Распечатать сотрудников.");
            System.out.println("2. Выйти.");

            switch (scanner.nextInt()) {
                case 1:
                    employeeManager.printAllEmployee(employees);
                    break;
                case 2:
                    isExit = true;
                    break;
            }
        }


    }

    public void createEmployee(List<Employee> employees) {
        employees.add(new Employee(1, "Vlad", "Kolosov", new JuniorDeveloper(),
                LocalDate.of(2024, Month.APRIL, 10), BigDecimal.valueOf(600), LocalDate.of(2024, Month.APRIL, 10)));

        employees.add(new Employee(2,"Viktor","Klimovich", new HeadOfHR(),
                LocalDate.of(2023, Month.DECEMBER,5),BigDecimal.valueOf(850), LocalDate.of(2023, Month.DECEMBER,5)));

        employees.add(new Employee(2,"Robert","Tah", new TeamLead(),
                LocalDate.of(2022, Month.JANUARY,23),BigDecimal.valueOf(3500), LocalDate.of(2024, Month.JANUARY,5)));

    }

    public void printAllEmployee(List<Employee> employees) {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
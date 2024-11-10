package employeemanager;

import employeemanager.position.Position;

import java.time.LocalDate;
import java.util.*;


public class DepartmentManager {
    public static void changeDepartment(Employee employee, Scanner scanner) {
        List<Department> transferDepartments = transferDepartments(employee);

        int departmentChoice = selectOption(transferDepartments, scanner);

        List<Position> selectPosition = searchPosition(transferDepartments, departmentChoice);

        int numberOfPosition = selectOption(selectPosition, scanner);

        employee.setPosition(selectPosition.get(numberOfPosition));
        employee.setSalary(employee.getPosition().getMinSalary());
        employee.setLastSalaryChange(LocalDate.now());
    }

    private static List<Department> transferDepartments(Employee employee) {
        List<Department> transferDepartments = new ArrayList<>();
        for (Department dep : Department.values()) {
            if (!employee.getPosition().getDepartment().equals(dep)) {
                transferDepartments.add(dep);
            }
        }
        return transferDepartments;
    }

    private static List<Position> searchPosition(List<Department> transferDepartments, int departmentChoice) {
        List<Position> selectPosition = new ArrayList<>();
        for (Position position : FileManager.position.values()) {
            if (position.getDepartment().equals(transferDepartments.get(departmentChoice))) {
                selectPosition.add(position);
            }
        }
        return selectPosition;
    }

    private static <T> int selectOption(List<T> selectOption, Scanner scanner) {
        System.out.println("Выберите: ");
        for (int i = 0; i < selectOption.size(); i++) {
            System.out.println((i + 1) + ". " + selectOption.get(i).toString());
        }
        int select = scanner.nextInt() - 1;
        if (select >= selectOption.size() && select > 0) {
            System.out.println("Выбран неверный пункт");
            return selectOption(selectOption, scanner);
        }
        return select;
    }

    /*public static void RP(Employee employee, Scanner scanner) {
        Optional<Position> positions = FileManager.position.values()
                .stream()
                .filter(position -> position.getDepartment().equals(employee.getPosition().getDepartment())
                        && position.getMinSalary().compareTo(employee.getPosition().getMinSalary()) > 0)
                .min(Comparator.comparing(Position::getMinSalary));

        if (positions.isEmpty()) {
            System.out.println("Повышать некуда");
            return;
        }
        System.out.println("Повышение, новая позиция - " + positions.get().getName());
        employee.setPosition(positions.get());
        System.out.print("Введите зарплату на новой позиции: ");
        Accounting.changeSalary(employee, scanner.nextBigDecimal());
    }*/

    public static void lowerPosition(Employee employee, Scanner scanner) {
        Department department = employee.getPosition().getDepartment();

        List<Position> positions = selectPositions(employee, department, false);

        if (positions.isEmpty()) {
            System.out.println("Понижать некуда, сотрудник уволены");
            FileManager.removeEmployee(employee);
            return;
        }

        Position position = updatePosition(positions, false);

        System.out.println("Понижение, новая позиция - " + position.getName());
        employee.setPosition(position);
        System.out.print("Введите зарплату на новой позиции: ");
        Accounting.changeSalary(employee, scanner.nextBigDecimal());
    }

    public static void raisePosition(Employee employee, Scanner scanner) {
        Department department = employee.getPosition().getDepartment();

        List<Position> positions = selectPositions(employee, department, true);

        if (positions.isEmpty()) {
            System.out.println("Повышать некуда, сотрудник занимает самую высокую позицию");
            return;
        }
        Position position = updatePosition(positions, true);

        System.out.println("Повышение, новая позиция - " + position.getName());
        employee.setPosition(position);
        System.out.print("Введите зарплату на новой позиции: ");
        Accounting.changeSalary(employee, scanner.nextBigDecimal());
    }

    private static Position updatePosition(List<Position> positions, Boolean isRaise) {
        Position position = positions.get(0);
        for (Position pos : positions) {
            boolean condition = isRaise
                    ? pos.getMinSalary().compareTo(position.getMinSalary()) < 0
                    : pos.getMinSalary().compareTo(position.getMinSalary()) > 0;
            if (condition) {
                position = pos;
            }
        }
        return position;
    }

    private static List<Position> selectPositions(Employee employee, Department department, boolean isRaise) {
        List<Position> allPosition = new ArrayList<>();
        for (Position position : FileManager.position.values()) {
            boolean condition = isRaise
                    ? position.getMinSalary().compareTo(employee.getPosition().getMinSalary()) > 0
                    : position.getMinSalary().compareTo(employee.getPosition().getMinSalary()) < 0;

            if (position.getDepartment().equals(department) && condition) {
                allPosition.add(position);
            }
        }
        return allPosition;
    }
}
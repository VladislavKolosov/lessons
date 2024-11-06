package employeemanager;

import employeemanager.position.Position;

import java.time.LocalDate;
import java.util.*;



public class DepartmentManager {
    public static void changeDepartment(Employee employee) {
        //получаем все департаменты
        List<Department> transferDepartments = new ArrayList<>();
        for (Department dep : Department.values()) {
            if (!employee.getPosition().getDepartment().equals(dep)) {
                transferDepartments.add(dep);
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("В какой департамент хотите перейти?");
        for (int i = 0; i < transferDepartments.size(); i++) {
            System.out.println(i + 1 + ". " + transferDepartments.get(i));
        }
        int departmentChoice = scanner.nextInt() - 1;

        //получаем все позиции в департаменте
        List<Position> selectPosition = new ArrayList<>();
        for (Position position : FileManager.position.values()) {
            if (position.getDepartment().equals(transferDepartments.get(departmentChoice))) {
                selectPosition.add(position);
            }
        }

        //выбираем позицию
        System.out.println("Выберите специальность: ");
        for (int i = 0; i < selectPosition.size(); i++) {
            System.out.println((i + 1) + ". " + selectPosition.get(i).getName());
        }
        int numberOfPosition = scanner.nextInt() - 1;

        employee.setPosition(selectPosition.get(numberOfPosition));
        employee.setSalary(employee.getPosition().getMinSalary());
        employee.setLastSalaryChange(LocalDate.now());
    }
}

package employeemanager;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Accounting {
    public void changeSalary(Employee employee, BigDecimal salary) {
        if (employee.getPosition().getMinSalary().compareTo(salary) <= 0 &&
                employee.getPosition().getMaxSalary().compareTo(salary) >= 0) {

            employee.setSalary(salary);
            employee.setLastSalaryChange(LocalDate.now());
        } else {
            System.out.println("Зарплата выходит за рамки разрешенной.\n" + " минимальная: " + employee.getPosition().getMinSalary() +
                    " максимальная: " + employee.getPosition().getMaxSalary());
        }
    }
}

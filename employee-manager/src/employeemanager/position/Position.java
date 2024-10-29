package employeemanager.position;

import employeemanager.Department;

import java.math.BigDecimal;

public interface Position {
    String getName();
    Department getDepartment();
    BigDecimal getMinSalary();
    BigDecimal getMaxSalary();
}

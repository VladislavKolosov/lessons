package employeemanager.position;

import employeemanager.Department;

import java.io.Serializable;
import java.math.BigDecimal;

public interface Position extends Serializable {
    String getName();
    Department getDepartment();
    BigDecimal getMinSalary();
    BigDecimal getMaxSalary();
}

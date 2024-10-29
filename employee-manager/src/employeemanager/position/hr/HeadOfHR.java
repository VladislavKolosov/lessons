package employeemanager.position.hr;

import employeemanager.Department;
import employeemanager.position.Position;

import java.math.BigDecimal;

public class HeadOfHR implements Position {
    @Override
    public String getName() {
        return "HeadOfHR";
    }

    @Override
    public Department getDepartment() {
        return Department.HR;
    }

    @Override
    public BigDecimal getMinSalary() {
        return BigDecimal.valueOf(800);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return BigDecimal.valueOf(1700);
    }
}

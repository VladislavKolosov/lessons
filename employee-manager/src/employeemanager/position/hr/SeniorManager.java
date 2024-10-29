package employeemanager.position.hr;

import employeemanager.Department;
import employeemanager.position.Position;

import java.math.BigDecimal;

public class SeniorManager implements Position {
    @Override
    public String getName() {
        return "SeniorManager";
    }

    @Override
    public Department getDepartment() {
        return Department.HR;
    }

    @Override
    public BigDecimal getMinSalary() {
        return BigDecimal.valueOf(700);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return BigDecimal.valueOf(1100);
    }
}

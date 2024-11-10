package employeemanager.position.marketing;

import employeemanager.Department;
import employeemanager.position.Position;

import java.math.BigDecimal;

public class HeadOfMarketing implements Position {
    @Override
    public String getName() {
        return "HeadOfMarketing";
    }

    @Override
    public Department getDepartment() {
        return Department.MARKETING;
    }

    @Override
    public BigDecimal getMinSalary() {
        return BigDecimal.valueOf(1000);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return BigDecimal.valueOf(2000);
    }
    @Override
    public String toString() {
        return "HeadOfMarketing";
    }
}

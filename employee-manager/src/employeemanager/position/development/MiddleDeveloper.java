package employeemanager.position.development;

import employeemanager.Department;
import employeemanager.position.Position;

import java.math.BigDecimal;

public class MiddleDeveloper implements Position {
    @Override
    public String getName() {
        return "MiddleDeveloper";
    }

    @Override
    public Department getDepartment() {
        return Department.DEVELOPMENT;
    }

    @Override
    public BigDecimal getMinSalary() {
        return BigDecimal.valueOf(800);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return BigDecimal.valueOf(2000);
    }
}

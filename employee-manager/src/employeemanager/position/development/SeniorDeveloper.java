package employeemanager.position.development;

import employeemanager.Department;
import employeemanager.position.Position;

import java.math.BigDecimal;

public class SeniorDeveloper implements Position {
    @Override
    public String getName() {
        return "SeniorDeveloper";
    }

    @Override
    public Department getDepartment() {
        return Department.DEVELOPMENT;
    }

    @Override
    public BigDecimal getMinSalary() {
        return BigDecimal.valueOf(1800);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return BigDecimal.valueOf(4000);
    }
    @Override
    public String toString() {
        return "SeniorDeveloper";
    }
}

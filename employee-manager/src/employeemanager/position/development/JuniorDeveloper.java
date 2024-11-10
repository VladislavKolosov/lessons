package employeemanager.position.development;

import employeemanager.Department;
import employeemanager.position.Position;

import java.math.BigDecimal;

public class JuniorDeveloper implements Position {
    @Override
    public String getName() {
        return "JuniorDeveloper";
    }

    @Override
    public Department getDepartment() {
        return Department.DEVELOPMENT;
    }

    @Override
    public BigDecimal getMinSalary() {
        return BigDecimal.valueOf(400);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return BigDecimal.valueOf(1000);
    }
    @Override
    public String toString() {
        return "JuniorDeveloper";
    }
}

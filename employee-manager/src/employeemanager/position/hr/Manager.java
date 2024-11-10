package employeemanager.position.hr;

import employeemanager.Department;
import employeemanager.position.Position;

import java.math.BigDecimal;

public class Manager implements Position {
    @Override
    public String getName() {
        return "Manager";
    }

    @Override
    public Department getDepartment() {
        return Department.HR;
    }

    @Override
    public BigDecimal getMinSalary() {
        return BigDecimal.valueOf(400);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return BigDecimal.valueOf(800);
    }

    @Override
    public String toString() {
        return "Manager";
    }
}

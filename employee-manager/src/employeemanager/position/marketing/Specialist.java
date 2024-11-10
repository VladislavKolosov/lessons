package employeemanager.position.marketing;

import employeemanager.Department;
import employeemanager.position.Position;

import java.math.BigDecimal;

public class Specialist implements Position {

    @Override
    public String getName() {
        return "Specialist";
    }

    @Override
    public Department getDepartment() {
        return Department.MARKETING;
    }

    @Override
    public BigDecimal getMinSalary() {
        return BigDecimal.valueOf(600);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return BigDecimal.valueOf(1200);
    }
    @Override
    public String toString() {
        return "Specialist";
    }
}
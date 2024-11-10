package employeemanager.position.marketing;

import employeemanager.Department;
import employeemanager.position.Position;

import java.math.BigDecimal;

public class Trainee implements Position {
    @Override
    public String getName() {
        return "Trainee";
    }

    @Override
    public Department getDepartment() {
        return Department.MARKETING;
    }

    @Override
    public BigDecimal getMinSalary() {
        return BigDecimal.valueOf(300);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return BigDecimal.valueOf(600);
    }
    @Override
    public String toString() {
        return "Trainee";
    }
}

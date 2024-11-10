package employeemanager.position.development;

import employeemanager.Department;
import employeemanager.position.Position;

import java.math.BigDecimal;

public class TeamLead implements Position {
    @Override
    public String getName() {
        return "TeamLead";
    }

    @Override
    public Department getDepartment() {
        return Department.DEVELOPMENT;
    }

    @Override
    public BigDecimal getMinSalary() {
        return BigDecimal.valueOf(2500);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return BigDecimal.valueOf(7000);
    }
    @Override
    public String toString() {
        return "TeamLead";
    }
}

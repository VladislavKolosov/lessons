package employeemanager;

public enum Department {
    HR("Human Resources"), MARKETING("Marketing"), DEVELOPMENT("Development");

    private String department;

    private Department(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

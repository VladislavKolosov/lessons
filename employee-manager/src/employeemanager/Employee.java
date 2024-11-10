package employeemanager;

import employeemanager.position.Position;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    private  static int countId;
    private int id;
    private String name;
    private String surname;
    private Position position;
    private LocalDate dateOfEmployment;
    private BigDecimal salary;
    private LocalDate lastSalaryChange;


    public Employee(String name, String surname, Position position, BigDecimal salary) {
        this.id = ++countId;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.dateOfEmployment = LocalDate.now();
        if (salary.compareTo(position.getMaxSalary()) > 0 || salary.compareTo(position.getMinSalary()) < 0) {
            throw new RuntimeException("Заработная не может быть маньше - " + position.getMinSalary()
                    + " и больше - " + position.getMaxSalary());
        }
        this.salary = salary;
        this.lastSalaryChange = dateOfEmployment;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getLastSalaryChange() {
        return lastSalaryChange;
    }

    public void setLastSalaryChange(LocalDate lastSalaryChange) {
        this.lastSalaryChange = lastSalaryChange;
    }


    @Override
    public String toString() {
        return  id +
                ". name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position=" + position.getName() +
                ", dateOfEmployment=" + dateOfEmployment +
                ", salary=" + salary +
                ", lastSalaryChange=" + lastSalaryChange;
    }
}

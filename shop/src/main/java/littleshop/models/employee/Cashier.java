package littleshop.models.employee;

import littleshop.models.Department;
import littleshop.models.enums.EmployeeRole;

import java.util.Objects;

public class Cashier extends Employee {

    private long personalNumber;

    public Cashier(String name, EmployeeRole role, Department department, long personalNumber) {
        super(name, role, department);
        this.personalNumber = personalNumber;
    }

    public long getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(long personalNumber) {
        this.personalNumber = personalNumber;
    }

    @Override
    public String display() {
        return toString();
    }

    @Override
    public String toString() {
        return "CASHIER: " + '\n' +
                "NAME: " + super.getName() + '\n' +
                "DEPARTMENT: " + super.getDepartment().getName() + '\n' +
                "PERSONAL NUMBER: " + personalNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Cashier cashier = (Cashier) o;
        return personalNumber == cashier.personalNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), personalNumber);
    }
}

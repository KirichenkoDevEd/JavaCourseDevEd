package littleshop.models.employee;

import littleshop.models.Department;
import littleshop.models.enums.EmployeeRole;

import java.util.Objects;

public class Consultant extends Employee {
    private boolean isFree;

    public Consultant(String name, EmployeeRole role, Department department, boolean isFree) {
        super(name, role, department);
        this.isFree = isFree;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    @Override
    public String display() {
        return toString();
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
        Consultant that = (Consultant) o;
        return isFree == that.isFree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isFree);
    }

    @Override
    public String toString() {
        return "CONSULTANT: " + super.getName() + '\n' +
                "DEPARTMENT: " + super.getDepartment().getName() + '\n' +
                "IS CONSULTANT FREE: " + isFree;
    }
}

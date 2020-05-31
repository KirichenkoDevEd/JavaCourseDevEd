package littleshop.models.employee;

import littleshop.models.Department;
import littleshop.models.enums.EmployeeRole;

import java.util.Objects;

public class Administrator extends Employee {

    private String contactNumber;

    public Administrator(String name, EmployeeRole role, Department department, String contactNumber) {
        super(name, role, department);
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String display() {
        return toString();
    }

    @Override
    public String toString() {
        return String.format("ADMINISTRATOR %s NAME: %s%s DEPARTMENT: %s%s CONTACT NUMBER: %s",
                '\n',
                getName(),
                '\n',
                getDepartment().getName(),
                '\n',
                getContactNumber());
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
        Administrator that = (Administrator) o;
        return Objects.equals(contactNumber, that.contactNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), contactNumber);
    }
}

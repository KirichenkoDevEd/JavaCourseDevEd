package littleshop.models.employee;

import littleshop.models.Department;
import littleshop.models.enums.EmployeeRole;
import java.util.Objects;
import java.util.UUID;

public abstract class Employee {

    private UUID id;
    private String name;
    private EmployeeRole role;
    private Department department;

    public Employee(String name, EmployeeRole role, Department department) {
        id = UUID.randomUUID();
        this.name = name;
        this.role = role;
        this.department = department;
    }

    public abstract String display();

    public String sayHi() {
        return "HI";
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeRole getRole() {
        return role;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(name, employee.name) &&
                role == employee.role &&
                Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, department);
    }

    @Override
    public String toString() {
        return String.format("EMPLOYEE %s NAME: %s%s DEPARTMENT: %s%s ROLE: %s",
                '\n',
                getName(), '\n',
                getDepartment().getName(), '\n',
                getRole());
    }
}

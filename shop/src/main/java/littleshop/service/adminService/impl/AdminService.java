package littleshop.service.adminService.impl;

import littleshop.models.Department;
import littleshop.models.employee.Consultant;
import littleshop.service.adminService.IAdminService;
import littleshop.service.consultantService.IConsultantService;
import littleshop.service.consultantService.impl.ConsultantService;
import java.util.HashSet;
import java.util.Set;

public class AdminService implements IAdminService {

    private IConsultantService consultantService = new ConsultantService();

    @Override
    public boolean addConsultantToDep(Consultant consultant, Department department) {
        Set<Consultant> consultantsOfDep = department.getConsultants();
        if (consultantsOfDep == null) {
            consultantsOfDep = new HashSet<>();
        }
        if (consultantsOfDep.contains(consultant)) {
            System.out.println("Consultant already works in " + department.getName());
            return false;
        } else {
            consultantsOfDep.add(consultant);
            return true;
        }
    }


    @Override
    public boolean changeConsultantsDep(Consultant consultant, Department department) {
        Department depOfConsultant = consultant.getDepartment();
        if (depOfConsultant == null || !department.getName().equals(consultant.getDepartment().getName())) {
            consultant.setDepartment(department);
            return true;
        } else {
            System.out.println("Consultant already works in " + department.getName());
            return false;
        }
    }
}

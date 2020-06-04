package littleshop.service.adminService.impl;

import littleshop.exceptions.AdminWorkException;
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
    public boolean addConsultantToDep(Consultant consultant, Department department) throws AdminWorkException {
        Set<Consultant> consultantsOfDep = department.getConsultants();
        if (consultantsOfDep == null) {
            consultantsOfDep = new HashSet<>();
        }
        if (consultantsOfDep.contains(consultant)) {
            throw new AdminWorkException("Consultant already works in" + department.getName());
        } else {
            consultantsOfDep.add(consultant);
            return true;
        }
    }


    @Override
    public boolean changeConsultantsDep(Consultant consultant, Department department) throws AdminWorkException {
        Department depOfConsultant = consultant.getDepartment();
        if (depOfConsultant == null || !department.getName().equals(consultant.getDepartment().getName())) {
            consultant.setDepartment(department);
            return true;
        } else {
            throw new AdminWorkException("Consultant already works in" + department.getName());
        }
    }
}

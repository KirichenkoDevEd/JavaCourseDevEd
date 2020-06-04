package littleshop.service.adminService;
import littleshop.exceptions.AdminWorkException;
import littleshop.models.Department;
import littleshop.models.employee.Consultant;

/**
 * API for administrator.
 */
public interface IAdminService {
    /**
     * Method add consultant to department.
     *
     * @param consultant consultant
     * @param department department
     * @return True in case adding was success, otherwise - false.
     */
    boolean addConsultantToDep(Consultant consultant, Department department) throws AdminWorkException;

    /**
     * Method change consultant's department.
     *
     * @param consultant consultant
     * @param department department
     * @return True in case changing was success, otherwise - false.
     */
    boolean changeConsultantsDep(Consultant consultant, Department department) throws AdminWorkException;

}

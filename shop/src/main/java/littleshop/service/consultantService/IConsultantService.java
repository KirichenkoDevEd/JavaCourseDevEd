package littleshop.service.consultantService;

import littleshop.models.Goods;
import littleshop.models.employee.Consultant;

/**
 * Service for Consultant.
 */
public interface IConsultantService {

    /**
     * Give information about goods.
     *
     * @param goods required goods
     * @return Info about goods.
     */
    String consult(Goods goods);

    /**
     * Change status for Consultant.
     * @param consultant consultant
     */
    void changeStatus(Consultant consultant);

}

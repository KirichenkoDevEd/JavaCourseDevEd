package littleshop.service.consultantService.impl;

import littleshop.exceptions.ConsultWorkException;
import littleshop.models.Goods;
import littleshop.models.employee.Consultant;
import littleshop.service.consultantService.IConsultantService;

public class ConsultantService implements IConsultantService {

    @Override
    public String consult(Goods goods) throws ConsultWorkException {
        String info = goods.getInfo();
        if (info == null || "".equals(info)) {
            throw new ConsultWorkException("Sorry, we have no info about this goods. I need to double check!");
        } else {
            return goods.getInfo();
        }
    }

    @Override
    public void changeStatus(Consultant consultant) {
        consultant.setFree(!consultant.isFree());
    }
}

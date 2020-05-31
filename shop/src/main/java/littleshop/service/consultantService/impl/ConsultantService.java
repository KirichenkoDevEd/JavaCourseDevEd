package littleshop.service.consultantService.impl;

import littleshop.models.Goods;
import littleshop.models.employee.Consultant;
import littleshop.service.consultantService.IConsultantService;

public class ConsultantService implements IConsultantService {

    @Override
    public String consult(Goods goods) {
        String info = goods.getInfo();
        if (info == null || "".equals(info)) {
            return "Sorry, we have no info about this goods. I need to double check!";
        } else {
            return goods.getInfo();
        }
    }

    @Override
    public void changeStatus(Consultant consultant) {
        consultant.setFree(!consultant.isFree());
    }
}

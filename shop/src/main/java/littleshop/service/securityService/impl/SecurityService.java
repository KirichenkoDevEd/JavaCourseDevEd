package littleshop.service.securityService.impl;

import littleshop.models.Bill;
import littleshop.models.Customer;
import littleshop.service.securityService.ISecurityService;

public class SecurityService implements ISecurityService {

    @Override
    public boolean checkBill(Customer customer, Bill bill) {
        return bill.getOrder().equals(customer.getOrder());
    }
}

package littleshop.service.securityService;

import littleshop.models.Bill;
import littleshop.models.Customer;

/**
 * Service for Security.
 */
public interface ISecurityService {

    /**
     * Method compare Customer's order with order in Bill.
     *
     * @param customer Customer
     * @param bill     Bill
     * @return True in case orders are equals, otherwise - false.
     */
    boolean checkBill(Customer customer, Bill bill);
}

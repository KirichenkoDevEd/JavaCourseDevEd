package littleshop.service.cashierService;

import littleshop.models.Bill;
import littleshop.models.Customer;
import littleshop.models.enums.Discount;
import littleshop.models.Goods;
import java.math.BigDecimal;
import java.util.List;

/**
 * Service for Cashier.
 */
public interface ICashierService {
    /**l
     * Calculate sum of order.
     *
     * @param customer Customer
     * @return Sum of goods
     */
    BigDecimal sum(Customer customer);

    /**
     * Check discount of Customer.
     *
     * @param customer Customer
     * @return True in case Customer have discount, otherwise - false.
     */
    boolean checkDiscount(Customer customer);

    /**
     * Give regular discount for Customer when order's price over 100$.
     * Give gold discount for Customer when order's price over 1000$.
     *
     * @param sum        Order's sum.
     * @param historySum History of order's.
     * @return discount
     */
    Discount giveDiscount(BigDecimal sum, BigDecimal historySum);

    /**
     * Give bill.
     *
     * @param nameOfCustomer Customer's name
     * @param order          Total order
     * @param sum            Sum of order     * @return bill
     */
    Bill giveBill(String nameOfCustomer, List<Goods> order, BigDecimal sum);
}

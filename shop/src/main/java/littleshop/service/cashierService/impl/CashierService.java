package littleshop.service.cashierService.impl;

import littleshop.exceptions.CashierWorkException;
import littleshop.models.Bill;
import littleshop.models.Customer;
import littleshop.models.Goods;
import littleshop.models.enums.Discount;
import littleshop.service.cashierService.ICashierService;
import java.math.BigDecimal;
import java.util.List;

public class CashierService implements ICashierService {

    @Override
    public BigDecimal sum(Customer customer) {
        List<Goods> order = customer.getOrder();
        if (order == null || order.isEmpty()) {
            return BigDecimal.ZERO;
        } else {
            BigDecimal sum = BigDecimal.ZERO;
            for (Goods goods : order) {
                BigDecimal price = goods.getPrice();
                sum = sum.add(price);
            }
            return sum;
        }
    }

    @Override
    public boolean checkDiscount(Customer customer) {
        return customer.getDiscount() == null;
    }

    @Override
    public Discount giveDiscount(BigDecimal sum, BigDecimal historySum) {
        Discount discount = null;
        BigDecimal totalSum = sum.add(historySum);
        if (sum.compareTo(BigDecimal.valueOf(100L)) >= 0
                || historySum.compareTo(BigDecimal.valueOf(100L)) >= 0
                || totalSum.compareTo(BigDecimal.valueOf(100L)) >= 0) {
            discount = Discount.REGULAR;
        } else if (sum.compareTo(BigDecimal.valueOf(1000L)) >= 0
                || historySum.compareTo(BigDecimal.valueOf(1000L)) >= 0
                || totalSum.compareTo(BigDecimal.valueOf(1000L)) >= 0) {
            discount = Discount.GOLD;
        }
        return discount;
    }

    @Override
    public Bill giveBill(String nameOfCustomer, List<Goods> order, BigDecimal sum) throws CashierWorkException {
        if (nameOfCustomer != null && order != null && order.isEmpty()) {
            return new Bill(nameOfCustomer, order, sum);
        } else {
            throw new CashierWorkException("Invalid parameters for creating the bill!");
        }
    }
}

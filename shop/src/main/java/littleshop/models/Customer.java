package littleshop.models;

import littleshop.models.enums.Discount;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Customer {

    private String name;
    private List<Goods> order;
    private Map<LocalDateTime, BigDecimal> history;
    private Discount discount;

    public Customer(String name, List<Goods> order, Map<LocalDateTime, BigDecimal> history, Discount discount) {
        this.name = name;
        this.order = order;
        this.history = history;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Goods> getOrder() {
        return order;
    }

    public void setOrder(List<Goods> order) {
        this.order = order;
    }

    public Map<LocalDateTime, BigDecimal> getHistory() {
        return history;
    }

    public void setHistory(Map<LocalDateTime, BigDecimal> history) {
        this.history = history;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
                Objects.equals(order, customer.order) &&
                Objects.equals(history, customer.history) &&
                discount == customer.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, order, history, discount);
    }

    @Override
    public String toString() {
        return String.format("CUSTOMER %s NAME: %s%s ORDER: %s%s DISCOUNT: %s",
                '\n',
                getName(), '\n',
                showOrder(), '\n',
                getDiscount().name());
    }

    private String showOrder() {
        if (this.order == null || this.order.isEmpty()) {
            return "You have no new orders now.";
        } else {
            return String.format("%s%s%s Order size - %s", '\n', this.order.toString(), '\n', order.size());
        }
    }
}

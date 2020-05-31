package littleshop.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Bill {

    private LocalDate date;
    private String nameOfCustomer;
    private List<Goods> order;
    private BigDecimal sum;

    public Bill(String nameOfCustomer, List<Goods> order, BigDecimal sum) {
        this.date = LocalDate.now();
        this.nameOfCustomer = nameOfCustomer;
        this.order = order;
        this.sum = sum;
    }

    public Bill(BigDecimal sum) {
        this.date = LocalDate.now();
        this.sum = sum;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }

    public List<Goods> getOrder() {
        return order;
    }

    public void setOrder(List<Goods> order) {
        this.order = order;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bill bill = (Bill) o;
        return Objects.equals(date, bill.date) &&
                Objects.equals(nameOfCustomer, bill.nameOfCustomer) &&
                Objects.equals(order, bill.order) &&
                Objects.equals(sum, bill.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, nameOfCustomer, order, sum);
    }

    @Override
    public String toString() {
        return String.format("BILL %s DATE: %s%s NAME OF CUSTOMER: %s%s ORDER: %s%s TOTAL SUM: %s ",
                '\n',
                getDate(), '\n',
                getNameOfCustomer(), '\n',
                showOrder(), '\n',
                getSum());
    }

    private String showOrder() {
        if (this.order == null || this.order.isEmpty()) {
            return "You have no new orders now.";
        } else {
            return String.format("%s%s%s Order size - %s", '\n', this.order.toString(), '\n', order.size());
        }
    }
}

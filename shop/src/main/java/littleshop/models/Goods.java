package littleshop.models;

import littleshop.models.enums.Brand;
import littleshop.models.enums.GoodsGroup;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Goods {

    private UUID id;
    private String name;
    private Brand brand;
    private BigDecimal price;
    private GoodsGroup group;
    private Department department;
    private String info;

    public Goods(String name, Brand brand, BigDecimal price, GoodsGroup group, Department department) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.group = group;
        this.department = department;
        buildInfo();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public GoodsGroup getGroup() {
        return group;
    }

    public void setGroup(GoodsGroup group) {
        this.group = group;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private void buildInfo() {
        this.info = String.format("======INFO======%s NAME: %s%s BRAND: %s%s GROUP: %s%s PRICE: %s%",
                '\n',
                this.name,
                '\n',
                this.brand,
                '\n',
                this.group,
                '\n',
                this.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Goods goods = (Goods) o;
        return Objects.equals(id, goods.id) &&
                Objects.equals(name, goods.name) &&
                brand == goods.brand &&
                Objects.equals(price, goods.price) &&
                group == goods.group &&
                Objects.equals(department, goods.department) &&
                Objects.equals(info, goods.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brand, price, group, department, info);
    }

    @Override
    public String toString() {
        return info;
    }
}

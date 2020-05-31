package littleshop.models;

import littleshop.models.employee.Consultant;
import littleshop.models.enums.Brand;
import java.util.Map;
import java.util.Set;

public class Department {
    private String name;
    private Brand brand;
    private Map<Goods, Integer> goods;
    private Set<Consultant> consultants;

    public Department(String name, Brand brand, Map<Goods, Integer> goods, Set<Consultant> consultants) {
        this.name = name;
        this.brand = brand;
        this.goods = goods;
        this.consultants = consultants;
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

    public Map<Goods, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<Goods, Integer> goods) {
        this.goods = goods;
    }

    public Set<Consultant> getConsultants() {
        return consultants;
    }

    public void setConsultants(Set<Consultant> consultants) {
        this.consultants = consultants;
    }

    @Override
    public String toString() {
        return "DEPARTMENT:" + '\n' +
                name + '\n' +
                "STUFF - " + consultants.size() +
                " consultants";
    }
}

package littleshop.service.storeKeeperService.impl;

import littleshop.exceptions.StoreKeeperWorkException;
import littleshop.models.Department;
import littleshop.models.Goods;
import littleshop.models.Report;
import littleshop.models.enums.Brand;
import littleshop.models.enums.GoodsGroup;
import littleshop.models.storage.Storage;
import littleshop.service.storeKeeperService.IStoreKeeperService;
import java.util.HashMap;
import java.util.Map;

public class StoreKeeperService implements IStoreKeeperService {

    private Storage storage = Storage.getInstance();

    @Override
    public void registerGoods(Goods goods, int quantity) throws StoreKeeperWorkException {
        Department department = goods.getDepartment();
        if (department == null) {
            throw new StoreKeeperWorkException("There is no Department for register to!");
        }
        if (!Storage.totalGoods.get(department).containsKey(goods)) {
            Storage.totalGoods.get(department).put(goods, quantity);
        } else {
            int oldQuantity = Storage.totalGoods.get(department).get(goods);
            Storage.totalGoods.get(department).put(goods, (oldQuantity + quantity));
        }
    }

    @Override
    public Report sortGoods(Map<Goods, Integer> goodsForSorting, String storeKeeperName) throws StoreKeeperWorkException {
        int countOfDeps = 0;
        for (Goods goods : goodsForSorting.keySet()) {
            for (Department department : Storage.departments) {
                if (department.equals(goods.getDepartment())) {
                    registerGoods(goods, goodsForSorting.get(goods));
                    countOfDeps++;
                }
            }
        }
        return new Report(storeKeeperName, String.format("There were sorted %s goods for %s departments",
                goodsForSorting.size(),
                countOfDeps));
    }

    @Override
    public void printTotalQuantity() {
        for (Map.Entry<Department, Map<Goods, Integer>> entry : Storage.totalGoods.entrySet()) {
            Department department = entry.getKey();
            System.out.println(department.getName());
            Map<Goods, Integer> goodsOfDep = entry.getValue();
            for (Map.Entry<Goods, Integer> goodsIntegerEntry : goodsOfDep.entrySet()) {
                System.out.println(goodsIntegerEntry);
            }
        }
    }

    @Override
    public Map<Goods, Integer> getQuantityByBrand(Brand brand) throws StoreKeeperWorkException {
        if (brand == null){
            throw new StoreKeeperWorkException("Brand is invalid!");
        }
        Map<Goods, Integer> result = new HashMap<>();
        for (Map.Entry<Department, Map<Goods, Integer>> entry : Storage.totalGoods.entrySet()) {
            Map<Goods, Integer> goodsIntegerMap = entry.getValue();
            for (Map.Entry<Goods, Integer> goodsIntegerEntry : goodsIntegerMap.entrySet()) {
                if (goodsIntegerEntry.getKey().getBrand().equals(brand)) {
                    result.put(goodsIntegerEntry.getKey(), goodsIntegerEntry.getValue());
                }
            }
        }
        return result;
    }

    @Override
    public Map<Goods, Integer> getQuantityByGroup(GoodsGroup group) throws StoreKeeperWorkException {
        if (group == null){
            throw new StoreKeeperWorkException("Group is invalid!");
        }
        Map<Goods, Integer> result = new HashMap<>();
        for (Map.Entry<Department, Map<Goods, Integer>> entry : Storage.totalGoods.entrySet()) {
            Map<Goods, Integer> goodsIntegerMap = entry.getValue();
            for (Map.Entry<Goods, Integer> goodsIntegerEntry : goodsIntegerMap.entrySet()) {
                if (goodsIntegerEntry.getKey().getGroup().equals(group)) {
                    result.put(goodsIntegerEntry.getKey(), goodsIntegerEntry.getValue());
                }
            }
        }
        return result;
    }

    @Override
    public Map<Goods, Integer> getQuantityByDepartment(Department department) throws StoreKeeperWorkException {
        if (department == null){
            throw new StoreKeeperWorkException("Department is invalid!");
        }
        return Storage.totalGoods.get(department);
    }
}

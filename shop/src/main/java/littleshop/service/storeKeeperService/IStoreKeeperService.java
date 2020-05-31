package littleshop.service.storeKeeperService;

import littleshop.models.Department;
import littleshop.models.Goods;
import littleshop.models.Report;
import littleshop.models.enums.Brand;
import littleshop.models.enums.GoodsGroup;
import java.util.Map;

/**
 * Service for StoreKeeper
 */
public interface IStoreKeeperService {

    /**
     * Register goods to Storage.
     *
     * @param goods    Goods
     * @param quantity Quantity of goods
     */
    void registerGoods(Goods goods, int quantity);

    /**
     * Sort goods for required departments.
     *
     * @param goodsForSorting Map with Goods and quantity of goods
     * @param storeKeeperName Name of StoreKeeper
     * @return Report
     */
    Report sortGoods(Map<Goods, Integer> goodsForSorting, String storeKeeperName);

    /**
     * Total quantity of goods.
     */
    void printTotalQuantity();

    /**
     * Quantity of goods by Brand.
     *
     * @param brand Brand
     * @return Quantity of goods by Brand
     */
    Map<Goods, Integer> getQuantityByBrand(Brand brand);

    /**
     * Quantity of goods by Group.
     *
     * @param group Group
     * @return Quantity of goods by Group
     */
    Map<Goods, Integer> getQuantityByGroup(GoodsGroup group);

    /**
     * Quantity of goods by Department.
     *
     * @param department Department
     * @return Quantity of goods by Department
     */
    Map<Goods, Integer> getQuantityByDepartment(Department department);
}

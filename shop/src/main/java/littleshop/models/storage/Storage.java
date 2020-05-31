package littleshop.models.storage;

import littleshop.models.Department;
import littleshop.models.Goods;
import littleshop.models.employee.StoreKeeper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Singleton for Storage instance;
 */
public class Storage {

    private static Storage instance;

    /**
     * Departments of Shop.
     */
    public static Set<Department> departments = new HashSet<>();

    /**
     * StoreKeepers.
     */
    public static Set<StoreKeeper> storeKeepers = new HashSet<>();

    /**
     * Total amount of Goods.
     */
    public static Map<Department, Map<Goods, Integer>> totalGoods = new HashMap<>();

    private Storage() {
    }

    @Override
    public String toString() {
        return String.format("STORAGE %s DEPARTMENTS: %s%s STOREKEEPERS: %s",
                '\n',
                departments.size(),
                '\n',
                storeKeepers.size());
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }
}

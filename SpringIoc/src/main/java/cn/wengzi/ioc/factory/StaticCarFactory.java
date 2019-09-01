package cn.wengzi.ioc.factory;

import cn.wengzi.ioc.entity.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂Car
 */
public class StaticCarFactory {

    private static Map<Long, Car> carMap;

    static {
        carMap = new HashMap<Long, Car>();
        carMap.put(1L, new Car(1L, "奔驰"));
        carMap.put(2L, new Car(2L, "宝马"));
    }

    public static Car getCar(Long id) {
        return carMap.get(id);
    }
}

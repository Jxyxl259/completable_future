package com.jiang.completable_future_test_02.combine_test.dao;

import com.jiang.completable_future_test_02.combine_test.entity.Shop;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ShopDao
 * @Description
 * @Author jiangxy
 * @Date 2018\11\28 0028 10:08
 * @Version 1.0.0
 */
public class ShopDao {

    public static Map<String, Shop> allShops = new HashMap<>();

    static{
        allShops.put("unimark", new Shop(200));
        allShops.put("newtime", new Shop(400));
        allShops.put("zone", new Shop(800));
        allShops.put("darunfa", new Shop(1600));
    }


    public Map<String, Shop> getAllShops() {
        return allShops;
    }

}

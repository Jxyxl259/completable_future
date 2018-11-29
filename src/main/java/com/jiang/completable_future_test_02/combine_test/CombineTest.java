package com.jiang.completable_future_test_02.combine_test;

import com.jiang.completable_future_test_02.combine_test.dao.ShopDao;
import com.jiang.completable_future_test_02.combine_test.dao.UserDao;
import com.jiang.completable_future_test_02.combine_test.entity.Shop;
import com.jiang.completable_future_test_02.combine_test.entity.User;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @ClassName combine_test
 * @Description
 * @Author jiangxy
 * @Date 2018\11\28 0028 10:29
 * @Version 1.0.0
 */
public class CombineTest {

    public static void main(String[] args) {

        Task t = new Task();

        Integer instance = t.getInstance(1);

        System.out.println(instance);

    }

}

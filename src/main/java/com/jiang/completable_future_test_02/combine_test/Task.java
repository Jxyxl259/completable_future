package com.jiang.completable_future_test_02.combine_test;

import com.jiang.completable_future_test_02.combine_test.dao.ShopDao;
import com.jiang.completable_future_test_02.combine_test.dao.UserDao;
import com.jiang.completable_future_test_02.combine_test.entity.Shop;
import com.jiang.completable_future_test_02.combine_test.entity.User;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Task
 * @Description
 * @Author jiangxy
 * @Date 2018\11\28 0028 10:40
 * @Version 1.0.0
 */
public class Task {

    private ShopDao shopDao = new ShopDao();

    private UserDao userDao = new UserDao();

    Executor shopTaskExecutor = Executors.newCachedThreadPool(new ThreadFactory() {
        AtomicInteger i = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {

            Thread t = new Thread(r, "#_shop_t" + i);
            return t;
        }
    });

    Executor userTaskExecutor = Executors.newCachedThreadPool(new ThreadFactory() {
        AtomicInteger i = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {

            Thread t = new Thread(r, "#_user_t" + i);
            return t;
        }
    });

    Executor instanceTaskExecutor = Executors.newCachedThreadPool(new ThreadFactory() {
        AtomicInteger i = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {

            Thread t = new Thread(r, "#_instance_t" + i);
            return t;
        }
    });


    CompletableFuture<Map<Integer,User>> userFuture = CompletableFuture.supplyAsync(() -> {

        Map<Integer, User> allUsers = userDao.getAllUsers();

        return allUsers;
    },userTaskExecutor);


    CompletableFuture<Map<String,Shop>> shopFuture = CompletableFuture.supplyAsync(() -> {

        Map<String, Shop> allShops = shopDao.getAllShops();

        return allShops;
    },shopTaskExecutor);


    CompletableFuture<Integer> instance = null;


    public Integer getInstance(Integer userId){

        try {
            this.userFuture.get();

            this.shopFuture.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        instance = shopFuture.thenCombineAsync(userFuture, (shops, users) -> {

            User user = users.get(userId);

            String shopName = user.getShopName();

            Shop shop = shops.get(shopName);

            Integer instance = shop.getInstance();

            return instance;
        }, instanceTaskExecutor);

        Integer instance = null;
        try {
            instance  = this.instance.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return instance;
    }



}

package com.jiang.completable_future_test_02.combine_test.entity;

/**
 * @ClassName Shop
 * @Description
 * @Author jiangxy
 * @Date 2018\11\28 0028 10:07
 * @Version 1.0.0
 */
public class Shop {

    private Integer instance;


    public Shop(Integer instance) {
        this.instance = instance;
    }

    public Integer getInstance() {
        return instance;
    }

    public void setInstance(Integer instance) {
        this.instance = instance;
    }
}

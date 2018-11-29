package com.jiang.completable_future_test_02.combine_test.entity;

/**
 * @ClassName user
 * @Description
 * @Author jiangxy
 * @Date 2018\11\28 0028 10:22
 * @Version 1.0.0
 */
public class User {

    private Integer userId;
    
    private String shopName;

    public User(Integer userId, String shopName) {
        this.userId = userId;
        this.shopName = shopName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

}

package com.jiang.completable_future_test_02.combine_test.dao;

import com.jiang.completable_future_test_02.combine_test.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserDao
 * @Description
 * @Author jiangxy
 * @Date 2018\11\28 0028 10:25
 * @Version 1.0.0
 */
public class UserDao {

    private static Map<Integer, User> allUsers = new HashMap<>();

    static{
        allUsers.put(1,new User(1,"unimark"));
        allUsers.put(2,new User(2,"newtime"));
        allUsers.put(3,new User(3,"zone"));
        allUsers.put(4,new User(4,"darunfa"));
    }

    public Map<Integer,User> getAllUsers(){
        return this.allUsers;
    }



}

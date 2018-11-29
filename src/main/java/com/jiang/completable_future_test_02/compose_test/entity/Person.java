package com.jiang.completable_future_test_02.compose_test.entity;

import java.util.List;

/**
 * @ClassName Person
 * @Description
 * @Author jiangxy
 * @Date 2018\11\27 0027 19:16
 * @Version 1.0.0
 */
public class Person {

    private String name;

    private List<String> car;

    private List<String> house;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCar() {
        return car;
    }

    public void setCar(List<String> car) {
        this.car = car;
    }

    public List<String> getHouse() {
        return house;
    }

    public void setHouse(List<String> house) {
        this.house = house;
    }
}

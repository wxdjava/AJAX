package com.bjpowernode.bean;

/**
 * @author wangxuedeng
 * @date 2023/1/2 - 15:00
 */
public class City {
    private String name;

    public City(String name) {
        this.name = name;
    }

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }
}

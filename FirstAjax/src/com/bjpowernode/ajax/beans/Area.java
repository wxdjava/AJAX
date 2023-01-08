package com.bjpowernode.ajax.beans;

/**
 * @author wangxuedeng
 * @date 2022/12/29 - 11:23
 */
public class Area {
    private String code;
    private String name;

    public Area() {
    }

    public Area(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Area{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

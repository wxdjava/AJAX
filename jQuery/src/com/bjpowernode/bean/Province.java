package com.bjpowernode.bean;

/**
 * @author wangxuedeng
 * @date 2023/1/1 - 22:28
 */
public class Province {
    private int id;
    private String name;
    private String abbreviation;
    private String provincialCapital;

    public Province() {

    }

    public Province(int id, String name, String abbreviation, String provincialCapital) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.provincialCapital = provincialCapital;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getProvincialCapital() {
        return provincialCapital;
    }

    public void setProvincialCapital(String provincialCapital) {
        this.provincialCapital = provincialCapital;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", provincialCapital='" + provincialCapital + '\'' +
                '}';
    }
}

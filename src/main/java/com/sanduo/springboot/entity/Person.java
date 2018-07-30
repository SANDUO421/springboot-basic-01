package com.sanduo.springboot.entity;

/**
 * 创建模板引擎的类 ， 2018/07/1添加了address，bootstrap+angularJs实战
 * 
 * @author sanduo
 * @date 2018/06/22
 */
public class Person {

    private String name;
    private Integer age;
    private String address;

    /**
     * 
     */
    public Person() {
        super();
    }

    /**
     * @param name
     * @param age
     * @param address
     */
    public Person(String name, Integer age, String address) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

}

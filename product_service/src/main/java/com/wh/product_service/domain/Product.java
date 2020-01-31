package com.wh.product_service.domain;

import java.io.Serializable;

/**
 * @program: product_service
 * @description:
 * @author: wh
 * @create: 2019-10-09 15:31
 */
public class Product implements Serializable {

    private int id;

    private String name;

    private int price;

    private int store;


    public Product(int id, String name, int price, int store) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.store = store;
    }

    public Product() {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", store=" + store +
                '}';
    }
}

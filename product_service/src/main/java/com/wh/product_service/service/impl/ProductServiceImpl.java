package com.wh.product_service.service.impl;

import com.wh.product_service.domain.Product;
import com.wh.product_service.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;

/**
 * @program: product_service
 * @description:
 * @author: wh
 * @create: 2019-10-09 15:25
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private static final Map<Integer,Product> daoMap = new HashMap<>();

    static {

        Product p1 = new Product(1,"iphonex",9999, 10);
        Product p2 = new Product(2,"冰箱",5342, 19);
        Product p3 = new Product(3,"洗衣机",523, 90);
        Product p4 = new Product(4,"电话",64345, 150);
        Product p5 = new Product(5,"汽车",2345, 140);
        Product p6 = new Product(6,"椅子",253, 20);
        Product p7 = new Product(7,"java编程思想",2341, 10);

        daoMap.put(p1.getId(),p1);
        daoMap.put(p2.getId(),p2);
        daoMap.put(p3.getId(),p3);
        daoMap.put(p4.getId(),p4);
        daoMap.put(p5.getId(),p5);
        daoMap.put(p6.getId(),p6);
        daoMap.put(p7.getId(),p7);
    }

    @Override
    public List<Product> listProduct() {
        Collection<Product> collection = daoMap.values();
        List<Product> list = new ArrayList<>(collection);
        return list;
    }

    @Override
    public Product findById(int id) {
        logger.info("service findById");
        return daoMap.get(id);
    }
}

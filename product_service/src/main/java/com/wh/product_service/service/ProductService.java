package com.wh.product_service.service;

import com.wh.product_service.domain.Product;

import java.util.List;

/**
 * @program: product_service
 * @description:
 * @author: wh
 * @create: 2019-10-09 15:24
 */
public interface ProductService {

    List<Product> listProduct();

    Product findById(int id);

}

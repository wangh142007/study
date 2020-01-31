package com.wh.product_service.controller;

import ch.qos.logback.core.util.TimeUtil;
import com.wh.product_service.domain.Product;
import com.wh.product_service.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @program: product_service
 * @description:
 * @author: wh
 * @create: 2019-10-09 15:37
 */

@RestController
@RequestMapping("/api/v1/product")
@RefreshScope
public class ProductController {


    @Value("${server.port}")
    String port;

    @Value("${env}")
    String env;


    @Autowired
    private ProductService productService;

    /**
     * 获取所有商品列表
     *
     * @return
     */
    @RequestMapping("list")
    public Object list() {
        return productService.listProduct();
    }


    /**
     * 根据id查找商品详情
     *
     * @param id
     * @return
     */
    @RequestMapping("find")
    public Object findById(int id) {

//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Product product = productService.findById(id);
        Product result = new Product();
        BeanUtils.copyProperties(product, result);
        result.setName(result.getName() + "data from port " + port + "  env   " + env);
        return result;
    }

}

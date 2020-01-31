package com.wh.order_service.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.wh.order_service.domain.ProductOrder;
import com.wh.order_service.service.ProductClient;
import com.wh.order_service.service.ProductOrderService;
import com.wh.order_service.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @program: order_service
 * @description:
 * @author: wh
 * @create: 2019-10-09 16:59
 */
@Service
public class ProductOrderServiceImpl implements ProductOrderService {


    @Autowired
    ProductClient productClient;

    @Override
    public ProductOrder save(int userId, int productId) {
        //调用订单接口
        String response = productClient.findById(productId);
        JsonNode jsonNode = JsonUtil.str2JsonNode(response);

        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setProductName(jsonNode.get("name").toString());
        productOrder.setPrice(Integer.parseInt(jsonNode.get("price").toString()));
        return productOrder;
    }


    //使用Ribbon 进行调用
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Override
//    public ProductOrder save(int userId, int productId) {
//
//        Map<String,Object> obj = restTemplate.getForObject("http://product-service/api/v1/product/find?id=" + productId, Map.class);
//
//        System.out.println(obj);
//
//        ProductOrder productOrder = new ProductOrder();
//        productOrder.setCreateTime(new Date());
//        productOrder.setUserId(userId);
//        productOrder.setTradeNo(UUID.randomUUID().toString());
//        productOrder.setProductName(obj.get("name").toString());
//        productOrder.setPrice(Integer.parseInt(obj.get("price").toString()));
//
//        return productOrder;
//    }
}

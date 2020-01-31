package com.wh.order_service.fallback;

import com.wh.order_service.service.ProductClient;
import org.springframework.stereotype.Component;

/**
 * @program: order_service
 * @description:针对商品服务做降级处理
 * @author: wh
 * @create: 2019-10-15 11:17
 */
@Component
public class ProductClientFallback implements ProductClient {


    @Override
    public String findById(int id) {
        System.out.println("feign 调用 product-service findById  异常");

        return null;
    }
}

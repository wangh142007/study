package com.wh.order_service.service;

import com.wh.order_service.fallback.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: order_service
 * @description:
 * @author: wh
 * @create: 2019-10-14 15:16
 */
@FeignClient(value = "product-service",fallback = ProductClientFallback.class)
public interface ProductClient {

        @GetMapping("/api/v1/product/find")
        String findById(@RequestParam(value = "id")int id);

}

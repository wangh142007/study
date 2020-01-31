package com.wh.order_service.service;

import com.wh.order_service.domain.ProductOrder;

/**
 * @program: order_service
 * @description:
 * @author: wh
 * @create: 2019-10-09 16:56
 */
public interface ProductOrderService {

    ProductOrder save(int userId, int productId);
}

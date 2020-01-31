package com.wh.order_service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wh.order_service.service.ProductOrderService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program: order_service
 * @description:
 * @author: wh
 * @create: 2019-10-09 17:02
 */
@RestController
@RequestMapping("api/v1/order")
@RefreshScope
public class OrderController {

    private final static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private ProductOrderService productOrderService;

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(@RequestParam("user_id") int userId, @RequestParam("product_id") int productId, HttpServletRequest request) {


        String token = request.getHeader("token");
        String cookie = request.getHeader("Cookie");

        logger.info("order service save");

        Map<String, Object> msg = new HashMap<>();
        msg.put("code", 0);
        msg.put("data", productOrderService.save(userId, productId));

        return msg;
    }

    /**
     * 方法名要和api名一样
     *
     * @param userId
     * @param productId
     * @return
     */
    public Object saveOrderFail(int userId, int productId, HttpServletRequest request) {

        //监控报警
        String saveOrderKey = "save-order";
        String sendValue = (String) redisTemplate.opsForValue().get(saveOrderKey);
        final String ip = request.getRemoteAddr();

        //todo：可以使用线程次和锁，以后研究
        new Thread(() -> {
            if (StringUtils.isBlank(sendValue)) {
                System.out.println("告警短信，用户下单失败，请查找原因,IP地址为：" + ip);
                //发送http请求，调用短信服务
                redisTemplate.opsForValue().set(saveOrderKey, "save-order-fail", 20, TimeUnit.SECONDS);
            } else {
                System.out.println("已经发送告警，20s不重复发送");
            }
        }).start();


        Map<String, Object> msg = new HashMap<>();
        msg.put("code", -1);
        msg.put("msg", "抢购人数太多");
        return msg;
    }


}

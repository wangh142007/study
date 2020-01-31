package com.example.servicefeign;

import org.springframework.stereotype.Component;

/**
 * @program: springcloud
 * @description:
 * @author: wh
 * @create: 2019-09-27 17:48
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}

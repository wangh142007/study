package com.wh.ssm.controller;

import com.wh.ssm.model.User;
import com.wh.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ssm
 * @description:
 * @author: wh
 * @create: 2019-11-18 11:04
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("list")
    @ResponseBody
    public Map getCartProductCount(HttpSession session) {

        List<User> list = userService.list();

        Map map = new HashMap();
        map.put("data",list);

        return map;
    }
}

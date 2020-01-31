package com.wh.ssm.service.impl;

import com.wh.ssm.dao.UserDao;
import com.wh.ssm.model.User;
import com.wh.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ssm
 * @description:
 * @author: wh
 * @create: 2019-11-18 10:57
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> list() {
        return userDao.findAll();
    }
}

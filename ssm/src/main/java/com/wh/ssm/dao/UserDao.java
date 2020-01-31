package com.wh.ssm.dao;

import com.wh.ssm.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: ssm
 * @description:
 * @author: wh
 * @create: 2019-11-18 09:46
 */
public interface UserDao {

    @Select("select * from account")
    List<User> findAll();
}

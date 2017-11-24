package com.eleven.dao;

import com.eleven.model.User;

/**
 * Created by User on 2017/11/21.
 */

public interface UserDao {

    User findById(Integer id);

    User findByUserName(String username);
}

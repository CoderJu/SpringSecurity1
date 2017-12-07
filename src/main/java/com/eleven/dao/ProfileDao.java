package com.eleven.dao;

import com.eleven.model.Profileid;
import com.eleven.model.UserToProfileid;

import java.util.List;
import java.util.Set;

/**
 * Created by User on 2017/12/2.
 */
public interface ProfileDao {
    List<Profileid> findAll();

    Profileid findById(Integer id);

}

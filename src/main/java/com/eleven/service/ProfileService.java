package com.eleven.service;

import com.eleven.model.Profileid;
import com.eleven.model.UserToProfileid;

import java.util.List;

/**
 * Created by User on 2017/12/2.
 */
public interface ProfileService {
    List<Profileid> findAll();

    Profileid findById(Integer id);


}

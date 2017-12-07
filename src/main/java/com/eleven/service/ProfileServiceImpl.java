package com.eleven.service;

import com.eleven.dao.ProfileDao;
import com.eleven.model.Profileid;
import com.eleven.model.UserToProfileid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 2017/12/2.
 */
@Service("profileService")
@Transactional
public class ProfileServiceImpl  implements  ProfileService{


    @Autowired
    private ProfileDao profileDao;

    public List<Profileid> findAll() {
        return profileDao.findAll();
    }

    public Profileid findById(Integer id) {
        return profileDao.findById(id);
    }
}

package com.eleven.service;

import com.eleven.model.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * Created by User on 2017/11/21.
 */
public interface UserService {

    User findById(Integer id);

    User findByUserName(String username);

    void save(User user);

    List<User> findAll();

    @PreAuthorize("hasRole('DBA')")
    void update(User user);

    @Secured("ROLE_ADMIN")
    void delete(User user);
}

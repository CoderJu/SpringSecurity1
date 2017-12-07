package com.eleven.dao;

import com.eleven.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 2017/11/21.
 */
@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public User findById(Integer id) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>"+id);
        String hql = "from User where id =? ";
        Query query =  sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,id);
        List<User> users =  query.list();
        if (users.size() >0 && users != null){
            return users.get(0);
        }
        return null;
    }

    public User findByUserName(String username) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>"+username);
        String hql = "from User  where userName=?";
        Query query =  sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,username);
        List<User> users =  query.list();
        if (users.size() >0 && users != null){
            return users.get(0);
        }
        return null;
    }

    public void save(User user) {

        sessionFactory.getCurrentSession().save(user);
    }

}

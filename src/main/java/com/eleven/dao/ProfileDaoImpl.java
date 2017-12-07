package com.eleven.dao;

import com.eleven.model.Profileid;
import com.eleven.model.UserToProfileid;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by User on 2017/12/2.
 */
@Repository("profileDao")
public class ProfileDaoImpl implements ProfileDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Profileid> findAll() {
        String hql = "from Profileid  ";
        Query query =  sessionFactory.getCurrentSession().createQuery(hql);
        List<Profileid> Profileids =  query.list();
        if (Profileids.size() >0 && Profileids != null){
            return Profileids;
        }
        return null;
    }

    public Profileid findById(Integer id) {
        String hql = "from Profileid where id = ? ";
        Query query =  sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,id);
        List<Profileid> Profileids =  query.list();
        if (Profileids.size() >0 && Profileids != null){
            return Profileids.get(0);
        }
        return null;

    }

}

package com.example.quiz_system_demo.admin_hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractHibernateDAO<T extends Serializable> {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> clazz;

    protected final void setClazz(final Class<T> clazzToSet){
        clazz = clazzToSet;
    }

    // find by id
    public T findById(final int id){
        return getCurrentSession().get(clazz, id);
    }

    public void add(T t) {
        getCurrentSession().persist(t);
    }

    public void update(T t) {
        getCurrentSession().saveOrUpdate(t);
    }

    public void delete(T t) {
        getCurrentSession().delete(t);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}

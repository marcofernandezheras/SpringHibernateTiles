package model.dao;

import model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by Marco A. Fernández Heras on 15/03/16.
 */
@Controller
public class UserDao implements GenericDao<User> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override @SuppressWarnings("unchecked")
    @Transactional
    public List<User> all() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    @Transactional
    public Optional<User> search(Serializable id) {
        return Optional.of((User) sessionFactory.getCurrentSession().byId(User.class).load(id));
    }

    @Override
    @Transactional
    public void insert(User object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    @Transactional
    public void update(User object) {
        sessionFactory.getCurrentSession().merge(object);
    }

    @Override
    @Transactional
    public void delete(User object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

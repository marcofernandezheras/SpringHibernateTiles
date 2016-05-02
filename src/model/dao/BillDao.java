package model.dao;

import model.Bill;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
public class BillDao implements GenericDao<Bill> {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired private User user;

    @Override @SuppressWarnings("unchecked")
    @Transactional
    public List<Bill> all() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Bill.class);
        criteria.add(Restrictions.eq("dni", user.getDni()));
        return criteria.list();
    }

    @Override @SuppressWarnings("unchecked")
    @Transactional
    public Optional<Bill> search(Serializable id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Bill.class);
        criteria.add(Restrictions.eq("dni", user.getDni()));
        criteria.add(Restrictions.eq("id", id));
        return criteria.list().stream().findAny();
    }

    @Override
    @Transactional
    public void insert(Bill object) {
        object.getDetails().forEach(d -> d.setBill(object));
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    @Transactional
    public void update(Bill object) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Transactional
    public void delete(Bill object) {
        throw new UnsupportedOperationException();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

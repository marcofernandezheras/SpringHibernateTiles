package model;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by Marco A. Fernández Heras on 15/03/16.
 */
public class BillDao implements GenericDao<Bill> {

    @Autowired
    private SessionFactory sessionFactory;
    private String dniUser = "";

    @Override @SuppressWarnings("unchecked")
    public List<Bill> all() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Bill.class);
        criteria.add(Restrictions.eq("dni", dniUser));
        return criteria.list();
    }

    @Override @SuppressWarnings("unchecked")
    public Optional<Bill> search(Serializable id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Bill.class);
        criteria.add(Restrictions.eq("dni", dniUser));
        criteria.add(Restrictions.eq("id", id));
        return criteria.list().stream().findAny();
    }

    @Override
    public void insert(Bill object) {
        object.getDetails().forEach(d -> d.setBill(object));
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public void update(Bill object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Bill object) {
        throw new UnsupportedOperationException();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setDniUser(String dniUser) {
        this.dniUser = dniUser;
    }
}

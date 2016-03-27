package model;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by Marco A. Fernández Heras on 15/03/16.
 */
public class BookDao implements GenericDao<Book> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override @SuppressWarnings("unchecked")
    public List<Book> all() {
        return sessionFactory.getCurrentSession().createCriteria(Book.class).list();
    }

    @Override
    public Optional<Book> search(Serializable id) {
        return Optional.of((Book) sessionFactory.getCurrentSession().byId(Book.class).load(id));
    }

    @Override
    public void insert(Book object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public void update(Book object) {
        sessionFactory.getCurrentSession().merge(object);
    }

    @Override
    public void delete(Book object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

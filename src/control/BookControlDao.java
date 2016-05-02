package control;

import model.Book;
import model.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by Marco A. Fernández Heras on 27/03/16.
 */
@Controller
public class BookControlDao implements ControlDao<Book> {

    @Autowired
    private GenericDao<Book> dao;

    @Override
    public List<Book> all() throws ModelException {
        try {
            return dao.all();
        }catch (Exception e){
            throw new ModelException(e);
        }
    }

    @Override
    public Optional<Book> search(Serializable id) throws ModelException {
        try {
            return dao.search(id);
        }catch (Exception e){
            throw new ModelException(e);
        }
    }

    @Override
    public void insert(Book object) throws ModelException {
        try {
            dao.insert(object);
        }catch (Exception e){
            throw new ModelException(e);
        }
    }

    @Override
    public void update(Book object) throws ModelException {
        try {
            dao.update(object);
        }catch (Exception e){
            throw new ModelException(e);
        }
    }

    @Override
    public void delete(Book object) throws ModelException {
        try {
            dao.delete(object);
        }catch (Exception e){
            throw new ModelException(e);
        }
    }

    public GenericDao<Book> getDao() {
        return dao;
    }

    public void setDao(GenericDao<Book> dao) {
        this.dao = dao;
    }
}

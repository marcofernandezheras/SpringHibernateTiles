package control;

import model.Bill;
import model.Book;
import model.dao.BillDao;
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
public class BillControlDao implements ControlDao<Bill> {
    @Autowired
    private GenericDao<Bill> dao;

    @Override
    public List<Bill> all() throws ModelException {
        try {
            return dao.all();
        }catch (Exception e){
            throw new ModelException(e);
        }
    }

    @Override
    public Optional<Bill> search(Serializable id) throws ModelException {
        try {
            return dao.search(id);
        }catch (Exception e){
            throw new ModelException(e);
        }
    }

    @Override
    public void insert(Bill object) throws ModelException {
        try {
            dao.insert(object);
        }catch (Exception e){
            throw new ModelException(e);
        }
    }

    @Override
    public void update(Bill object) throws ModelException {
        try {
            dao.update(object);
        }catch (Exception e){
            throw new ModelException(e);
        }
    }

    @Override
    public void delete(Bill object) throws ModelException {
        try {
            dao.delete(object);
        }catch (Exception e){
            throw new ModelException(e);
        }
    }

    public GenericDao<Bill> getDao() {
        return dao;
    }

    public void setDao(GenericDao<Bill> dao) {
        this.dao = dao;
    }
}

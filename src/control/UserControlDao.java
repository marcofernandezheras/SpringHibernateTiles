package control;

import model.User;
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
public class UserControlDao implements ControlDao<User>{
    @Autowired
    private GenericDao<User> dao;

    @Override
    public List<User> all() throws ModelException {
        try {
            return dao.all();
        }catch (Exception e){
            throw new ModelException(e);
        }
    }

    @Override
    public Optional<User> search(Serializable id) throws ModelException {
        try {
            return dao.search(id);
        }catch (Exception e){
            throw new ModelException(e);
        }
    }

    @Override
    public void insert(User object) throws ModelException {
        try {
            dao.insert(object);
        }catch (Exception e){
            throw new ModelException(e);
        }
    }

    @Override
    public void update(User object) throws ModelException {
        try {
            dao.update(object);
        }catch (Exception e){
            throw new ModelException(e);
        }
    }

    @Override
    public void delete(User object) throws ModelException {
        try {
            dao.delete(object);
        }catch (Exception e){
            throw new ModelException(e);
        }
    }

    public GenericDao<User> getDao() {
        return dao;
    }

    public void setDao(GenericDao<User> dao) {
        this.dao = dao;
    }
}

package spring;

import control.ControlDao;
import control.ModelException;
import model.Bill;
import model.Book;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

/**
 * Created by Marco A. Fernández Heras on 1/05/16.
 */
@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private ControlDao<Bill> dao;

    @Autowired
    private User user;

    @RequestMapping(value = {"/", "/list"} , method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("bill/list");
        try {
            List<Bill> bills = dao.query(bill -> bill.getDni().equalsIgnoreCase(user.getDni()));
            model.addObject("bills", bills);
        } catch (ModelException ex) {
            ex.printStackTrace();
            model.addObject("error", ex);
        }
        return model;
    }

    @RequestMapping(value = "/view" , method = RequestMethod.GET)
    public ModelAndView view(@RequestParam int id){
        ModelAndView model = new ModelAndView("bill/view");
        try {
            Optional<Bill> billOptional = dao.search(id);
            if(billOptional.isPresent() && billOptional.get().getDni().equalsIgnoreCase(user.getDni())){
                model.addObject("bill", billOptional.get());
            }
            else{
                model.addObject("error", "Factura no encontrada");
            }
        } catch (ModelException ex) {
            ex.printStackTrace();
            model.addObject("error", ex);
        }
        return model;
    }

    public ControlDao<Bill> getDao() {
        return dao;
    }

    public void setDao(ControlDao<Bill> dao) {
        this.dao = dao;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

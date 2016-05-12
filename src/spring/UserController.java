package spring;

import control.ControlDao;
import control.ModelException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Marco A. Fernández Heras on 21/04/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ControlDao<User> dao;

    @Autowired
    private User user;

    @RequestMapping(value = {"/", "/register"} , method = RequestMethod.GET)
    public ModelAndView registerView(){
        ModelAndView modelAndView = new ModelAndView("user/register");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = {"/", "/register"} , method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("user") User user){
        ModelAndView model = new ModelAndView("user/register");
        try {
            dao.insert(user);
            model.addObject("message", "Registro completado");
            model.addObject("user", new User());
        } catch (ModelException ex) {
            ex.printStackTrace();
            model.addObject("user", user);
            model.addObject("error", ex);
        }
        return model;
    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestParam String dni, @RequestParam String password){
        try {
            List<User> users = dao.query(u -> u.getDni().equalsIgnoreCase(dni) && u.getPassword().equals(password));
            if(!users.isEmpty()){
                User _user = users.get(0);
                request.getSession().setAttribute("actualUser", _user);
                user.setId(_user.getId());
                user.setName(_user.getName());
                user.setSurname(_user.getSurname());
                user.setDni(_user.getDni());
                user.setValid(true);
                _user.setValid(true);
            }
        } catch (ModelException ex) {
            ex.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "/logout" , method = RequestMethod.POST)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        this.user.setValid(false);
        return "index";
    }

    public ControlDao<User> getDao() {
        return dao;
    }

    public void setDao(ControlDao<User> dao) {
        this.dao = dao;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

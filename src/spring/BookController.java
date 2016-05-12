package spring;

import model.Book;
import control.ControlDao;
import control.ModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

/**
 * Created by Marco A. Fernández Heras on 11/04/16.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private ControlDao<Book> dao;

    @RequestMapping(value = {"/", "/list"} , method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("book/list");
        try {
            List<Book> books = dao.all();
            model.addObject("books", books);
        } catch (ModelException ex) {
            ex.printStackTrace();
            model.addObject("error", ex);
        }
        return model;
    }

    @RequestMapping(value = "/view" , method = RequestMethod.GET)
    public ModelAndView view(@RequestParam int id){
        ModelAndView model = new ModelAndView("book/view");
        try {
            Optional<Book> bookOptional = dao.search(id);
            if(bookOptional.isPresent()){
                model.addObject("book", bookOptional.get());
            }
            else{
                model.addObject("error", "Libro no encontrado");
            }
        } catch (ModelException ex) {
            ex.printStackTrace();
            model.addObject("error", ex);
        }
        return model;
    }

    @RequestMapping(value = "/create" , method = RequestMethod.GET)
    public ModelAndView createView(){
        ModelAndView model = new ModelAndView("book/create");
        model.addObject("book", new Book());
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("book") Book book){
        ModelAndView model = new ModelAndView("book/create");
        try {
            dao.insert(book);
            model.addObject("message", "Libro creado con éxito");
            model.addObject("book", new Book());
        } catch (ModelException ex) {
            ex.printStackTrace();
            model.addObject("book", book);
            model.addObject("error", ex);
        }
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editView(@RequestParam int id){
        ModelAndView model = new ModelAndView("book/edit");
        try {
            Optional<Book> bookOptional = dao.search(id);
            if(bookOptional.isPresent()){
                model.addObject("book", bookOptional.get());
            }
            else{
                model.addObject("error", "Libro no encontrado");
            }
        } catch (ModelException ex) {
            ex.printStackTrace();
            model.addObject("error", ex);
        }
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("book") Book book){
        ModelAndView model = new ModelAndView("book/edit");
        model.addObject("book", book);
        try {
            dao.update(book);
            model.addObject("message", "Libro actualizado con éxito");
        } catch (ModelException ex) {
            ex.printStackTrace();
            model.addObject("error", ex);
        }
        return model;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam int id){
        ModelAndView model = new ModelAndView("book/list");

        try {
            Optional<Book> book = dao.search(id);
            if(book.isPresent()){
                dao.delete(book.get());
                model.addObject("message", "Libro borrado con éxito");
            }
        } catch (ModelException ex) {
            model.addObject("error", ex);
        }

        try {
            List<Book> books = dao.all();
            model.addObject("books", books);
        } catch (ModelException ex) {
            ex.printStackTrace();
            model.addObject("error", ex);
        }
        return model;
    }

    public ControlDao<Book> getDao() {
        return dao;
    }

    public void setDao(ControlDao<Book> dao) {
        this.dao = dao;
    }
}

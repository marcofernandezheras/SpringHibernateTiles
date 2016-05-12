package spring;

import control.ControlDao;
import control.ModelException;
import model.Bill;
import model.BillDetail;
import model.Book;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Created by Marco A. Fernández Heras on 1/05/16.
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    Bill bill;

    @Autowired
    private ControlDao<Book> dao;

    @Autowired
    private ControlDao<Bill> billDao;

    @RequestMapping(value = {"/", "/view"}, method = RequestMethod.GET)
    public String view(){
        return "cart/view";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam int id){
        try {
            Optional<Book> bookOptional = dao.search(id);
            if(bookOptional.isPresent()){
                Book book = bookOptional.get();
                Optional<BillDetail> detail = bill.getDetails().stream()
                        .filter(d -> d.getTitle().equalsIgnoreCase(book.getTitle()))
                        .findFirst();
                if(detail.isPresent()){
                    detail.get().setAmount(detail.get().getAmount() + 1);
                }
                else{
                    BillDetail billDetail = new BillDetail();
                    billDetail.setAmount(1);
                    billDetail.setTitle(book.getTitle());
                    billDetail.setPrice(book.getPrice());
                    bill.getDetails().add(billDetail);
                }
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
        return "cart/view";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@RequestParam String title) {
        Optional<BillDetail> detail = bill.getDetails().stream()
                .filter(d -> d.getTitle().equalsIgnoreCase(title))
                .findFirst();
        if (detail.isPresent()) {
            detail.get().setAmount(detail.get().getAmount() - 1);
            bill.getDetails().removeIf(c -> c.getAmount() == 0);
        }
        return "cart/view";
    }
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public String buy(HttpServletRequest request){
        try {
            int i = 1;
            for (BillDetail detail: bill.getDetails()) {
                detail.setLineOrder(i);
                i++;
            }
            User user = (User) request.getSession().getAttribute("actualUser");
            bill.setName(user.getName());
            bill.setSurname(user.getSurname());
            bill.setDni(user.getDni());
            billDao.insert(bill);
            bill.setId(0);
            bill.getDetails().clear();
        } catch (ModelException e) {
            e.printStackTrace();
        }
        return "redirect:/bill/list.form";
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public ControlDao<Book> getDao() {
        return dao;
    }

    public void setDao(ControlDao<Book> dao) {
        this.dao = dao;
    }

    public ControlDao<Bill> getBillDao() {
        return billDao;
    }

    public void setBillDao(ControlDao<Bill> billDao) {
        this.billDao = billDao;
    }
}

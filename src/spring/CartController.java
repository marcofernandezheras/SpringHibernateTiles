package spring;

import control.ControlDao;
import control.ModelException;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AjaxCartResponse add(@RequestBody Book bookToAdd){
        AjaxCartResponse response = new AjaxCartResponse();
        try {
            Optional<Book> bookOptional = dao.search(bookToAdd.getId());
            if(bookOptional.isPresent()){
                Book book = bookOptional.get();
                Optional<BillDetail> detail = bill.getDetails().stream()
                        .filter(d -> d.getTitle().equalsIgnoreCase(book.getTitle()))
                        .findFirst();
                if(detail.isPresent()){
                    detail.get().setAmount(detail.get().getAmount() + 1);
                    response.setLineAmount(detail.get().getAmount());
                }
                else{
                    BillDetail billDetail = new BillDetail();
                    billDetail.setAmount(1);
                    billDetail.setTitle(book.getTitle());
                    billDetail.setPrice(book.getPrice());
                    bill.getDetails().add(billDetail);
                }
                response.setCode(AjaxCartResponse.OK_CODE);
                response.setCartAmount(bill.count());
                response.setTotal(bill.total());
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/remove", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AjaxCartResponse remove(@RequestBody Book bookToRemove) {
        AjaxCartResponse response = new AjaxCartResponse();
        Optional<BillDetail> detail = bill.getDetails().stream()
                .filter(d -> d.getTitle().equalsIgnoreCase(bookToRemove.getTitle()))
                .findFirst();
        if (detail.isPresent()) {
            detail.get().setAmount(detail.get().getAmount() - 1);
            response.setLineAmount(detail.get().getAmount());
            response.setSubtotal(detail.get().total());
            bill.getDetails().removeIf(c -> c.getAmount() == 0);
        }
        response.setCode(AjaxCartResponse.OK_CODE);
        response.setCartAmount(bill.count());
        response.setTotal(bill.total());
        return response;
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

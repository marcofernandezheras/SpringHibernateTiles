package spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Marco A. Fernández Heras on 29/02/16.
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/index"})
    public String index(){
        return "index";
    }
}

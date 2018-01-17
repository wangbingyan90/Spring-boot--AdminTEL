package wby.SpeingBoot.Controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wby.SpeingBoot.bean.Admin;

import javax.servlet.http.HttpSession;

@Controller
@EnableAutoConfiguration
public class AdminController {
    @RequestMapping("/admin")
    public String articlePage(Model model, HttpSession session){
        if(session.getAttribute("user") == null)
            return "login";
        Admin use = (Admin) session.getAttribute("user");
        model.addAttribute("userInfo",use);
        return "admin";
    }
}

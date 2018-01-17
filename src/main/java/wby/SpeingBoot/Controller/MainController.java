package wby.SpeingBoot.Controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wby.SpeingBoot.bean.Admin;

import javax.servlet.http.HttpSession;

@Controller
@EnableAutoConfiguration
public class MainController {
    @RequestMapping("/login")
    public String login(HttpSession session, Model model){
        if(session.getAttribute("user") == null)
            return "login";
        Admin use = (Admin) session.getAttribute("user");
        model.addAttribute("userInfo",use);
        return "admin";
    }
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "login";
    }
}

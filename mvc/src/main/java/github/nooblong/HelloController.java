package github.nooblong;

import github.nooblong.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello");
        return "success";
    }

    @RequestMapping(path = "/user")
    public String postUser(User user){
        System.out.println("user: " + user);
        return "success";
    }
}

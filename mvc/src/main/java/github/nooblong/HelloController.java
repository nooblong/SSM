package github.nooblong;

import github.nooblong.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@SessionAttributes(value = {"msg"})//将 Model 中指定 属性名 的键值对保存在 session 中
@Controller
public class HelloController {
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello");
        return "success";
    }

    @RequestMapping(path = "/user")
    public String postUser(@ModelAttribute("abc") User user){
        System.out.println("user: " + user);
        return "success";
    }

    @RequestMapping(path = "/body")
    public String postBody(@RequestBody String body){
        System.out.println("body: " + body);
        return "success";
    }

    @RequestMapping(path = "/body/{id}")
    public String postBody(@RequestBody String body, @PathVariable String id){
        System.out.println("body: " + body);
        System.out.println("id: " + id);
        return "success";
    }

    @ModelAttribute
    public void showUser(String name, Map<String,User> map){
        System.out.println("showUser");
        User user = new User();
        user.setName(name);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc", user);
    }


    @RequestMapping("/attr")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes");
        model.addAttribute("msg","妹妹");
        return "success";
    }

    @RequestMapping("/getSession")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes");
        Object msg = modelMap.getAttribute("msg");
        System.out.println(msg);
        return "success";
    }
}

package github.nooblong;

import github.nooblong.domain.User;
import github.nooblong.exception.SysException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SessionAttributes(value = {"msg"})//将 Model 中指定 属性名 的键值对保存在 session 中
@Controller
public class HelloController {
    @RequestMapping(path = "/hello")
    public String sayHello() {
        System.out.println("hello");
        return "success";
    }

    @RequestMapping(path = "/user")
    public String postUser(@ModelAttribute("abc") User user) {
        System.out.println("user: " + user);
        return "success";
    }

    @RequestMapping(path = "/body")
    public String postBody(@RequestBody String body) {
        System.out.println("body: " + body);
        return "success";
    }

    @RequestMapping(path = "/body/{id}")
    public String postBody(@RequestBody String body, @PathVariable String id) {
        System.out.println("body: " + body);
        System.out.println("id: " + id);
        return "success";
    }

    @ModelAttribute
    public void showUser(String name, Map<String, User> map) {
        System.out.println("showUser");
        User user = new User();
        user.setName(name);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc", user);
    }


    @RequestMapping("/attr")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes");
        model.addAttribute("msg", "妹妹");
        return "success";
    }

    @RequestMapping("/getSession")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("getSessionAttributes");
        Object msg = modelMap.getAttribute("msg");

        System.out.println(msg);
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView");
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setName("妹妹3");
        mv.addObject("user", user);
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testAjax")
    public @ResponseBody
    User testAjax(@RequestBody User user) {
        System.out.println("testAjax");
        System.out.println(user);
        user.setDate(new Date());
        user.setAge(9);
        return user;
    }

    @RequestMapping("/upload")
    public String upload(HttpServletRequest request) throws Exception {
        System.out.println("upload");
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (file.exists()) {
            file.mkdirs();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            if (item.isFormField()) {

            } else {
                String filename = item.getName();
                System.out.println(path + " " + filename);
                item.write(new File(path,filename));
                item.delete();
            }
        }
        return "success";
    }

    @RequestMapping("/upload2")
    public String upload2(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("spring upload");
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String originalFilename = upload.getOriginalFilename();
        if (originalFilename != null) {
            upload.transferTo(new File(path,originalFilename));
        }
        return "success";
    }

    @RequestMapping("exception")
    public String testException() throws Exception{
        try {
            int a = 1/0;
        } catch (Exception e){
            e.printStackTrace();
            throw new SysException(e.getMessage());
        }
        return "success";
    }
}

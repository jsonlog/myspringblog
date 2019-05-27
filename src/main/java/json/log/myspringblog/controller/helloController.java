package json.log.myspringblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jsonlog
 * @date 2019-04-25
 */
@Controller
public class helloController {
//    @GetMapping("/myspringblog")
//    public String myspringblog(){
//        System.out.println("myspringblog-----------------");
//        return index();
//    }
//    @GetMapping("/myspringblog/{url}")
//    public String hello(@PathVariable String url){
//        System.out.println("helloController-----------------"+url);
//        return url;
//    }
//    @GetMapping("/myspringblog/blog/{url}")
//    public String blog(@PathVariable String url){
//        System.out.println("blog-----------------"+url);
//        return "blog/"+url;
//    }
//    @GetMapping("/jsonlog/index")
//    public String secondindex(){
//        System.out.println("jsonlog/index-----------------");
//        return "jsonlog/index";
//    }
    @GetMapping({"","/","/index","/home","/myspringblog","/jsonlog/home"})
    public String index(){
        System.out.println("index-----------------");
        return "redirect:/myspringblog/index.html";
    }
}

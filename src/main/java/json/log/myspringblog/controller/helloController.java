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
    @GetMapping("/blog/{url}")
    public String hello(@PathVariable String url){
        System.out.println(url+"-----------------");
        return url;
    }
}

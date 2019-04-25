package json.log.myspringblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jsonlog
 * @date 2019-04-25
 */
@Controller
public class helloController {
    @GetMapping("/hello")
    public String index(){
        return "hello"; //当浏览器输入/index时，会返回 /static/home.html的页面
    }
}

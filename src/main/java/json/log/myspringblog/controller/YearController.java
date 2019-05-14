package json.log.myspringblog.controller;

import json.log.myspringblog.domain.Foreveryear;
import json.log.myspringblog.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @RestController:spring mvc的注解，
 * 相当于@Controller与@ResponseBody的合体，可以直接返回json
 *
 *
这个类其实就是开发中，开发一个spring-boot程序的最基本最常用的方式。（在微服务应用中，用到类似于"Java企业应用开发实践"系列中的父子模块开发，之后再说）
相对于ssm而言，spring-boot的读取属性文件的方式也相当容易，读取属性文件常用的三种方式
使用FileUtil去读：见第一章 属性文件操作工具类
使用如上的注解实现（最推荐的方式）
使用Environment这个类来获取就行

 */
/**
 * @author jsonlog
 * @date 2019-05-13
 */
@RestController
public class YearController {
    @Autowired
    private YearService yearService;

    @RequestMapping("/getyear")
    public Foreveryear getyear(){ return yearService.getYear();}

    @RequestMapping("/foreveryear")
    @ResponseBody
    public List<Foreveryear> foreveryear(){return yearService.select();}


    @RequestMapping(value="/foreveryear",method= RequestMethod.POST)
    public int addUser(@RequestBody List<Foreveryear> years) {
        return yearService.addYear(years);
    }
}

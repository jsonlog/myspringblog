package json.log.myspringblog.controller;

import json.log.myspringblog.domain.Foreveryear;
import json.log.myspringblog.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}

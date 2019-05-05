package json.log.myspringblog.controller;

import json.log.myspringblog.domain.Fest;
import json.log.myspringblog.mapper.FestMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author jsonlog
 * @date 2019-05-04
 */
public class FestController {
    @Autowired
    private FestMapper festMapper;

    @RequestMapping("fest")
    public List<Fest> getFest(Date date){
        return festMapper.selectFestByMonth(date);
    }

    @RequestMapping(path="/fest", method = RequestMethod.POST)
    @ResponseBody
    public String index(@RequestBody Fest fest){
        System.out.println(fest);
        return "日期 "+fest.getCal()+" 安排"+fest.getTiming();
    }
    /*
    curl -XPOST 'http://127.0.0.1:8080/fest' -H 'content-Type:application/json' -d'
    {
    "cal":"2019-05-01",
    "timing":"work"
    }
    '
     */
    //TODO restful @RequestMapping(value = "{id}") PUT DELETE
}

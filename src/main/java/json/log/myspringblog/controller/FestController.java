package json.log.myspringblog.controller;

import json.log.myspringblog.domain.Fest;
import json.log.myspringblog.mapper.FestMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author jsonlog
 * @date 2019-05-04
 */
@RestController
public class FestController {
    @Autowired //java.lang.NullPointerException
    private FestMapper festMapper;

    @RequestMapping(path="/fest", method = RequestMethod.POST)
    public List<Fest> getFest(HttpServletRequest request){
        System.out.println("test");
        String dateString = request.getParameter("date");
        SimpleDateFormat sdf = new SimpleDateFormat();//"yyyy-MM-dd");//, <span style="color: #FF0000;"> Locale.US</span>);
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        try{
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        return festMapper.selectFestByMonth(date);
    }
    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    @ResponseBody
    public List<Fest> ajax(@RequestParam("date") Date date){
        return festMapper.selectFestByMonth(date);
    }
//    public Map<String,String> ajax(@RequestParam("date") Date date){
//        List<Fest> fests = new ArrayList<Fest>();
//        List<Fest> festsMapper = festMapper.selectFestByMonth(date);
//        if(festsMapper != null) fests = festsMapper;
//        Map<String, String> map=new HashMap<String, String>();
//        map.put("name", "zz");
//        map.put("city", "fujian");
//        System.out.println(date);
//        return map;
//    }

//    @RequestMapping(path="/fest", method = RequestMethod.POST)
//    @ResponseBody
//    public String index(@RequestBody Fest fest){
//        System.out.println(fest);
//        return "日期 "+fest.getCal()+" 安排"+fest.getTiming();
//    }
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

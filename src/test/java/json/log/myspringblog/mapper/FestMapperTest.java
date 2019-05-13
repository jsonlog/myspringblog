package json.log.myspringblog.mapper;

import json.log.myspringblog.domain.Foreveryear;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import json.log.myspringblog.domain.Fest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Tests for {@link FestMapper}.
 * @author jsonlog
 * @date 2019-04-30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FestMapperTest {

    @Autowired
    private FestMapper festMapper;

    @Autowired
    private ForEveryearMapper forEveryearMapper;

    SimpleDateFormat smft=new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void select() throws Exception {
        List<Foreveryear> years = forEveryearMapper.select();
        System.out.println(years);
    }
    @Test
    public void selectxml() throws Exception {
        List<Foreveryear> years = forEveryearMapper.selectForeveryear();
        System.out.println(years);
    }

    @Test
    public void testDelete() throws Exception {
        Fest fest = festMapper.getOne(1l);
        System.out.println(fest.getCal().toString());
        festMapper.delete(1l);
        Assert.assertTrue(festMapper.getOne(1l) == null);
    }

    @Test
    public void testInsert() throws Exception {
//        Calendar calendar=Calendar.getInstance();
//        String nowString=smft.format(calendar.getTime());
        System.out.println(smft.parse("2019-04-12"));
        festMapper.insert(new Fest(smft.parse("2019-05-03"), "test"));
//        festMapper.insert(new Fest(smft.parse("2019-04-12"), "work"));
        System.out.println(festMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<Fest> Fests = festMapper.getAll();
        festToString(Fests);
        Fests = festMapper.selectFestByTiming("rest");
        festToString(Fests);
        Fests = festMapper.selectFestByCal(smft.parse("2019-04-12"));
        festToString(Fests);
    }

    @Test
    public void testQueryMonth() throws Exception {
        List<Fest> Fests = festMapper.selectFestByMonth(smft.parse("2018-01-01"));
        festToString(Fests);
    }

    public void festToString(List<Fest> Fests){
        if(Fests==null || Fests.size()==0){
            System.out.println("fest is null");
        }else{
            System.out.println(Fests.toString());
        }
    }

    @Test
    public void testUpdate() throws Exception {
        Fest fest = festMapper.getOne(2l);
        System.out.println(fest.toString());
        fest.setTiming("testwork");
        festMapper.update(fest);
        Assert.assertTrue((festMapper.getOne(2l).getTiming().contains("test")));
    }
}
package json.log.myspringblog.mapper;

import org.junit.Assert;
import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

//import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
//import json.log.myspringblog.mapper.FestMapper;
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
//@ExtendWith(SpringExtension.class)
//@MybatisTest
public class FestMapperTest {

    @Autowired
    private FestMapper festMapper;

    @Test
    public void testInsert() throws Exception {
//        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat smft=new SimpleDateFormat("yyyy-MM-dd");
//        String nowString=smft.format(calendar.getTime());
        festMapper.insert(new Fest(smft.parse("2019-04-01"), "rest"));
        festMapper.insert(new Fest(smft.parse("2019-04-12"), "birth"));

//        Assert.assertEquals(2, festMapper.getAll().size());
        System.out.println(festMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<Fest> Fests = festMapper.getAll();
        if(Fests==null || Fests.size()==0){
            System.out.println("is null");
        }else{
            System.out.println(Fests.toString());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        Fest fest = festMapper.getOne(1l);
        System.out.println(fest.toString());
        fest.setTiming("testwork");
        festMapper.update(fest);
        Assert.assertTrue((festMapper.getOne(1l).getTiming().contains("test")));
    }

}
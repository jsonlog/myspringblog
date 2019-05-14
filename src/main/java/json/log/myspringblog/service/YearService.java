package json.log.myspringblog.service;

import json.log.myspringblog.dao.ForevevyearDao;
import json.log.myspringblog.domain.Foreveryear;
import json.log.myspringblog.mapper.ForEveryearMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jsonlog
 * @date 2019-05-13
 */
@Service
public class YearService {
    @Autowired
    private Foreveryear year;

    @Autowired
    private ForevevyearDao forevevyearDao;

    public Foreveryear getYear() {
        return year;
    }

    public List<Foreveryear> select(){
        return forevevyearDao.select();
    }

    public int addYear(List<Foreveryear> years){
        return forevevyearDao.insertForeveryear(years);
    }
}

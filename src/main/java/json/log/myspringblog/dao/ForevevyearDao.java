package json.log.myspringblog.dao;

import json.log.myspringblog.domain.Foreveryear;
import json.log.myspringblog.mapper.ForEveryearMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jsonlog
 * @date 2019-05-13
 */
@Repository
public class ForevevyearDao {
    @Autowired
    private ForEveryearMapper yearMapper;

    public List<Foreveryear> select(){return yearMapper.select();}
}

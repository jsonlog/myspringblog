package json.log.myspringblog.mapper;

import json.log.myspringblog.domain.Foreveryear;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jsonlog
 * @date 2019-05-13
 */
public interface ForEveryearMapper {
    @Select("select * from foreveryear")
    public List<Foreveryear> select();

    public List<Foreveryear> selectForeveryear();
}

package json.log.myspringblog.mapper;

import json.log.myspringblog.domain.Foreveryear;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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

    @Insert("INSERT INTO foreveryear(timing, month, day, solar) VALUES(#{p1},#{p2},#{p3},#{p4})")
    public int insertYear(@Param("p1") String timing, @Param("p2") int month, @Param("p3") int day, @Param("p4") boolean solar);
}

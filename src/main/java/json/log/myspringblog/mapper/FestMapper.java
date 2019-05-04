package json.log.myspringblog.mapper;

import json.log.myspringblog.domain.Fest;

import java.util.Date;
import java.util.List;

/**
 * @author jsonlog
 * @date 2019-04-30
 */
public interface FestMapper {

    List<Fest> getAll();

    Fest getOne(Long id);

    void insert(Fest fest);

    void update(Fest fest);

    void delete(Long id);

    Fest selectFestByTiming(Date timing);

}
package json.log.myspringblog;

import org.mybatis.spring.annotation.MapperScan;
import json.log.myspringblog.mapper.FestMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@MapperScan("json.log.myspringblog.mapper")
public class MyspringblogApplication{//  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyspringblogApplication.class, args);
    }

//    private final FestMapper festMapper;
//    public MyspringblogApplication(FestMapper festMapper) {
//        this.festMapper = festMapper;
//    }
//
//    @Override
//    @SuppressWarnings("squid:S106")
//    public void run(String... args) {
//        System.out.println(this.festMapper.selectFestByTiming(new Date()));
//    }
}

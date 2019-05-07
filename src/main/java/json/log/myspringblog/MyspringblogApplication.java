package json.log.myspringblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("json.log.myspringblog.mapper")
public class MyspringblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyspringblogApplication.class, args);
        System.out.println("MyspringblogApplication");
    }
}

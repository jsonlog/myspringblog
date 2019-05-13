package json.log.myspringblog.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties(prefix="user")
 * 自动读取application.properties（是spring-boot默认查找的文件）文件中的user.*的属性
 * 在没有使用@ConfigurationProperties的情况下，可以使用@Value("${user.id}")来一个个指定属性的值
 *
 * 注意：如果要使用@ConfigurationProperties和@Value，需要将该bean添加@Component，
 * 因为在后边的对该类的使用中，需要直接将该类使用@Autowire注解注入，这样这些属性的自动注入才起作用，
 * 具体使用查看"UserService"
 *
该类就是一个普通的model，在ssm框架中我们并没有将这样的model归给spring容器去管理，在这里使用@Component注解将其交由spring容器去处理，这样在之后的使用中，就可以直接将该model注入到其使用类中。
在该类上添加了@ConfigurationProperties(prefix="user")注解，这样的意思就是可以自动扫描application.properties文件相关前缀的配置，并根据名称配置到该类的每一个属性上去
也可以在属性上使用@Value注解单独复值，当然前提是没有配置@ConfigurationProperties，如果配置了，@Value注解失效
 */

/**
 * @author jsonlog
 * @date 2019-05-13
 */
@Component
//@ConfigurationProperties(prefix="foreveryear")
public class Foreveryear {

    //@Value("${user.id}")
    private int id;

    //@Value("wa")
    private String timing;

    private int month;

    private int day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
package json.log.myspringblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author jsonlog
 * @date 2019-05-13
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //addResourceHandler是指你想在url请求的路径
        //addResourceLocations是图片存放的真实路径
        String classes = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        String path = classes.replace("target/classes","docs");
//        try {
//            path = ResourceUtils.getURL("classpath:").getPath();
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        path = path.replace("src/main/resources","docs");
        registry.addResourceHandler("/myspringblog/**").addResourceLocations("file://"+path).addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);//file:D://User/
        System.out.println(path);
        System.out.println(classes);
    }
}
//package json.log.myspringblog.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// * @author jsonlog
// * @date 2019-05-13
// */
//@Configuration
//@EnableConfigurationProperties({ FileHanderProperties.class })
//public class FileHandleConfig extends WebMvcConfigurerAdapter {
//
//    @Autowired
//    private FileHanderProperties fileHanderProperties;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(fileHanderProperties.getResource())
//                .addResourceLocations("file:" + fileHanderProperties.getFileDir() + "//");
//        super.addResourceHandlers(registry);
//    }
//}
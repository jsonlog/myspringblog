<!--{
    "news_title" : "spring", 
    "timer" : "2019-05-19", 
    "tagslist" : "spring,spring-framework,spring-boot,source"
}-->
# [spring](https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/htmlsingle/)
brew tap pivotal/tap
brew install springboot //CLI(Command-line)
curl https://start.spring.io/starter.tgz -d style=web \
-d style=security -d name=ui | tar -xzvf -
spring init --dependencies web,security ui/ && cd ui

If you are upgrading from an earlier release of Spring Boot, check the “migration guide” on the project wiki that provides detailed upgrade instructions. Check also the “release notes” for a list of “new and noteworthy” features for each release.
```
10.3 Upgrading from an Earlier Version of Spring Boot
Properties that are added late to the environment, such as when using @PropertySource, will not be taken into account.
Once you’re done with the migration, please make sure to remove this module from your project’s dependencies.
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-properties-migrator</artifactId>
	<scope>runtime</scope>
</dependency>
```

```
13.2.2
If you do not want to use the spring-boot-starter-parent, you can still keep the benefit of the dependency management (but not the plugin management) by using a scope=import dependency, as follows:
<dependencyManagement>
	<dependencies>
		<!-- Override Spring Data release train provided by Spring Boot -->
		<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-releasetrain</artifactId>
			<version>Fowler-SR2</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-dependencies</artifactId>
			<version>2.1.6.RELEASE</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
	</dependencies>
</dependencyManagement>
```

```
13.2.3 Using the Spring Boot Maven Plugin
Spring Boot includes a Maven plugin that can package the project as an executable jar. Add the plugin to your <plugins> section if you want to use it, as shown in the following example:

<build>
	<plugins>
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
		</plugin>
	</plugins>
</build>
```

```
package com.example.myapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
```
```
-Dspring.devtools.restart.enabled=false
spring.http.log-request-details
If you don’t want property defaults to be applied you can set spring.devtools.add-properties to false in your application.properties.
System.setProperty("spring.devtools.restart.enabled", "false");

restart.exclude.companycommonlibs=/mycorp-common-[\\w\\d-\.]+\.jar
restart.include.projectcommon=/mycorp-myproj-[\\w\\d-\.]+\.jar

			<configuration>
				<excludeDevtools>false</excludeDevtools>
			</configuration>

20. Developer Tools
Spring Boot includes an additional set of tools that can make the application development experience a little more pleasant. The spring-boot-devtools module can be included in any project to provide additional development-time features. To include devtools support, add the module dependency to your build, as shown in the following listings for Maven and Gradle:

Maven. 

<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-devtools</artifactId>
		<optional>true</optional>
	</dependency>
</dependencies>
Gradle. 

configurations {
	developmentOnly
	runtimeClasspath {
		extendsFrom developmentOnly
	}
}
dependencies {
	developmentOnly("org.springframework.boot:spring-boot-devtools")
}
```
```
org.springframework.context.ApplicationListener=com.example.project.MyListener
SpringApplication.addListeners(…​) method or the SpringApplicationBuilder.listeners(…​) method.

23.5 Application Events and Listeners
An ApplicationStartingEvent is sent at the start of a run but before any processing, except for the registration of listeners and initializers.
An ApplicationEnvironmentPreparedEvent is sent when the Environment to be used in the context is known but before the context is created.
An ApplicationPreparedEvent is sent just before the refresh is started but after bean definitions have been loaded.
An ApplicationStartedEvent is sent after the context has been refreshed but before any application and command-line runners have been called.
An ApplicationReadyEvent is sent after any application and command-line runners have been called. It indicates that the application is ready to service requests.
An ApplicationFailedEvent is sent if there is an exception on startup.

```

```
23.6 Web Environment
If Spring MVC is present, an AnnotationConfigServletWebServerApplicationContext is used
If Spring MVC is not present and Spring WebFlux is present, an AnnotationConfigReactiveWebServerApplicationContext is used
Otherwise, AnnotationConfigApplicationContext is used

```
```
23.7 Accessing Application Arguments
If you need to access the application arguments that were passed to SpringApplication.run(…​)

    @Autowired
	public MyBean(ApplicationArguments args) {
		boolean debug = args.containsOption("debug");
		List<String> files = args.getNonOptionArgs();
		// if run with "--debug logfile.txt" debug=true, files=["logfile.txt"]
	}
```
```
23.8 Using the ApplicationRunner or CommandLineRunner
If you need to run some specific code once the SpringApplication has started, you can implement the ApplicationRunner or CommandLineRunner interfaces. Both interfaces work in the same way and offer a single run method, which is called just before SpringApplication.run(…​) completes.
@Component
public class MyBean implements CommandLineRunner {

	public void run(String... args) {
		// Do something...
	}

}
```
```
23.9 Application Exit
@SpringBootApplication
public class ExitCodeApplication {

	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
		return () -> 42;
	}

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(ExitCodeApplication.class, args)));
	}

}
```
```
23.10 Admin Features
It is possible to enable admin-related features for the application by specifying the spring.application.admin.enabled property. This exposes the SpringApplicationAdminMXBean on the platform MBeanServer. You could use this feature to administer your Spring Boot application remotely. This feature could also be useful for any service wrapper implementation.

[Tip]
If you want to know on which HTTP port the application is running, get the property with a key of local.server.port.
```
```
24. Externalized Configuration
SpringApplication.setDefaultProperties
you could use the following line in a UN*X shell:

$ SPRING_APPLICATION_JSON='{"acme":{"name":"test"}}' java -jar myapp.jar
In the preceding example, you end up with acme.name=test in the Spring Environment. You can also supply the JSON as spring.application.json in a System property, as shown in the following example:

$ java -Dspring.application.json='{"name":"test"}' -jar myapp.jar
You can also supply the JSON by using a command line argument, as shown in the following example:

$ java -jar myapp.jar --spring.application.json='{"name":"test"}'
You can also supply the JSON as a JNDI variable, as follows: java:comp/env/spring.application.json.
```
```
24.1 Configuring Random Values
The RandomValuePropertySource is useful for injecting random values (for example, into secrets or test cases). It can produce integers, longs, uuids, or strings, as shown in the following example:

my.secret=${random.value}
my.number=${random.int}
my.bignumber=${random.long}
my.uuid=${random.uuid}
my.number.less.than.ten=${random.int(10)}
my.number.in.range=${random.int[1024,65536]}
```
```
24.2 Accessing Command Line Properties
If you do not want command line properties to be added to the Environment, you can disable them by using SpringApplication.setAddCommandLineProperties(false).
```
```
24.2 Accessing Command Line Properties
If you do not want command line properties to be added to the Environment, you can disable them by using SpringApplication.setAddCommandLineProperties(false).
```
```
spring.profiles.active
app.name=MyApp
app.description=${app.name} is a Spring Boot application
24.3 Application Property Files
$ java -jar myproject.jar --spring.config.name=myproject
$ java -jar myproject.jar --spring.config.location=classpath:/default.properties,classpath:/override.properties
spring.config.additional-location are searched before the default locations.Config locations are searched in reverse order. 
```

```24.7.1 Loading YAML

YAML lists are represented as property keys with [index] dereferencers. For example, consider the following YAML:

my:
servers:
	- dev.example.com
	- another.example.com
The preceding example would be transformed into these properties:

my.servers[0]=dev.example.com
my.servers[1]=another.example.com
```






# [spring-boot-starter](https://github.com/spring-projects/spring-boot/tree/v2.1.6.RELEASE/spring-boot-project/spring-boot-starters)


# ejb

# aop

# ioc

# guides 
- @SpringBootApplication = @EnableAutoConfiguration @EnableWebMvc @ComponentScan(controller)  @Configuration(bean)
- @RestController = @Controller and @ResponseBody
- @EnableAutoConfiguration(exclude={*.class}) //excludeName //spring.autoconfigure.exclude
- @RequestMapping("/")
- @GetMapping
- @PostMapping
- @ComponentScan = @Component +
- @Import({ MyConfig.class, MyAnotherConfig.class }) = @Component
- @ImportResource xml
- @Autowired(constructor injection)(If a bean has one constructor, you can omit)
- @Component = other
- @Service
- @Repository
- @Controller
- @ConfigurationProperties
- @PropertySource(YAML files cannot be loaded by using the @PropertySource annotation.)
- @TestPropertySource
- @SpringBootTest
- @Value("${name}")

- @EnableScheduling
- @Scheduled(fixedRate = 5000)
- @Scheduled(cron = "0 0/1 * * * ? ")
    <!--
     * CronTrigger配置格式:
     格式: [秒] [分] [小时] [日] [月] [周] [年]
     序号 说明 是否必填 允许填写的值 允许的通配符
     1   秒    是      0-59 ,         - * /
     2    分    是      0-59 ,        - * /
     3    小时  是      0-23 ,       - * /
     4    日    是      1-31 ,      - * ? / L W
     5    月    是    1-12 or JAN-DEC , - * /
     6    周     是     1-7 or SUN-SAT , - * ? / L #
     7    年     否     empty 或 1970-2099 , - * /
     通配符说明:
     * 表示所有值. 例如:在分的字段上设置 "*",表示每一分钟都会触发。
     ? 表示不指定值。使用的场景为不需要关心当前设置这个字段的值。例如:要在每月的10号触发一个操作，但不关心是周几，所以需要周位置的那个字段设置为"?" 具体设置为 0 0 0 10 * ?
     - 表示区间。例如在小时上设置 "10-12",表示 10,11,12点都会触发。
     , 表示指定多个值，例如在周字段上设置 "MON,WED,FRI" 表示周一，周三和周五触发
     / 用于递增触发。如在秒上面设置"5/15" 表示从5秒开始，每增15秒触发(5,20,35,50)。 在月字段上设置'1/3'所示每月1号开始，每隔三天触发一次。
     L 表示最后的意思。在日字段设置上，表示当月的最后一天(依据当前月份，如果是二月还会依据是否是润年[leap]), 在周字段上表示星期六，相当于"7"或"SAT"。如果在"L"前加上数字，则表示该数据的最后一个。例如在周字段上设置"6L"这样的格式,则表示“本 月最后一个星期五"
     W 表示离指定日期的最近那个工作日(周一至周五). 例如在日字段上设置"15W"，表示离每月15号最近的那个工作日触发。如果15号正好是周六，则找最近的周五(14号)触发, 如果15号是周未，则找最近的下周一(16号)触发.如果15号正好在工作日(周一至周五)，则就在该天触发。如果指定格式为 "1W",它则表示每月1号往后最近的工作日触发。如果1号正是周六，则将在3号下周一触发。(注，"W"前只能设置具体的数字,不允许区间"-").
     小提示
     'L'和 'W'可以一组合使用。如果在日字段上设置"LW",则表示在本月的最后一个工作日触发(一般指发工资 )
     # 序号(表示每月的第几个周几)，例如在周字段上设置"6#3"表示在每月的第三个周六.注意如果指定"#5",正好第五周没有周六，则不会触发该配置(用 在母亲节和父亲节再合适不过了)
     小提示
     周字段的设置，若使用英文字母是不区分大小写的 MON 与mon相同.
     常用示例:
     0 0 12 * * ? 每天12点触发
     0 15 10 ? * * 每天10点15分触发
     0 15 10 * * ? 每天10点15分触发
     0 15 10 * * ? * 每天10点15分触发
     0 15 10 * * ? 2005 2005年每天10点15分触发
     0 * 14 * * ? 每天下午的 2点到2点59分每分触发
     0 0/5 14 * * ? 每天下午的 2点到2点59分(整点开始，每隔5分触发)
     0 0/5 14,18 * * ? 每天下午的 2点到2点59分(整点开始，每隔5分触发) 每天下午的 18点到18点59分(整点开始，每隔5分触发)
     0 0-5 14 * * ? 每天下午的 2点到2点05分每分触发
     0 10,44 14 ? 3 WED 3月分每周三下午的 2点10分和2点44分触发
     0 15 10 ? * MON-FRI 从周一到周五每天上午的10点15分触发
     0 15 10 15 * ? 每月15号上午10点15分触发
     0 15 10 L * ? 每月最后一天的10点15分触发
     0 15 10 ? * 6L 每月最后一周的星期五的10点15分触发
     0 15 10 ? * 6L 2002-2005 从2002年到2005年每月最后一周的星期五的10点15分触发
     0 15 10 ? * 6#3 每月的第三周的星期五开始触发
     0 0 12 1/5 * ? 每月的第一个中午开始每隔5天触发一次
     0 11 11 11 11 ? 每年的11月11号 11点11分触发
     参考网址：http://blog.csdn.net/irencewh/article/details/45332295（出处没找到）
     -->

- @RunWith(SpringRunner.class)
- @SpringBootTest
- @Entity is a JPA annotation to make this object ready for storage in a JPA-based data store.


- @Slf4j is a Lombok annotation to autocreate an Slf4j-based LoggerFactory as log, allowing us to log these newly created "employees".
- @Data is a Lombok annotation to create all the getters, setters, equals, hash, and toString methods, based on the fields.

# gradle 
- apply plugin: 'java'
- apply plugin: 'io.spring.dependency-management'


# application.properties
spring.servlet.multipart.max-file-size=128KB
spring.servlet.multipart.max-request-size=128KB

# schema-@@platform@@.sql
- -all is the default for all platforms.

# Web Services 
基于REST的软件体系结构风格RESTful（Software Architecture Style）称之为面向资源体系架构（Resource-oriented Architecture，ROA）
WSDL 指网络服务描述语言 (Web Services Description Language)。 WSDL 是一种使用 XML编写的文档.     
SOAP 简单对象访问协议(Simple Object Access Protocol)一种简单的基于 XML 的协议，它使应用程序通过 HTTP 来交换信息。可以传递结构化的 数据,要进行xml解析.      
XML-RPC

#other
Collections.singletonMap("message", "Hello World")
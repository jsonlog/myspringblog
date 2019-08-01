<!--{
    "news_title" : "springboot", 
    "timer" : "2019-05-19", 
    "tagslist" : "spring,spring-boot,source"
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
```
24.8.2 Relaxed Binding
acme:
  map:
    "[/key1]": value1
    "[/key2]": value2
    /key3: value3
The properties above will bind to a Map with /key1, /key2 and key3 as the keys in the map.

```
```
--trace flag (or trace=true)
spring.output.ansi.enabled
%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){yellow}
logging.file.max-size
logging.file.max-history
logging.level.root=WARN
logging.level.org.springframework.web=DEBUG
logging.level.org.hibernate=ERROR
logging.group.tomcat=org.apache.catalina, org.apache.coyote, org.apache.tomcat
logging.level.tomcat=TRACE
the LOG_LEVEL_PATTERN (or logging.pattern.level with Logback)

26. Logging

logback,Java Util Logging, Commons Logging, Log4J, or SLF4J 

```
```
27. Internationalization

spring.messages.basename=messages,config.i18n.messages
spring.messages.fallback-to-system-locale=false
```
```
28. JSON
Spring Boot provides integration with three JSON mapping libraries:

Gson
Jackson
JSON-B
```
```
29.1.4 MessageCodesResolver
Spring MVC has a strategy for generating error codes for rendering error messages from binding errors: MessageCodesResolver. If you set the spring.mvc.message-codes-resolver.format property PREFIX_ERROR_CODE or POSTFIX_ERROR_CODE, Spring Boot creates one for you (see the enumeration in DefaultMessageCodesResolver.Format).
```
```
29.1.5 Static Content
spring.mvc.static-path-pattern=/resources/**
spring.resources.static-locations
spring.resources.chain.strategy.content.enabled=true
spring.resources.chain.strategy.content.paths=/**
spring.resources.chain.strategy.fixed.enabled=true
spring.resources.chain.strategy.fixed.paths=/js/lib/
spring.resources.chain.strategy.fixed.version=v12
```
```
29.1.8 Path Matching and Content Negotiation
spring.mvc.contentnegotiation.favor-parameter=true

# We can change the parameter name, which is "format" by default:
# spring.mvc.contentnegotiation.parameter-name=myparam

# We can also register additional file extensions/media types with:
spring.mvc.contentnegotiation.media-types.markdown=text/markdown

# You can also register additional file extensions/media types with:
# spring.mvc.contentnegotiation.media-types.adoc=text/asciidoc
```
```
30.3.1 Client
spring.security.oauth2.client.registration.my-client-1.client-id=abcd
spring.security.oauth2.client.registration.my-client-1.client-secret=password
spring.security.oauth2.client.registration.my-client-1.client-name=Client for user scope
spring.security.oauth2.client.registration.my-client-1.provider=my-oauth-provider
spring.security.oauth2.client.registration.my-client-1.scope=user
spring.security.oauth2.client.registration.my-client-1.redirect-uri-template=https://my-redirect-uri.com
spring.security.oauth2.client.registration.my-client-1.client-authentication-method=basic
spring.security.oauth2.client.registration.my-client-1.authorization-grant-type=authorization_code

spring.security.oauth2.client.registration.my-client-2.client-id=abcd
spring.security.oauth2.client.registration.my-client-2.client-secret=password
spring.security.oauth2.client.registration.my-client-2.client-name=Client for email scope
spring.security.oauth2.client.registration.my-client-2.provider=my-oauth-provider
spring.security.oauth2.client.registration.my-client-2.scope=email
spring.security.oauth2.client.registration.my-client-2.redirect-uri-template=https://my-redirect-uri.com
spring.security.oauth2.client.registration.my-client-2.client-authentication-method=basic
spring.security.oauth2.client.registration.my-client-2.authorization-grant-type=authorization_code

spring.security.oauth2.client.provider.my-oauth-provider.authorization-uri=http://my-auth-server/oauth/authorize
spring.security.oauth2.client.provider.my-oauth-provider.token-uri=http://my-auth-server/oauth/token
spring.security.oauth2.client.provider.my-oauth-provider.user-info-uri=http://my-auth-server/userinfo
spring.security.oauth2.client.provider.my-oauth-provider.user-info-authentication-method=header
spring.security.oauth2.client.provider.my-oauth-provider.jwk-set-uri=http://my-auth-server/token_keys
spring.security.oauth2.client.provider.my-oauth-provider.user-name-attribute=name
```
```
33.1.2 JCache (JSR-107)
spring.cache.jcache.provider=com.acme.MyCachingProvider
spring.cache.jcache.config=classpath:acme.xml

33.1.3 EhCache 2.x
spring.cache.ehcache.config=classpath:config/another-config.xml
```
```
47. Web
<dependency>
	<groupId>javax.websocket</groupId>
	<artifactId>javax.websocket-api</artifactId>
</dependency>
spring.webservices.wsdl-locations=classpath:/wsdl
```
```
49.2 Locating Auto-configuration Candidates
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.mycorp.libx.autoconfigure.LibXAutoConfiguration,\
com.mycorp.libx.autoconfigure.LibXWebAutoConfiguration
```
```
49.4 Testing your Auto-configuration
private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
		.withConfiguration(AutoConfigurations.of(UserServiceAutoConfiguration.class));
```
```
49.5.2 autoconfigure Module
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-autoconfigure-processor</artifactId>
	<optional>true</optional>
</dependency>
dependencies {
	annotationProcessor "org.springframework.boot:spring-boot-autoconfigure-processor"
}
```
```
50.3.1 runApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyApplication

fun main(args: Array<String>) {
	runApplication<MyApplication>(*args)
}
//It also allows customization of the application as shown in the following example:
runApplication<MyApplication>(*args) {
	setBannerMode(OFF)
}
```

# Part V. Spring Boot Actuator: Production-ready features
```
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>
</dependencies>
```
```
53.1 Enabling Endpoints
management.endpoints.enabled-by-default=false
management.endpoint.info.enabled=true

53.7 Implementing Custom Endpoints
If you add a @Bean annotated with @Endpoint, any methods annotated with @ReadOperation, @WriteOperation, or @DeleteOperation are automatically exposed over JMX and, in a web application, over HTTP as well. Endpoints can be exposed over HTTP using Jersey, Spring MVC, or Spring WebFlux.

You can also write technology-specific endpoints by using @JmxEndpoint or @WebEndpoint. These endpoints are restricted to their respective technologies. For example, @WebEndpoint is exposed only over HTTP and not over JMX.

You can write technology-specific extensions by using @EndpointWebExtension and @EndpointJmxExtension. These annotations let you provide technology-specific operations to augment an existing endpoint.
53.7.2 Custom Web Endpoints
Operations on an @Endpoint, @WebEndpoint, or @EndpointWebExtension are automatically exposed over HTTP using Jersey, Spring MVC, or Spring WebFlux.

@ControllerEndpoint and @RestControllerEndpoint can be used to implement an endpoint that is only exposed by Spring MVC or Spring WebFlux. 
```
```
54.3 Configuring Management-specific SSL
When configured to use a custom port, the management server can also be configured with its own SSL by using the various management.server.ssl.* properties. For example, doing so lets a management server be available over HTTP while the main application uses HTTPS, as shown in the following property settings:

server.port=8443
server.ssl.enabled=true
server.ssl.key-store=classpath:store.jks
server.ssl.key-password=secret
management.server.port=8080
management.server.ssl.enabled=false
Alternatively, both the main server and the management server can use SSL but with different key stores, as follows:

server.port=8443
server.ssl.enabled=true
server.ssl.key-store=classpath:main.jks
server.ssl.key-password=secret
management.server.port=8080
management.server.ssl.enabled=true
management.server.ssl.key-store=classpath:management.jks
management.server.ssl.key-password=secret
```

```
mvn package
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<!-- ... -->
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<version>2.1.6.RELEASE</version>
				<executions>
					<execution>
						<goals>
							<goal>repackage</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
</project>

---
mvn package spring-boot:repackage

---
If you use a milestone or snapshot release, you also need to add the appropriate pluginRepository elements, as shown in the following listing:

<pluginRepositories>
	<pluginRepository>
		<id>spring-snapshots</id>
		<url>https://repo.spring.io/snapshot</url>
	</pluginRepository>
	<pluginRepository>
		<id>spring-milestones</id>
		<url>https://repo.spring.io/milestone</url>
	</pluginRepository>
</pluginRepositories>

---
To build a war file that is both executable and deployable into an external container, you need to mark the embedded container dependencies as “provided”, as shown in the following example:

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<!-- ... -->
	<packaging>war</packaging>
	<!-- ... -->
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>
		<!-- ... -->
	</dependencies>
</project>
```
```
78.1 Use Another Web Server
<properties>
	<servlet-api.version>3.1.0</servlet-api.version>
</properties>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
	<exclusions>
		<!-- Exclude the Tomcat dependency -->
		<exclusion>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
		</exclusion>
	</exclusions>
</dependency>
<!-- Use Jetty instead -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-jetty</artifactId>
</dependency>

---

configurations {
	// exclude Reactor Netty
	compile.exclude module: 'spring-boot-starter-reactor-netty'
}

dependencies {
	compile 'org.springframework.boot:spring-boot-starter-webflux'
	// Use Undertow instead
	compile 'org.springframework.boot:spring-boot-starter-undertow'
	// ...
}
```
```
79.2 Write an XML REST Service
If you have the Jackson XML extension (jackson-dataformat-xml) on the classpath, you can use it to render XML responses. The previous example that we used for JSON would work. To use the Jackson XML renderer, add the following dependency to your project:

<dependency>
	<groupId>com.fasterxml.jackson.dataformat</groupId>
	<artifactId>jackson-dataformat-xml</artifactId>
</dependency>
If Jackson’s XML extension is not available and JAXB is available, XML can be rendered with the additional requirement of having MyThing annotated as @XmlRootElement, as shown in the following example:

@XmlRootElement
public class MyThing {
	private String name;
	// .. getters and setters
}
JAXB is only available out of the box with Java 8. If you’re using a more recent Java generation, add the following dependency to your project:

<dependency>
	<groupId>org.glassfish.jaxb</groupId>
	<artifactId>jaxb-runtime</artifactId>
</dependency>
```
```
83. Logging

logging.level.org.springframework.web=DEBUG
logging.level.org.hibernate=ERROR
```
```
83.1 Configure Logback for Logging
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
	<include resource="org/springframework/boot/logging/logback/base.xml"/>
	<logger name="org.springframework.web" level="DEBUG"/>
</configuration>
```
```
83.1.1 Configure Logback for File-only Output
If you want to disable console logging and write output only to a file, you need a custom logback-spring.xml that imports file-appender.xml but not console-appender.xml, as shown in the following example:

<?xml version="1.0" encoding="UTF-8"?>
<configuration>
	<include resource="org/springframework/boot/logging/logback/defaults.xml" />
	<property name="LOG_FILE" value="${LOG_FILE:-${LOG_PATH:-${LOG_TEMP:-${java.io.tmpdir:-/tmp}}/}spring.log}"/>
	<include resource="org/springframework/boot/logging/logback/file-appender.xml" />
	<root level="INFO">
		<appender-ref ref="FILE" />
	</root>
</configuration>
You also need to add logging.file to your application.properties, as shown in the following example:

logging.file=myapplication.log
```
```
83.2 Configure Log4j for Logging
Spring Boot supports Log4j 2 for logging configuration if it is on the classpath. If you use the starters for assembling dependencies, you have to exclude Logback and then include log4j 2 instead. If you do not use the starters, you need to provide (at least) spring-jcl in addition to Log4j 2.

The simplest path is probably through the starters, even though it requires some jiggling with excludes. The following example shows how to set up the starters in Maven:

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter</artifactId>
	<exclusions>
		<exclusion>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-logging</artifactId>
		</exclusion>
	</exclusions>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
And the following example shows one way to set up the starters in Gradle:

dependencies {
	compile 'org.springframework.boot:spring-boot-starter-web'
	compile 'org.springframework.boot:spring-boot-starter-log4j2'
}

configurations {
	all {
		exclude group: 'org.springframework.boot', module: 'spring-boot-starter-logging'
	}
}
```
```
yyyy-MM-dd’T’HH:mm:ssZ
91.2 Generate Git Information
Both Maven and Gradle allow generating a git.properties file containing information about the state of your git source code repository when the project was built.

For Maven users, the spring-boot-starter-parent POM includes a pre-configured plugin to generate a git.properties file. To use it, add the following declaration to your POM:

<build>
	<plugins>
		<plugin>
			<groupId>pl.project13.maven</groupId>
			<artifactId>git-commit-id-plugin</artifactId>
		</plugin>
	</plugins>
</build>
Gradle users can achieve the same result by using the gradle-git-properties plugin, as shown in the following example:

plugins {
	id "com.gorylenko.gradle-git-properties" version "1.5.1"
}
```
```
91.5 Use a Spring Boot Application as a Dependency
<build>
	<plugins>
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
			<configuration>
				<classifier>exec</classifier>
			</configuration>
		</plugin>
	</plugins>
</build>
```
```
91.7 Create a Non-executable JAR with Exclusions
Often, if you have an executable and a non-executable jar as two separate build products, the executable version has additional configuration files that are not needed in a library jar. For example, the application.yml configuration file might by excluded from the non-executable JAR.

In Maven, the executable jar must be the main artifact and you can add a classified jar for the library, as follows:

<build>
	<plugins>
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
		</plugin>
		<plugin>
			<artifactId>maven-jar-plugin</artifactId>
			<executions>
				<execution>
					<id>lib</id>
					<phase>package</phase>
					<goals>
						<goal>jar</goal>
					</goals>
					<configuration>
						<classifier>lib</classifier>
						<excludes>
							<exclude>application.yml</exclude>
						</excludes>
					</configuration>
				</execution>
			</executions>
		</plugin>
	</plugins>
</build>
```
```
92.1 Create a Deployable War File
[Warning]
Because Spring WebFlux does not strictly depend on the Servlet API and applications are deployed by default on an embedded Reactor Netty server, War deployment is not supported for WebFlux applications.

The first step in producing a deployable war file is to provide a SpringBootServletInitializer subclass and override its configure method. Doing so makes use of Spring Framework’s Servlet 3.0 support and lets you configure your application when it is launched by the servlet container. Typically, you should update your application’s main class to extend SpringBootServletInitializer, as shown in the following example:

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
The next step is to update your build configuration such that your project produces a war file rather than a jar file. If you use Maven and spring-boot-starter-parent (which configures Maven’s war plugin for you), all you need to do is to modify pom.xml to change the packaging to war, as follows:

<packaging>war</packaging>
If you use Gradle, you need to modify build.gradle to apply the war plugin to the project, as follows:

apply plugin: 'war'
The final step in the process is to ensure that the embedded servlet container does not interfere with the servlet container to which the war file is deployed. To do so, you need to mark the embedded servlet container dependency as being provided.

If you use Maven, the following example marks the servlet container (Tomcat, in this case) as being provided:

<dependencies>
	<!-- … -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-tomcat</artifactId>
		<scope>provided</scope>
	</dependency>
	<!-- … -->
</dependencies>
If you use Gradle, the following example marks the servlet container (Tomcat, in this case) as being provided:

dependencies {
	// …
	providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
	// …
}
//providedRuntime is preferred to Gradle’s compileOnly configuration. Among other limitations, compileOnly dependencies are not on the test classpath, so any web-based integration tests fail.
```
```
92.2 Convert an Existing Application to Spring Boot
For a non-web application, it should be easy to convert an existing Spring application to a Spring Boot application. To do so, throw away the code that creates your ApplicationContext and replace it with calls to SpringApplication or SpringApplicationBuilder. Spring MVC web applications are generally amenable to first creating a deployable war application and then migrating it later to an executable war or jar. See the Getting Started Guide on Converting a jar to a [war](https://spring.io/guides/gs/convert-jar-to-war/).

To create a deployable war by extending SpringBootServletInitializer (for example, in a class called Application) and adding the Spring Boot @SpringBootApplication annotation, use code similar to that shown in the following example:

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// Customize the application or call application.sources(...) to add sources
		// Since our example is itself a @Configuration class (via @SpringBootApplication)
		// we actually don't need to override this method.
		return application;
	}

}
```






# [spring-boot-starter](https://github.com/spring-projects/spring-boot/tree/v2.1.6.RELEASE/spring-boot-project/spring-boot-starters)

# guides 
- @SpringBootApplication = @EnableAutoConfiguration @EnableWebMvc @ComponentScan(controller)  @Configuration(bean)
- @RestController = @Controller and @ResponseBody
- @EnableAutoConfiguration(exclude={*.class}) //excludeName //spring.autoconfigure.exclude
- @RequestMapping("/")
- @GetMapping
- @PostMapping
- @DeleteMapping
- @ComponentScan = @Component +
- @Import({ MyConfig.class, MyAnotherConfig.class }) = @Component
- @ImportResource xml
- @Autowired(constructor injection)(If a bean has one constructor, you can omit)
- @Component = other
- @Service
- @Repository
- @Controller
- @Bean
- @ConfigurationProperties(prefix="acme") @ConfigurationProperties("acme")
- @Validated
- @Valid
- @NotNull
- @NotEmpty
- @Profile("production") --spring.profiles.active=dev,hsqldb
- @EnableConfigurationProperties(AcmeProperties.class)
- @PropertySource(YAML files cannot be loaded by using the @PropertySource annotation.)
- @TestPropertySource
- @SpringBootTest
- @Value("${name}")
- @PostConstruct
- @DurationUnit(ChronoUnit.SECONDS) private Duration sessionTimeout = Duration.ofSeconds(30);
- @DataSizeUnit(DataUnit.MEGABYTES)	private DataSize bufferSize = DataSize.ofMegabytes(2);
- @JsonComponent //jackson JsonSerializer
- @ControllerAdvice(basePackageClasses = AcmeController.class)
- @ExceptionHandler(YourException.class)
- @EnableHypermediaSupport
- @EnableWebFlux //spring.webflux.static-path-pattern=/resources/**
- @Order
- @Path("/hello")
- @ApplicationPath
- @WebServlet, @WebFilter, and @WebListener can be enabled by using @ServletComponentScan.
- @EnableGlobalMethodSecurity //org.springframework.boot.autoconfigure.security  spring.security.user.name and spring.security.user.password.
- @EntityScan
- @Entity 
- @Embeddable 
- @MappedSuperclass
- @Id
- @GeneratedValue //spring.jpa.hibernate.ddl-auto=create-drop //spring.jpa.properties.hibernate.globally_quoted_identifiers=true
- @Column(nullable = false)
- @Query
- @EnableJdbcRepositories
- @NodeEntity Neo4j OGM 
- @EnableGemfireRepositories.
- @SolrDocument 
- @Document
- @EnableCaching //org.springframework.cache.CacheManager
- @CacheResult
- @JmsListener(destination = "someQueue")
- @EnableJms 
- @Qualifier()
- @EnableAsync
- @EnableScheduling
- @EnableIntegration //spring.integration.jdbc.initialize-schema=always
- @RunWith(SpringRunner.class)
- @ExtendWith(SpringExtension.class)
- @ContextConfiguration(classes=…​)
@TestConfiguration
@AutoConfigureMockMvc
@LocalServerPort
@MockBean
@SpyBean
@Cacheable 
@ImportAutoConfiguration#exclude
@…​Test annotations provide an excludeAutoConfiguration attribute
@JsonTest
@JsonComponent
@WebMvcTest
@AutoConfigureWebTestClient
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@JdbcTest
@DataJdbcTest
@DataNeo4jTest
@AutoConfigureRestDocs
@EnableBatchProcessing
@Rule //JUnit
@Conditional
@ConditionalOnResource
@ConditionalOnClass
@ConditionalOnMissingBean
@AutoConfigureBefore
@AutoConfigureAfter
@AutoConfigureOrder
@ConditionalOnProperty
@ConditionalOnWebApplication
@ConditionalOnNotWebApplication
@ConditionalOnExpression
@RequestParam
@Primary
@EnableBatchProcessing
@DeprecatedConfigurationProperty(replacement = "app.acme.name")
@Deprecated
@Description("Provides a basic example of a bean")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)


@WithMockUser(roles="ADMIN")
WebMvcAutoConfiguration
ThymeleafAutoConfiguration
FreeMarkerAutoConfiguration
GroovyTemplateAutoConfiguration




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

这个注释类型本省也被注释了，这种注释叫做元注释。第一个注释 (@Retention(RetentionPolicy.RUNTIME))表示这种类型的注释被VM保留从而使其能够通过反射在运行时读取；第二个注释@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})表示该标签可以用于构造函数、方法、参数、标签上

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

# other
Collections.singletonMap("message", "Hello World")

# LDAP
o：organization（组织-公司）
ou：organization unit（组织单元-部门）
inetOrgPerson
c：countryName（国家）
dc：domainComponent（域名）
sn：surname（姓氏）
cn：common name（常用名称）
DN （Distinguished Name）是用来引用条目的
uid : user id
条目 表
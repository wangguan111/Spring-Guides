# Spring-Guides
Whatever you're building, these guides are designed to get you productive as quickly as possible

1.Building a RESTful Web Service

	project demo

	url:http://localhost:8080/greeting
		http://localhost:8080/greeting?name=User

	1.A resource representation class,a resource controller
	A key difference between a traditional MVC controller and the RESTful web service controller above is the way 
	that the HTTP response body is created. Rather than relying on a view technology to perform server-side 
	rendering of the greeting data to HTML, this RESTful web service controller simply populates and returns 
	a Greeting object. The object data will be written directly to the HTTP response as JSON.
		@RestController
	2.Mock
		@AutoConfigureMockMvc	


2.Scheduling Tasks 

	project demo

	1.@EnableScheduling ensures that a background task executor is created. Without it, nothing gets scheduled.
		@EnableScheduling
		@Scheduled(fixedRate = 5000)
	2.@
		@Component = <bean id="" class=""/>）in xml


3.Consuming a RESTful Web Service
	
	To consume a REST web service, RestTemplate makes interacting with most RESTful services a one-line incantation.
	it can even bind that data to custom domain types.

	project rest-template

	1.@JsonIgnoreProperties(ignoreUnknown = true)
	2.@Bean
	3.CommandLineRunner
	4.RestTemplate
		RestTemplateBuilder
		RestTemplate.getForObject


4.Building Java Projects with Gradle 

	none


5.Building Java Projects with Maven 

	none


6.Accessing Relational Data using JDBC with Spring

	Store and retrieve data by JdbcTemplate and H2

	project jdbc
	
	1.compile("com.h2database:h2")
	2.Arrays.asList
	3.jdbcTemplate
		jdbcTemplate.execute
		jdbcTemplate.batchUpdate
		jdbcTemplate.query


7.Uploading Files

	a file upload controller

	project uploading

	url:http://localhost:8080

	1.@ConfigurationProperties("storage") + StorageProperties.location="upload-dir" 
	2.@Controller + @ResponseBody + ResponseEntity
		esponseEntity.ok().header().body()
	3.RedirectAttributes.addFlashAttribute
	4.@ExceptionHandler
	5.@AutoConfigureMockMvc + MockMvc + @MockBean
	

8.Authenticating a User with LDAP

	project ldap

	url:http://localhost:8080

	1.username = ben and password = benspassword.
	2.HttpSecurity
		http
			.authorizeRequests()
				.antMatchers("/", "/home").permitAll()	/and/hone no need authenticated
				.anyRequest().fullyAuthenticated()	all no need authenticated	
				.anyRequest().authenticated() all need authenticated
				.and()
			.formLogin()
				.loginPage("/login")
				 .permitAll()
				 .and()
		    .logout()
	3.ldapAuthentication
		auth
			.ldapAuthentication()
				.userDnPatterns("uid={0},ou=people")
				.groupSearchBase("ou=groups")
				.contextSource()
					.url("ldap://localhost:8389/dc=springframework,dc=org")
					.and()
				.passwordCompare()
					.passwordEncoder(new LdapShaPasswordEncoder())
					.passwordAttribute("userPassword");
	4.config
	spring.ldap.embedded.ldif=classpath:test-server.ldif
	spring.ldap.embedded.base-dn=dc=springframework,dc=org
	spring.ldap.embedded.port=8389


9.Messaging with Redis

	project redis

	A connection factory + A message listener container + A Redis template
	The connection factory drives both the template and the message listener container,
	enabling them to connect to the Redis server

	MessageListenerAdapter + RedisConnectionFactory -> RedisMessageListenerContainer -> StringRedisTemplate

	1.CountDownLatch
	2.MessageListenerAdapter
	3.RedisMessageListenerContainer
	4.RedisConnectionFactory
	5.PatternTopic
	6.StringRedisTemplate
	7.ApplicationContext
	8.redis 
	Redis is an open source, BSD-licensed, key-value data store that also comes with a messaging system
	9.@Bean
	10.convertAndSend


10.Messaging with RabbitMQ

	project rabbitmq

	A message listener container + Declare the queue, the exchange, and the binding between them + 
	A component to send some messages to test the listener

	Queue + TopicExchange -> Binding -> MessageListenerAdapter + ConnectionFactory
	-> SimpleMessageListenerContainer -> RabbitTemplate

	RabbitMQ is an AMQP server.JMS queues and AMQP queues have different semantics. 
	For example, JMS sends queued messages to only one consumer. While AMQP queues do the same thing,
	AMQP producers don’t send messages directly to queues. Instead, a message is sent to an exchange,
	which can go to a single queue, or fanout to multiple queues, emulating the concept of JMS topics.

	1.Docker Compose
	2.Queue
	3.TopicExchange 
	4.Binding 
	5.BindingBuilder
		BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
	6.SimpleMessageListenerContainer 
	7.RabbitTemplate 
	8.TimeUnit


11.Accessing Data with Neo4j

	project neo4j

	 Using Spring Data Neo4j to build an application that stores data in and retrieves it from Neo4j, a graph-based database.


12.Validating Form Input

	project validating

	configuring a web application form to support validation

	url:http://localhost:8080

    1.@NotNull
   	2.@Min(18)
    3.@Size(min=2, max=30)
	4.@GetMapping("/")
	5.@PostMapping("/")
	6.@Valid
	7.addViewControllers


13.Building a RESTful Web Service with Spring Boot Actuator 

	project actuator
	
	url:http://localhost:9000/hello-world
		      localhost:9001/actuator/health

	1.Spring Boot Actuator:Monitoring and Management over HTTP
		management.server.port: 9001
		management.server.address: 127.0.0.1	
	2.Switch to a different server port
		server.port: 9000
	3.@RestController = @Controller + @ResponseBody(@Controller return String; @RestController return Json)
	4.Control_UT_Test 
		https://www.jianshu.com/p/72b19e24a602
		1.@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) + TestRestTemplate
		2.@WebMvcTest(controllers = xxx.class) + MockMvc 
		3.@SpringBootTest() + @AutoConfigureMockMvc + MockMvc 	
	5.@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
	6.@LocalServerPort
	7.@TestPropertySource(properties = {"management.port=0"}) + @Value("${local.management.port}")
	8.TestRestTemplate


14.Messaging with JMS

	project jms

	publishing and subscribing to messages using a JMS broker.

	MessageConverter -> ConnectionFactory + DefaultJmsListenerContainerFactoryConfigurer 
	-> DefaultJmsListenerContainerFactory ->JmsTemplate

	1.@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	2.@EnableJms
	3.JmsTemplate
	4.convertAndSend
	5.MappingJackson2MessageConverter
	6.DefaultJmsListenerContainerFactory
	7.DefaultJmsListenerContainerFactoryConfigurer
	8.ConnectionFactory
	9.JmsListenerContainerFactory
	10.MessageConverter


15.Creating a Batch Service

	project batch

	Imports data from a CSV spreadsheet, transforms it with custom code, 
	and stores the final results in a database.

	1.@EnableBatchProcessing
	2.FlatFileItemReaderBuilder<Person>()
	     .name("personItemReader")
         .resource(new ClassPathResource("sample-data.csv"))
         .delimited()
         .names(new String[]{"firstName", "lastName"})
         .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
           setTargetType(Person.class);
         }})
         .build();
	3.JdbcBatchItemWriterBuilder<Person>()
	     .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
         .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
         .dataSource(dataSource)
         .build();
    4.stepBuilderFactory.get("step1")
            .<Person, Person> chunk(10)
            .reader(reader())
            .processor(processor())
            .writer(writer)
            .build();
    5.jobBuilderFactory.get("importUserJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
     6.JobExecution 


16.Securing a Web Application

	project securing

	Creating a simple web application with resources that are protected by Spring Security.

	url:http://localhost:8080

	1.addViewControllers
	2.@EnableWebSecurity
    3.http
    	.authorizeRequests()
        	.antMatchers("/", "/home").permitAll()
        	.anyRequest().authenticated()
        	.and()
    	.formLogin()
        	.loginPage("/login")
        	.permitAll()
        	.and()
    	.logout()
        	.permitAll();
	4.User.withDefaultPasswordEncoder()
		.username("user")
		.password("password")
		.roles("USER")
		.build();
	5.InMemoryUserDetailsManager


17.Building a Hypermedia-Driven RESTful Web Service

	project hateoas
	
	url:http://localhost:8080/greeting
		http://localhost:8080/greeting?name=xx

	ResourceSupport
	@JsonCreator
	@JsonProperty
	POJO(Plain Old Java Object)
	HttpEntity<?>
	ResponseEntity<?>
	linkTo
	methodOn
	withSelfRel
	Traverson
	MediaTypes
	jsonPath


18.Accessing Data in Pivotal GemFire

	gemfire version


19.Integrating Data

	project integration

	RSS Feed


20.Caching Data with Pivotal GemFire

	gemfire version


21.Managing Transactions

	project transactions

	@Transactional
	JdbcTemplate 
	String... persons
	Assert

	
22.Accessing Data with JPA

	project jpa

	CrudRepository
	@Entity
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@DataJpaTest
	TestEntityManager


23.Accessing Data with MongoDB
	
	project mongodb

	MongoRepository
	findByFirstName
	findByLastName
	assertThat


24.Serving Web Content with Spring MVC

	project devtools
	
	url:http://localhost:8080/greeting
		http://localhost:8080/greeting?name=xx

	1.11.15 RestController vs 22 @Control
	Thymeleaf
	spring-boot-devtools


25.Converting a Spring Boot JAR Application to a WAR

	none


26.Creating Asynchronous Methods

	project asynchronous

	@Service
	RestTemplateBuilder
	@Async
	CompletableFuture
	InterruptedException
	@EnableAsync
	Executor
	ThreadPoolTaskExecutor
	getForObject


27.Handling Form Submission

	project submission

	url:http://localhost:8080/greeting

	@TestPropertySource(properties = "logging.level.org.springframework.web=DEBUG")


28.Building an Application with Spring Boot

	project boot

 	actuator/health
 	UT
 	IT


29.Using WebSocket to build an interactive web application

	project stomp

	url:http://localhost:8080

 	@MessageMapping
 	@SendTo
 	HtmlUtils.htmlEscape
 	@EnableWebSocketMessageBroker
 	WebSocketMessageBrokerConfigurer
 	configureMessageBroker
 	registerStompEndpoints
 	MessageBrokerRegistry 
 	StompEndpointRegistry 
 	CountDownLatch
 	AtomicReference
 	StompSessionHandler


 30.Working a Getting Started guide with STS

 	none


 31.Consuming a RESTful Web Service with AngularJS

 	AngularJS


 32.Consuming a RESTful Web Service with rest.js

 	rest.js


 33.Consuming a RESTful Web Service with jQuery

 	jQuery


 34.Enabling Cross Origin Requests for a RESTful Web Service
 
 	project cros

	url:http://localhost:8080/greeting
		http://localhost:8080/greeting?name=xx
		http://localhost:9000

 	@CrossOrigin(origins = "http://localhost:9000")
 	WebMvcConfigurer
 	CorsRegistry
 	@GetMapping = @RequestMapping(method = RequestMethod.GET)


 35.Building Spring YARN Projects with Gradle

 	project yarn

 	settings.gradle
 	build.gradle


 36.Building Spring YARN Projects with Maven

 	project yarn

 	pom.xml
 	assembly.xml


 37.Simple YARN Application

  	project yarn


 38.Testing YARN Application

  	project yarn
  	

 39.Batch YARN Application


 40.Restartable Batch YARN Application


 41.Consuming a SOAP web service

 	cannot access the soap web service


 42.Accessing JPA Data with REST

 	project jpa_rest

 	@RepositoryRestResource(collectionResourceRel = "people", path = "people")
 	PagingAndSortingRepository


 43.Accessing Neo4j Data with REST

 	Neo4j
 	

 44.Accessing MongoDB Data with REST

 	project mongodb_rest

 	@RepositoryRestResource(collectionResourceRel = "people", path = "people")


 45.Accessing Data in Pivotal GemFire with REST

 	gemfire version


 46.Producing a SOAP web service

 	cannot access the soap web service
 	

 47.Simple Single Project YARN Application


 48.Caching Data with Spring

 	project caching

 	@EnableCaching
 	@Cacheable("books")


 49.Deploying to Cloud Foundry from STS

 	none


 50.Spring Boot with Docker

  	Docker 


 51.Working a Getting Started guide with IntelliJ IDEA 

 	none


 52.Creating CRUD UI with Vaadin 

 	project vaadin

	url:http://localhost:8080

	@Route
	VerticalLayout 
	HorizontalLayout
	@UIScope


 53.Service Registration and Discovery 

	project eureka

	url:http://localhost:8080/service-instances/a-bootiful-client

	@EnableEurekaServer
	@EnableDiscoveryClient
	DiscoveryClient 
	

 54.Centralized Configuration 

 	project configuration

 	url:http://localhost:8080/message

 	@EnableConfigServer
 	@RefreshScope
 	@Value("${message:Hello default}")


 55.Routing and Filtering 

 	project routing-filtering

 	url:http://localhost:8090

 	@EnableZuulProxy
 	ZuulFilter 


 56.Circuit Breaker 

 	project circuit-breaker

   	@HystrixCommand(fallbackMethod = "reliable")
	@EnableCircuitBreaker


 57.Client Side Load Balancing with Ribbon and Spring Cloud 

 	project ribbon-cloud

 	url:http://localhost:8888/hi
 		http://localhost:8888/hi?name=Orontes

 	@RibbonClient(name = "say-hello", configuration = SayHelloConfiguration.class)
 	@LoadBalanced
 	IClientConfig 
 	IPing 
 	IRule 


 58.Testing the Web Layer

  	project test-web


 59.Accessing data with MySQL

   	project mysql

   	url:http://localhost:8080/demo/all
   		http://localhost:8080/demo/add?name=First&email=someemail@someemailprovider.com


 60.Creating a Multi Module Project 

   	project nuti-module

 	url:http://localhost:8080

 	still lib build excepetion

 	@SpringBootApplication(scanBasePackages = "com")
 	@EnableConfigurationProperties(ServiceProperties.class)
 	dependencies 
 	{
    	annotationProcessor "org.springframework.boot:spring-boot-configuration-processor"
    	compile('org.springframework.boot:spring-boot-configuration-processor:2.0.1.RELEASE')
	}


 61.Creating API Documentation with Restdocs 

    project restdocs

    @AutoConfigureRestDocs(outputDir = "target/snippets")
  	testCompile("org.springframework.restdocs:spring-restdocs-mockmvc")


 62.Messaging with Google Cloud Pub/Sub0

 	Google


 63.Building a Reactive RESTful Web Service

   	project reactive-rest

 	url:http://localhost:8080/hello 

 	Mono
 	route


 64.Consumer Driven Contracts 

     project contract-rest

     http://localhost:8000/person/1
     http://localhost:8000/person/2


 65.Accessing Vault

 	wait for install Vault 


 66.Vault Configuration 

 	wait for install Vault 


 67.Accessing Data Reactively with Redis

 	project reactive-redis

 	http://localhost:8080/coffees


 68.Deploying a Spring Boot app to Azure

 	Azure is not free


 69.Building a Gateway 

  	project gateway
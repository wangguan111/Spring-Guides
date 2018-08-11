# Spring-Guides
Whatever you're building, these guides are designed to get you productive as quickly as possible

1.Building a RESTful Web Service

	project demo-rest

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

	project demo-rest

	1.@EnableScheduling ensures that a background task executor is created. Without it, nothing gets scheduled.
		@EnableScheduling
		@Scheduled(fixedRate = 5000)
	2.@
		@Component = <bean id="" class=""/>）in xml


3.Consuming a RESTful Web Service
	
	To consume a REST web service, RestTemplate makes interacting with most RESTful services a one-line incantation.
	it can even bind that data to custom domain types.

	project resttemplate-rest

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

	project ldap-rest

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

	not install neo4j, only buid ,cannot run

	project neo4j

	 Using Spring Data Neo4j to build an application that stores data in and retrieves it from Neo4j,
	 a graph-based database.

 	 11.neo4j
	 @NodeEntity + @Id @GeneratedValue
	 + interface PersonRepository extends CrudRepository<Person, Long>
	 + @EnableNeo4jRepositories

	 43.neo4j-rest
	 @NodeEntity + @Id @GeneratedValue
	 + @RepositoryRestResource(collectionResourceRel = "people", path = "people")
	 + interface PersonRepository extends PagingAndSortingRepository<Person, Long>
	 + @EnableNeo4jRepositories

	 1.@NodeEntity
	 2.@Id @GeneratedValue
	 3.@Relationship(type = "TEAMMATE", direction = Relationship.UNDIRECTED)
	 4.CrudRepository
	 5.@EnableNeo4jRepositories
	 6.spring.data.neo4j.username=neo4 + spring.data.neo4j.password=secret


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

	project hypermedia-rest

	HATEOAS

	Hypermedia is an important aspect of REST. It allows you to build services that decouple client and 
	server to a large extent and allow them to evolve independently. The representations returned for 
	REST resources contain not only data, but links to related resources. Thus the design of the 
	representations is crucial to the design of the overall service.
	
	url:http://localhost:8080/greeting
		http://localhost:8080/greeting?name=xx

	17.hypermedia-rest
	ResourceSupport + @JsonCreator + @JsonProperty 
	+ linlkto().withSelfRel()

	22.jpa
	@Entity + @Id + @GeneratedValue(strategy = GenerationType.AUTO) 
	+ interface CustomerRepository extends CrudRepository<Customer, Long> 

	42.hypermedia_jpa_rest
 	@Entity + @Id + @GeneratedValue(strategy = GenerationType.AUTO) 
 	+ @RepositoryRestResource(collectionResourceRel = "people", path = "people")
 	+ interface PersonRepository extends PagingAndSortingRepository<Person, Long>

	1.ResourceSupport
	2.@JsonCreator - signal on how Jackson can create an instance of this POJO
	3.@JsonProperty - - clearly marks what field Jackson should put this constructor argument into
	4.POJO(Plain Old Java Object)
	5.HttpEntity<?> - ResponseEntity<?>
	6. greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
		Both linkTo(…) and methodOn(…) are static methods on ControllerLinkBuilder that allow you to 
		fake a method invocation on the controller. The LinkBuilder returned will have inspected the 
		controller method’s mapping annotation to build up exactly the URI the method is mapped to.
		withSelfRel() creates a Link instance that you add to the Greeting representation model.
	7.Traverson traverson = 
	new Traverson(new URI("http://localhost:" + this.port + "/greeting"), MediaTypes.HAL_JSON);


18.Accessing Data in Pivotal GemFire

	project pivotal-gemfire

	gemfire version is only aviable below spring-boot 2.0, cannot build and run 

	Pivotal GemFire is a In-Memory Data Grid (IMDG) that maps data to Regions. It is possible to configure
	distributed Regions that partition and replicate data across multiple nodes in a cluster. 
	using a LOCAL Region so you don’t have to set up anything extra, such as an entire cluster of servers.


	18.gemfire
 	@Region(value = "People") + @PersistenceConstructor
 	+ interface PersonRepository extends CrudRepository<Person, String>
 	+ @ClientCacheApplication(name = "AccessingGemFireDataRestApplication", logLevel = "error")
	+ @EnableEntityDefinedRegions(basePackageClasses = Person.class,
	  clientRegionShortcut = ClientRegionShortcut.LOCAL)
	+ @EnableGemfireRepositories

 	45.gemfire_rest
 	@Data + @Region("People") + @PersistenceConstructor
 	+ @RepositoryRestResource(collectionResourceRel = "people", path = "people")
 	+ interface PersonRepository extends CrudRepository<Person, Long>
 	+ @ClientCacheApplication(name = "AccessingGemFireDataRestApplication", logLevel = "error")
	+ @EnableEntityDefinedRegions(basePackageClasses = Person.class,
	  clientRegionShortcut = ClientRegionShortcut.LOCAL)
	+ @EnableGemfireRepositories

	1.@Region(value = "People")
	2.@Id + @Getter
	3.@PersistenceConstructor
	4.@Trace
	5.@EnableGemfireRepositories
	6.@ClientCacheApplication(name = "AccessingDataGemFireApplication", logLevel = "error")
	7.@EnableEntityDefinedRegions(basePackageClasses = Person.class,
        clientRegionShortcut = ClientRegionShortcut.LOCAL)    


19.Integrating Data

	project integration

	using Spring Integration to create a simple application that retrieves data from an RSS Feed (Spring Blog),
	manipulates the data, and then writes it to a file. This guide uses traditional Spring Integration XML 
	configuration; other guides exist showing the use of JavaConfig/DSL with and without JDK 8 Lambda expressions.

	1.@ImportResource("/integration.xml")
	2.RSS Feed
	3.SourcePollingChannelAdapter
	4.MessageChannel 
	5.SyndEntryImpl 


20.Caching Data with Pivotal GemFire

	project pivotal-gemfire-caching

	gemfire version is only aviable below spring-boot 2.0, cannot build and run

	fetching the same quote again eliminates the expensive call to the Quote service since Spring’s Cache Abstraction,
	backed by Pivotal GemFire, will be used to cache the results, given the same request.

 	20.pivotal-gemfire-caching
 	@Cacheable("Quotes")
 	+ @CachePut(cacheNames = "Quotes", key = "#result.id")
	+ @ClientCacheApplication(name = "CachingGemFireApplication", logLevel = "error")
	+ @EnableCachingDefinedRegions(clientRegionShortcut = ClientRegionShortcut.LOCAL)
	+ @EnableGemfireCaching

 	48.caching
 	@Cacheable("books")
 	+ @EnableCaching

	1.@Data + @JsonIgnoreProperties(ignoreUnknown = true)
	2.@JsonProperty("xxx")
	3.@Cacheable("xxx")
	4.@CachePut(cacheNames = xxx", key = "#result.id")
	5.Optional.ofNullable(this.quoteServiceTemplate.getForObject(URL, QuoteResponse.class, urlVariables))
			.map(QuoteResponse::getQuote)
			.orElse(null);


21.Managing Transactions

	project transactions

	build a simple JDBC application wherein you make database operations transactional without having to 
	write specialized JDBC code

	1.@Transactional
	2.JdbcTemplate 
	3.String... persons

	
22.Accessing Data with JPA

	project jpa

	build an application that stores Customer POJOs in a memory-based database.

	17.hypermedia-rest
	ResourceSupport + @JsonCreator + @JsonProperty 
	+ linlkto().withSelfRel()

	22.jpa
	@Entity + @Id + @GeneratedValue(strategy = GenerationType.AUTO) 
	+ interface CustomerRepository extends CrudRepository<Customer, Long> 

	42.hypermedia_jpa_rest
 	@Entity + @Id + @GeneratedValue(strategy = GenerationType.AUTO) 
 	+ @RepositoryRestResource(collectionResourceRel = "people", path = "people")
 	+ interface PersonRepository extends PagingAndSortingRepository<Person, Long>

	1.CrudRepository
	2.@Entity
	3.@Id + @GeneratedValue(strategy=GenerationType.AUTO)
	4.@DataJpaTest
	5.TestEntityManager


23.Accessing Data with MongoDB
	
	project mongodb

	store Customer POJOs in a MongoDB database using Spring Data MongoDB.

	23.mongodb
	 @Id
	+ interface CustomerRepository extends MongoRepository<Customer, String>

	44.mongodb_rest
	@Id 
	+ @RepositoryRestResource(collectionResourceRel = "people", path = "people")
    + interface PersonRepository extends MongoRepository<Person, String>

	1.MongoRepository
	2.assertThat


24.Serving Web Content with Spring MVC

	project devtools
	
	url:http://localhost:8080/greeting
		http://localhost:8080/greeting?name=xx

	1.Thymeleaf
	2.spring-boot-devtools
		Enable hot swapping
		Switches template engines to disable caching
		Enables LiveReload to refresh browser automatically
		Other reasonable defaults based on development instead of production


25.Converting a Spring Boot JAR Application to a WAR

	none


26.Creating Asynchronous Methods

	project asynchronous

	build a lookup service that queries GitHub user information and retrieves data through GitHub’s API. 
	One approach to scaling services is to run expensive jobs in the background and wait for the results
	using Java’s CompletableFuture interface. Java’s CompletableFuture is an evolution from the regular Future. 
	It makes it easy to pipeline multiple asynchronous operations merging them into a single asynchronous computation.

	1.@Service
	2.RestTemplateBuilder
	3.@Async
	4.CompletableFuture
	5.InterruptedException
	6.@EnableAsync
	7.Executor
	8.ThreadPoolTaskExecutor
	9.getForObject


27.Handling Form Submission

	project submission

	using Spring to create and submit a web form.

	url:http://localhost:8080/greeting

	1.@TestPropertySource(properties = "logging.level.org.springframework.web=DEBUG")


28.Building an Application with Spring Boot

	project boot-rest

 	1.actuator
 	2.UT + IT


29.Using WebSocket to build an interactive web application

	project stomp

	Through the process of creating a "hello world" application that sends messages back and forth,
	between a browser and the server. WebSocket is a very thin, lightweight layer above TCP. 
	It makes it very suitable to use "subprotocols" to embed messages. In this guide we’ll dive in 
	and use STOMP messaging with Spring to create an interactive web application.

	url:http://localhost:8080

 	1.@MessageMapping + @SendTo
 	2.HtmlUtils.htmlEscape
 	3.@EnableWebSocketMessageBroker
 	4.WebSocketMessageBrokerConfigurer
 	5.configureMessageBroker(MessageBrokerRegistry config)
 		config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
 	6.registerStompEndpoints(StompEndpointRegistry registry) 
 		registry.addEndpoint("/gs-guide-websocket").withSockJS()


 30.Working a Getting Started guide with STS

 	none


 31.Consuming a RESTful Web Service with AngularJS

 	AngularJS


 32.Consuming a RESTful Web Service with rest.js

 	rest.js


 33.Consuming a RESTful Web Service with jQuery

 	jQuery


 34.Enabling Cross Origin Requests for a RESTful Web Service
 
 	project cros-rest

 	through the process of creating a "hello world" RESTful web service with Spring that 
 	includes headers for Cross-Origin Resource Sharing (CORS) in the response.

	url:http://localhost:8080/greeting
		http://localhost:8080/greeting?name=xx
		http://localhost:9000

 	1.@CrossOrigin(origins = "http://localhost:9000")
 		origins, methods, allowedHeaders, exposedHeaders, allowCredentials or maxAge
 	2.WebMvcConfigurer
 	3.CorsRegistry
 		 registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:9000");
 	4.@GetMapping = @RequestMapping(method = RequestMethod.GET)


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

 	41.
 	46.


 42.Accessing JPA Data with REST

 	project hypermedia_jpa_rest

 	create and retrieve Person objects stored in a database using Spring Data REST. Spring Data REST 
 	takes the features of Spring HATEOAS and Spring Data JPA and combines them together automatically.

	17.hypermedia-rest
	ResourceSupport + @JsonCreator + @JsonProperty 
	+ linlkto().withSelfRel()

	22.jpa
	@Entity + @Id + @GeneratedValue(strategy = GenerationType.AUTO) 
	+ interface CustomerRepository extends CrudRepository<Customer, Long> 

	42.hypermedia_jpa_rest
 	@Entity + @Id + @GeneratedValue(strategy = GenerationType.AUTO) 
 	+ @RepositoryRestResource(collectionResourceRel = "people", path = "people")
 	+ interface PersonRepository extends PagingAndSortingRepository<Person, Long>

 	1.@RepositoryRestResource(collectionResourceRel = "people", path = "people")
 	2.PagingAndSortingRepository


 43.Accessing Neo4j Data with REST

 	project neo4j-rest

 	 11.neo4j
	 @NodeEntity + @Id @GeneratedValue
	 + interface PersonRepository extends CrudRepository<Person, Long>
	 + @EnableNeo4jRepositories

	 43.neo4j-rest
	 @NodeEntity + @Id @GeneratedValue
	 + @RepositoryRestResource(collectionResourceRel = "people", path = "people")
	 + interface PersonRepository extends PagingAndSortingRepository<Person, Long>
	 + @EnableNeo4jRepositories

	 1.@RepositoryRestResource(collectionResourceRel = "people", path = "people")
 	

 44.Accessing MongoDB Data with REST

 	project mongodb_rest

 	23.mongodb
	 @Id
	+ interface CustomerRepository extends MongoRepository<Customer, String>

	44.mongodb_rest
	@Id 
	+ @RepositoryRestResource(collectionResourceRel = "people", path = "people")
    + interface PersonRepository extends MongoRepository<Person, String>

 	1.@RepositoryRestResource(collectionResourceRel = "people", path = "people")


 45.Accessing Data in Pivotal GemFire with REST

 	project gemfire_rest

 	gemfire version is only aviable below spring-boot 2.0, cannot build and run 

 	18.gemfire
 	@Region(value = "People") + @PersistenceConstructor
 	+ interface PersonRepository extends CrudRepository<Person, String>
 	+ @ClientCacheApplication(name = "AccessingGemFireDataRestApplication", logLevel = "error")
	+ @EnableEntityDefinedRegions(basePackageClasses = Person.class,
	  clientRegionShortcut = ClientRegionShortcut.LOCAL)
	+ @EnableGemfireRepositories

 	45.gemfire_rest
 	@Data + @Region("People") + @PersistenceConstructor
 	+ @RepositoryRestResource(collectionResourceRel = "people", path = "people")
 	+ interface PersonRepository extends CrudRepository<Person, Long>
 	+ @ClientCacheApplication(name = "AccessingGemFireDataRestApplication", logLevel = "error")
	+ @EnableEntityDefinedRegions(basePackageClasses = Person.class,
	  clientRegionShortcut = ClientRegionShortcut.LOCAL)
	+ @EnableGemfireRepositories

	1.@RepositoryRestResource(collectionResourceRel = "people", path = "people")
	2.@EnableEntityDefinedRegions(basePackageClasses = Person.class,
	  clientRegionShortcut = ClientRegionShortcut.LOCAL)


 46.Producing a SOAP web service

 	cannot access the soap web service

 	41.
 	46.
 	

 47.Simple Single Project YARN Application


 48.Caching Data with Spring

 	project caching

 	enables caching on a simple book repository

 	20.pivotal-gemfire-caching
 	@Cacheable("Quotes")
 	+ @CachePut(cacheNames = "Quotes", key = "#result.id")
	+ @ClientCacheApplication(name = "CachingGemFireApplication", logLevel = "error")
	+ @EnableCachingDefinedRegions(clientRegionShortcut = ClientRegionShortcut.LOCAL)
	+ @EnableGemfireCaching

 	48.caching
 	@Cacheable("books")
 	+ @EnableCaching

 	1.@EnableCaching
 	2.@Cacheable("books")


 49.Deploying to Cloud Foundry from STS

 	none


 50.Spring Boot with Docker

  	Docker 


 51.Working a Getting Started guide with IntelliJ IDEA 

 	none


 52.Creating CRUD UI with Vaadin 

 	project vaadin

 	build a Vaadin UI for a simple JPA repository.an app with full CRUD(Create, Read, Update, Delete)
 	functionality and a filtering example that uses a custom repository method.

	url:http://localhost:8080

	1.@Route
	2.VerticalLayout 
	3.HorizontalLayout
	4.@SpringComponent + @UIScope


 53.Service Registration and Discovery 

	project eureka-rest

	server-client

	setup a Netflix Eureka service registry and then build a client that both registers itself with 
	the registry and uses it to resolve its own host. A service registry is useful because it enables
	client-side load-balancing and decouples service providers from consumers without the need for DNS

	url:http://localhost:8080/service-instances/a-bootiful-client

	1.@EnableEurekaServer
	2.@EnableDiscoveryClient
	3.DiscoveryClient 
	4.eureka.client.register-with-eureka=false + eureka.client.fetch-registry=false
	

 54.Centralized Configuration 

 	project configuration-rest

 	server-client

 	setup a Config Server and then build a client that consumes the configuration on startup and 
 	then refreshes the configuration without restarting the client

 	url:http://localhost:8080/message

 	1.@EnableConfigServer
 	2.@RefreshScope
 	3.@Value("${message:Hello default}")


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
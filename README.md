# Spring-Guides
Whatever you're building, these guides are designed to get you productive as quickly as possible

1.Building a RESTful Web Service

	project demo

	url:http://localhost:8080/greeting
		http://localhost:8080/greeting?name=User

	@RestController


2.Scheduling Tasks 

	project demo

	@EnableScheduling
	@Scheduled(fixedRate = 5000)
	@Component


3.Consuming a RESTful Web Service

	project demo

	@JsonIgnoreProperties(ignoreUnknown = true)
	@Bean
	CommandLineRunner


4.Accessing Relational Data using JDBC with Spring

	project demo
	
	compile("com.h2database:h2")
	jdbcTemplate.execute
	jdbcTemplate.batchUpdate
	jdbcTemplate.query


5.Uploading Files

	project uploading

	url:http://localhost:8080

	@ConfigurationProperties("storage")
	@ResponseBody
	ResponseEntity
	RedirectAttributes
	@ExceptionHandler
	AutoConfigureMockMvc
	@MockBean


6.Authenticating a User with LDAP

	project LDAP

	url:http://localhost:8080

	username = ben and password = benspassword.
	ldapAuthentication


7.Messaging with Redis

	project messaging

	redis
	@Bean
	the order of the Bean	
	CountDownLatch
	MessageListenerAdapter
	RedisConnectionFactory
	PatternTopic
	StringRedisTemplate
	convertAndSend


8.Messaging with RabbitMQ

	docker

	
9.Accessing Data with Neo4j

	Neo4j


10.Validating Form Input

	project validating

	url:http://localhost:8080

    @NotNull
   	@Min(18)
    @Size(min=2, max=30)
	@GetMapping("/")
	@PostMapping("/")
	@Valid
	addViewControllers


11.Building a RESTful Web Service with Spring Boot Actuator 

	project demo
	
	url:http://localhost:8080/greeting
		http://localhost:8080/greeting?name=xx

	@RestController = @Controller + @ResponseBody(@Controller return String; @RestController return Json)
	@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
	@TestPropertySource(properties = {"management.port=0"})
    @LocalServerPort
    @Value("${local.management.port}")
	TestRestTemplate
	


12.Messaging with JMS

	project jms

	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	@EnableJms
	JmsTemplate
	convertAndSend
	MappingJackson2MessageConverter
	DefaultJmsListenerContainerFactory
	DefaultJmsListenerContainerFactoryConfigurer
	ConnectionFactory
	JmsListenerContainerFactory
	MessageConverter


13.Creating a Batch Service

	project batch

	@EnableBatchProcessing
	FlatFileItemReaderBuilder
	ClassPathResource
	JdbcBatchItemWriterBuilder
	BeanPropertyItemSqlParameterSourceProvider


14.Securing a Web Application

	project securing

	url:http://localhost:8080

	addViewControllers
	@EnableWebSecurity
	UserDetailsService


15.Building a Hypermedia-Driven RESTful Web Service

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


16.Accessing Data in Pivotal GemFire

	gemfire version


17.Integrating Data

	project integration

	RSS Feed


18.Caching Data with Pivotal GemFire

	gemfire version


19.Managing Transactions

	project transactions

	@Transactional
	JdbcTemplate 
	String... persons
	Assert

	
20.Accessing Data with JPA

	project jpa

	CrudRepository
	@Entity
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@DataJpaTest
	TestEntityManager


21.Accessing Data with MongoDB
	
	project mongodb

	MongoRepository
	findByFirstName
	findByLastName
	assertThat


22.Serving Web Content with Spring MVC

	project hateoas
	
	url:http://localhost:8080/greeting
		http://localhost:8080/greeting?name=xx

	1.11.15 RestController vs 22 @Control
	Thymeleaf
	spring-boot-devtools


23.Converting a Spring Boot JAR Application to a WAR

	none


24.Creating Asynchronous Methods

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


25.Handling Form Submission


26.Building an Application with Spring Boot

	project boot

 	actuator/health
 	UT
 	IT


27.Using WebSocket to build an interactive web application

	project smot

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
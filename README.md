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


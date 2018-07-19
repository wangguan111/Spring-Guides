# Spring-Guides
Whatever you're building, these guides are designed to get you productive as quickly as possible

1.Building a RESTful Web Service

	url:http://localhost:8080/greeting
		http://localhost:8080/greeting?name=User

	@RestController


2.Scheduling Tasks 

	@EnableScheduling
	@Scheduled(fixedRate = 5000)
	@Component


3.Consuming a RESTful Web Service

	@JsonIgnoreProperties(ignoreUnknown = true)
	@Bean
	CommandLineRunner


4.Accessing Relational Data using JDBC with Spring

	compile("com.h2database:h2")
	jdbcTemplate.execute
	jdbcTemplate.batchUpdate
	jdbcTemplate.query


5.Uploading Files

	url:http://localhost:8080/

	@ConfigurationProperties("storage")
	@ResponseBody
	ResponseEntity
	RedirectAttributes
	@ExceptionHandler
	AutoConfigureMockMvc
	@MockBean

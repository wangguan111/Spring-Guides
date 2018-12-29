/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.ribboncloud;

import static org.assertj.core.api.BDDAssertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RibbonCloudApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SayHelloApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void shouldReturn200WhenSendingRequestToRoot() throws Exception {
		@SuppressWarnings("rawtypes") ResponseEntity<String> entity = this.testRestTemplate.getForEntity(
				"http://localhost:" + this.port + "/", String.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		then(entity.getBody()).isEqualTo("Hi!");
	}

	@Test
	public void shouldReturn200WhenSendingRequestToGreeting() throws Exception {
		@SuppressWarnings("rawtypes") ResponseEntity<String> entity = this.testRestTemplate.getForEntity(
				"http://localhost:" + this.port + "/greeting", String.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		then(entity.getBody()).isNotEmpty();
	}

}

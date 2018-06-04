package de.workshop.demo.controller;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class HelloControllerIT {

	@LocalServerPort
	public int port;

	@Before
	public void init(){
		RestAssured.port=port;
	}

	@Test
	public void testHelloControllerResponse() {
		ValidatableResponse response = when().
				get("/hello").
				then().
				statusCode(200).contentType(MediaType.TEXT_PLAIN.toString());
	}
}

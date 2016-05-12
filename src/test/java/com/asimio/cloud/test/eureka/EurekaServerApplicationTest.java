package com.asimio.cloud.test.eureka;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.asimio.cloud.eureka.EurekaServerApplication;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EurekaServerApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@ActiveProfiles("standalone")
public class EurekaServerApplicationTest {

	@Value("${local.server.port}")
	private int port;

	@Before
	public void setup() {
		RestAssured.port = this.port;
	}

	@Test
	public void shouldRetrieveNameVersion1InURL() {
		RestAssured.
			given().
				accept(ContentType.JSON).
			when().
				get("/").
			then().
				statusCode(HttpStatus.SC_OK).
				contentType(ContentType.HTML);
	}
}
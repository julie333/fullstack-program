package hello;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import config.HelloSpringConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = HelloSpringConfig.class)
@ActiveProfiles("dev")
// @ActiveProfiles({"dev","prod"})
public class HelloSpringServiceTests {

	@Autowired
	ApplicationContext context;

	@Autowired
	HelloSpringService service;

	@Test
	public void testHelloSpringService() {
		assertSame(service, context.getBean(HelloSpringService.class));
		assertThat(service.generateMessage()).isEqualTo("Hello, Spring!");
	}

}

/* MEEE */
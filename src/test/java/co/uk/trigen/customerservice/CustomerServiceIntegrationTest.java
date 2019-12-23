package co.uk.trigen.customerservice;

import co.uk.trigen.customerservice.config.CustomerServiceConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CustomerServiceApplication.class)
class CustomerServiceIntegrationTest {

	@Autowired
	private CustomerServiceConfig customerServiceConfig;

	private WebTestClient webTestClient;

	@BeforeEach
	void setUp() {
		webTestClient = WebTestClient.bindToRouterFunction(customerServiceConfig.customerServiceRoutes()).build();
	}

	@Test
	void getMethod_shouldReturnWelcomeNote(){
		webTestClient.get().uri("/customer-service/greet").exchange().expectStatus().isOk().expectBody(String.class).isEqualTo("Namastey!!");

	}

}

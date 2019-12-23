package co.uk.trigen.customerservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@Slf4j
public class CustomerServiceConfig {

    @Bean
    public RouterFunction<ServerResponse> customerServiceRoutes() {
        log.info("Testing");
        RouterFunction<ServerResponse> response = route(GET("/customer-service/greet"), request -> ok().bodyValue("Namastey!!"));
        log.info("Testing");

        return response;
    }
}

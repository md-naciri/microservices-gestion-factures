package ma.enset.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }


    //configuration static method 2
   // @Bean
    RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("r1", predicates ->  predicates.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
                .route("r1", predicates ->  predicates.path("/products/**").uri("lb://CUSTOMER-SERVICE"))
                .build();
    }

    //configuration dynamique
    @Bean
    DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {

        return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
    }

}

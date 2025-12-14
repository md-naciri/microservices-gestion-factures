package ma.enset.customerservice;

import ma.enset.customerservice.dto.CustomerConfigParams;
import ma.enset.customerservice.entities.Customer;
import ma.enset.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository repository) {
        return args -> {

            repository.saveAll(List.of(
                    Customer.builder().nom("mohammed").email("mohammed@gmail.com").build(),
                    Customer.builder().nom("bilal").email("bilal@gmail.com").build(),
                    Customer.builder().nom("aicha").email("aicha@gmail.com").build(),
                    Customer.builder().nom("maria").email("maria@gmail.com").build(),
                    Customer.builder().nom("hassan").email("hassan@gmail.com").build()
                    ));
        };
    }

}

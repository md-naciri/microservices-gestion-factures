package ma.enset.inventoryservice;

import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            List<Product> products = List.of(
                    Product.builder().name("Computer").price(10000.0).quantity(170).build(),
                    Product.builder().name("Printer").price(10000.0).quantity(170).build(),
                    Product.builder().name("Iphone").price(10000.0).quantity(170).build()
            );
            productRepository.saveAll(products);
        };
    }

}

package ua.en.kosse.oksana.hillel.hw24.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.en.kosse.oksana.hillel.hw24.models.Cart;
import ua.en.kosse.oksana.hillel.hw24.models.ProductRepository;


@Configuration
public class BaseConfiguration {
    @Bean
    public ProductRepository repository() {
        return new ProductRepository();
    }

    @Bean
    public Cart cart() {
        return new Cart();
    }
}

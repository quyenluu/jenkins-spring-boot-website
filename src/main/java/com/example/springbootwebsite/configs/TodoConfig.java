package com.example.springbootwebsite.configs;

import com.example.springbootwebsite.validators.TodoValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoConfig {
    /**
     * Tạo ra Bean TodoValidator để sử dụng cho sau này
     * @return
     * */
    @Bean
    public TodoValidator validator() {
        return new TodoValidator();
    }
}

package ru.spb.devpractices.masterbest.serverside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import ru.spb.devpractices.masterbest.serverside.mappers.IntegrationPushOrderMapper;

@SpringBootApplication
public class ServerSideApplication {

    @Bean
    IntegrationPushOrderMapper getMapper (){
        return new IntegrationPushOrderMapper();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {

        SpringApplication.run(ServerSideApplication.class, args);
    }



}

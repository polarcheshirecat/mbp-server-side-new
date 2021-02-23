package ru.spb.devpractices.masterbest.serverside;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import ru.spb.devpractices.masterbest.serverside.mappers.IntegrationPushOrderMapper;

import java.net.InetAddress;

@Slf4j
@SpringBootApplication
public class ServerSideApplication {

    @Value("${local.server.port}")
    private static int serverPort;



    @Bean
    IntegrationPushOrderMapper getMapper (){
        return new IntegrationPushOrderMapper();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        log.info("Приложение запущено на " +
                InetAddress.getLoopbackAddress().getHostAddress()
                + ":" + serverPort);
        SpringApplication.run(ServerSideApplication.class, args);
    }
}

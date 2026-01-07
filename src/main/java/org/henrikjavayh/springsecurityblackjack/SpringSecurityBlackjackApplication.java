package org.henrikjavayh.springsecurityblackjack;

import org.henrikjavayh.springsecurityblackjack.customuser.CustomUser;
import org.henrikjavayh.springsecurityblackjack.customuser.CustomUserRepository;
import org.henrikjavayh.springsecurityblackjack.customuser.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityBlackjackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityBlackjackApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CustomUserRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (repo.findByUsername("admin").isEmpty()) {
                repo.save(new CustomUser(
                        "admin",
                        encoder.encode("password"),
                        Role.ADMIN
                ));
            }
        };
    }


}

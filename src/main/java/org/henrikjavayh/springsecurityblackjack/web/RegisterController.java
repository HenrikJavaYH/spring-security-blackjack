package org.henrikjavayh.springsecurityblackjack.web;

import org.henrikjavayh.springsecurityblackjack.customuser.CustomUser;
import org.henrikjavayh.springsecurityblackjack.customuser.CustomUserRepository;
import org.henrikjavayh.springsecurityblackjack.customuser.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    private final CustomUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(CustomUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password) {


        CustomUser user = new CustomUser(
                username,
                passwordEncoder.encode(password),
                Role.USER
        );

        userRepository.save(user);

        return "redirect:/login";
    }
}

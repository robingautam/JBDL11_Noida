package org.gfg.JBDL11_Security;

import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Config {

    @Autowired
    PasswordEncoder passwordEncoder;

   /* @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user1 = User.builder().username("robin").password(passwordEncoder.encode("123456")).build();
        UserDetails user2 = User.builder().username("sagar").password(passwordEncoder.encode("123456")).build();
        UserDetails user3 = User.builder().username("preeti").password(passwordEncoder.encode("123456")).build();
        return new InMemoryUserDetailsManager(user1,user2,user3);
    }*/

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
       return httpSecurity.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(request->request.requestMatchers("/generic/public").permitAll()
                        .requestMatchers("/generic/protected").authenticated()
                        .requestMatchers("/generic/private").hasRole("admin"))
               .formLogin(Customizer.withDefaults())
                .build();
    }


}

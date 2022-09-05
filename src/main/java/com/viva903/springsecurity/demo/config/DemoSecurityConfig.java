package com.viva903.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails john = User.withDefaultPasswordEncoder()
            .username("john")
            .password("password")
            .roles("EMPLOYEE")
            .build();
        UserDetails mary = User.withDefaultPasswordEncoder()
                .username("mary")
                .password("password")
                .roles("MANAGER")
                .build();
        UserDetails susan = User.withDefaultPasswordEncoder()
                .username("susan")
                .password("password")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(john, mary, susan);
    }

}

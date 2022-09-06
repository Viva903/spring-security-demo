package com.viva903.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

//	add reference to our security data source
	@Autowired
	private DataSource securityDataSource;
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		UserDetails john = User.withDefaultPasswordEncoder().username("john")
//				.password("password").roles("EMPLOYEE").build();
//		UserDetails mary = User.withDefaultPasswordEncoder().username("mary")
//				.password("password").roles("EMPLOYEE", "MANAGER").build();
//		UserDetails susan = User.withDefaultPasswordEncoder().username("susan")
//				.password("password").roles("EMPLOYEE", "ADMIN").build();
//		return new InMemoryUserDetailsManager(john, mary, susan);
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		use JDBC authentication 
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/accessDenied");
	}

}

package com.yanmark.discoveryServer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private static final String USERNAME = "eureka";
	private static final String PASSWORD = "password";
	
	@Bean
	public UserDetailsService userDetailsService() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		var userDetailsService = new InMemoryUserDetailsManager();
		
		var user = User.withUsername(USERNAME)
				.password(encoder.encode(PASSWORD))
				.authorities("USER")
				.build();
		
		userDetailsService.createUser(user);
		
		return userDetailsService;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.authorizeHttpRequests(authorize -> authorize
						.anyRequest().authenticated()
				)
				.csrf(AbstractHttpConfigurer::disable
				)
				.httpBasic(withDefaults());
		
		return httpSecurity.build();
	}
}

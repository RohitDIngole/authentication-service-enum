package org.dnyanyog.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain getSecurityChain(HttpSecurity http) throws Exception{
		return http.csrf().disable().authorizeHttpRequests(authz ->
		{authz
		.requestMatchers("/public/**").permitAll()
		.requestMatchers("/api/**").authenticated()
		.anyRequest().authenticated();
		}
				)
				.httpBasic(withDefaults())
				.build();
	}
	
	

}

package org.formation;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.csrf().disable().authorizeRequests()
		                 .antMatchers("/auth/**").permitAll()              
		                 .anyRequest().authenticated()
		                 .and().oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	}

	
	
	
}

//package com.assignment.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//@EnableWebSecurity
//	public class SecurityConfig extends WebSecurityConfigurerAdapter {
//		 @Bean
//		 PasswordEncoder passwordEncoder(){
//		 return new BCryptPasswordEncoder();
//	}
//		 @Override
//		 protected void configure(HttpSecurity http) throws Exception {
//			 http
//				 .csrf().disable()
//				 .authorizeRequests()
//				 .antMatchers(HttpMethod.GET, "/api/**").permitAll()
//				 .anyRequest()
//				 .authenticated()
//				 .and()
//				 .formLogin()
//	                .loginPage("/login") // Use your custom login page
//	                .loginProcessingUrl("/login-process") // Custom login processing URL
//	                .defaultSuccessUrl("/dashboard") // Redirect after successful login
//				 .permitAll();
//		 }
//
//		 @Override
//		 @Bean
//		 protected UserDetailsService userDetailsService() {
//		 UserDetails test = User.builder().username("test@sunbasedata.com").password(passwordEncoder()
//		 .encode("Test@123")).roles("USER").build();
//		 return new InMemoryUserDetailsManager(test);
//		 }
//		}

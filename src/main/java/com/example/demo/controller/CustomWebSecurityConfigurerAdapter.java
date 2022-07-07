package com.example.demo.controller;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

   private final CustomUserDetailsService userDetailsService;

   public CustomWebSecurityConfigurerAdapter(CustomUserDetailsService userDetailsService) {
      this.userDetailsService = userDetailsService;
   }

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService)
            .passwordEncoder(getPasswordEncoder());
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable();
      http.headers().frameOptions().disable();
      http.authorizeRequests()
            .antMatchers("**/register/**").authenticated()
            .anyRequest().permitAll()
            .and()
            .formLogin().permitAll();
   }

   @Bean
   public PasswordEncoder getPasswordEncoder() {
      return new PasswordEncoder() {
         @Override
         public String encode(CharSequence charSequence) {
            return charSequence.toString();
         }

         @Override
         public boolean matches(CharSequence charSequence, String s) {
            return true;
         }
      };
   }
}

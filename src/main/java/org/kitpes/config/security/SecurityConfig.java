package org.kitpes.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    /* http-requests intercepting configuration */
    http.authorizeRequests()
            .antMatchers("/user/admin/**").access("hasRole('ROLE_ADMIN')")
            .and()
            .formLogin().loginPage("/login")
            .and()
            .csrf().disable();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    /* authentication configuration */
    auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
  }
}

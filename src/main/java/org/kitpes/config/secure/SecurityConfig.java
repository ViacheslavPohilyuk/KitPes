package org.kitpes.config.secure;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
      /* http-requests intercepting configuration */
    http.authorizeRequests()
            .antMatchers("/user/admin/**").access("hasRole('ROLE_ADMIN')")
            .and()
            .formLogin();
  }
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    /* authentication configuration */
    auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
  }
}

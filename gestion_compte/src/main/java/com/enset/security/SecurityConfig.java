package com.enset.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


/**
 * Created by naoufal on 23/02/2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN","USER");
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
        */
        auth.jdbcAuthentication().dataSource(dataSource).authoritiesByUsernameQuery(
                "select username as principal, password as credentials, enabled from users where username=?"
        ).authoritiesByUsernameQuery("select username as principal, role as role from users_roles where username=?")
        .rolePrefix("ROLE_")
        .passwordEncoder(new Md5PasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.formLogin().loginPage("/login");
       http.authorizeRequests().antMatchers("/operations","/consulterCompte").hasRole("USER");
        http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN");
        http.exceptionHandling().accessDeniedPage("/403");

    }
}

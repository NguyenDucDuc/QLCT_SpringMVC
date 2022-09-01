/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.configs;

import com.ducnd.configs.handlers.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author DucND
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.ducnd.repository",
    "com.ducnd.service"
})
public class SpringSecurityConfig
        extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
    
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler(){
         return new LoginSuccessHandler();
    }

    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http.formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/")
                .failureUrl("/login?error");
        http.formLogin().successHandler(this.loginSuccessHandler);
        http.logout().logoutSuccessUrl("/login");
        http.exceptionHandling()
                .accessDeniedPage("/forbidden");
        http.authorizeRequests().antMatchers("/").
                access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')").antMatchers("/add-income").
                access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')").antMatchers("/add-spending").
                access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')").antMatchers("/view-income").
                access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')").antMatchers("/view-spending").
                access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')").antMatchers("/view-income").
                access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')").antMatchers("/admin/**").
                access("hasRole('ROLE_ADMIN')");
//                .antMatchers("/**/add-income")
//                .access("hasRole('USER')");
//        .antMatchers("/**/pay")
//                .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
        http.csrf().disable();
    }

}

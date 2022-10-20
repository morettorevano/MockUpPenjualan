package Testwing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MvcSecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
//    @Order(2)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //hasRole diganti hasAuthority, hasAnyRole diganti hasAnyAuthority
        http.authorizeRequests()
                .antMatchers("/resources/**", "/account/**").permitAll()
//                .antMatchers("/product/**","/transaction/**").hasAnyAuthority()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/account/loginForm")
                .loginProcessingUrl("/authenticating")
                .and().logout()
                .and().exceptionHandling().accessDeniedPage("/account/accessDenied");
        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }
}

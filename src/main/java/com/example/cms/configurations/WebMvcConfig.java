package com.example.cms.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebMvcConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.authorizeRequests().antMatchers("admin/**").permitAll().anyRequest().authenticated().and()
//                .antMatchers("/**").permitAll().and()
//                .authorizeRequests().antMatchers("admin/login","admin/registration").permitAll();
//        httpSecurity.authorizeRequests().antMatchers("/**").permitAll()
//        .and().authorizeRequests().antMatchers("admin/**").authenticated();
//        httpSecurity.antMatcher("/**").authorizeRequests().anyRequest().permitAll();
//        httpSecurity.antMatcher("/admin/login").authorizeRequests().anyRequest().permitAll();
        httpSecurity.authorizeRequests()
                .antMatchers("/admin/login","/admin/registration","/admin/","/admin").permitAll()
                .antMatchers("/admin/**").authenticated();
//                .and().formLogin().loginPage("/admin/login");

    }
}

package com.muniao.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        //下面这两行配置表示在内存中配置了两个用户
        auth.inMemoryAuthentication()
                .withUser("javaboy").roles("admin").password("$2a$10$uYLvNoZj/RHNIUEaR9/Xx.GtN9TnktVXkS2TExPF480qmU/Htv2Oy")
                .and()
                .withUser("lisi").roles("user").password("$2a$10$YO4ddAGwlIoGy0mp5ftOxeY4VqT.mz94c5Un1AyCNceDC1dRvmgqC");
    }

    @Bean
    PasswordEncoder passwordEncoder()
    {
        //如果非不想加密，可以使用一个过期的 PasswordEncoder 的实例 NoOpPasswordEncoder
        //return NoOpPasswordEncoder.getInstance();

        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web)
    {
        web.ignoring().antMatchers("/hello");
    }


}

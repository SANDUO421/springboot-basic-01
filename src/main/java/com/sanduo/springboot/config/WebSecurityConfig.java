package com.sanduo.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * spring Security 的配置
 * 
 * @author sanduo
 * @date 2018/06/26
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /* 配置页面跳转
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/login").permitAll() // "/","/login"路径不拦截
            .anyRequest().authenticated().and().formLogin().loginPage("/login") // 设置访问页面
            .defaultSuccessUrl("/chat")// 登录成功后转向的路径
            .and().logout().permitAll();
    }

    /* 配置用户角色
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("sanduo")
            .password(new BCryptPasswordEncoder().encode("sanduo")).roles("USER")// 分配角色和用户名密码
            .and().passwordEncoder(new BCryptPasswordEncoder()).withUser("lantian")
            .password(new BCryptPasswordEncoder().encode("lantian")).roles("USER");// 分配角色和用户名密码
    }

    /* 规则
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");// 不拦截静态的资源
    }
}

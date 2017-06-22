package cn.edu.nju.spring.cms.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Created by bingo on 2017/6/23.
 */

@Configuration
@EnableResourceServer
public class configuration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/students/*").permitAll()
                .antMatchers(HttpMethod.GET, "/students").permitAll()
                .antMatchers(HttpMethod.POST,"/students").permitAll()
                .antMatchers(HttpMethod.PUT,"/students").permitAll()
                .antMatchers(HttpMethod.DELETE, "/students").permitAll()
                .anyRequest().authenticated();
    }

}
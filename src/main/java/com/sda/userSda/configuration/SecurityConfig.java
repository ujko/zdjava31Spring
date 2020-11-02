package com.sda.userSda.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/", "/wiek", "/thuser/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/modify", "/adduser", "/delete/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin();
        http.csrf().ignoringAntMatchers("/h2-console/**");
        http.headers().frameOptions().sameOrigin();
    }

//    @Autowired
//    public void securityUsers(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("pawel").password("$2a$10$cNiZDeLmd3BFmZaqtHQjr.DIxw0papmsNs9PZHWIPsf9mF2zdfw1m").roles("ADMIN", "USER")
//                .and()
//                .withUser("kasia").password("$2a$10$6/qVt/EbJumHPDLTtfM6g.Z5PbzCI.TGqWnqcIMb6tp9/zds6AYq2").roles("USER");
//    }

    @Autowired
    public void securityUsers(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select login, password, enabled from app_users where login = ?")
                .authoritiesByUsernameQuery("select login, role from user_role where login = ?");
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}

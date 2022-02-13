package com.app.config.security;


import com.app.config.BeansNames;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final OncePerRequestFilter jwtTokenFilter;
    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    private static final String[] WHITE_LIST= {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/swagger-ui/**"
    };

    public SecurityConfig(
            @Qualifier(BeansNames.ONCE_PER_REQUEST_FILTER) OncePerRequestFilter jwtTokenFilter,
            @Qualifier(BeansNames.USER_DETAILS_SERVICE) UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {


        this.jwtTokenFilter = jwtTokenFilter;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(
                (request, response, ex) -> {
                    response.sendError(
                            HttpServletResponse.SC_UNAUTHORIZED,
                            ex.getMessage()
                    );
                }
        )
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(this.WHITE_LIST).permitAll()
                .anyRequest().authenticated();
        ;

        http.addFilterBefore(this.jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService);
    }
}
package com.springsecuirty.springsecuirty.config;

import com.springsecuirty.springsecuirty.config.security.filters.CustomAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationFilter customAuthenticationFilter;



    //* to add SecurityFilterChain, so we can authenticate the user
    //* first we need to add the customAuthenticationFilter then we authorizeRequests
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        return http.
                addFilterAt(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests().anyRequest().authenticated()
                .and().build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    //    @Bean
//    public UserDetailsService userDetailsService(){
//        var uds = new InMemoryUserDetailsManager();
//
//        var u1= User.withUsername("hosam")
//                .password("hytgfred")
//                .authorities("read")
//                .build();
//
//        uds.createUser(u1);
//        return uds;
//    }

}

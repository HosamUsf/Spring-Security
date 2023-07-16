package com.springsecuirty.springsecuirty.services;

import com.springsecuirty.springsecuirty.repositoreis.UserRepository;
import com.springsecuirty.springsecuirty.secuirty.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findUserByUsername(username);

        return user.map(SecurityUser::new).orElseThrow(
                () -> new UsernameNotFoundException("Username not Found " + username));
    }
}

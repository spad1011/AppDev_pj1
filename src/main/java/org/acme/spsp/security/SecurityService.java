package org.acme.spsp.security;

import lombok.AllArgsConstructor;
import org.acme.spsp.entity.Uzer;
import org.acme.spsp.repositiory.SecurityRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@AllArgsConstructor
@Service
public class SecurityService implements UserDetailsService {

    private SecurityRepository securityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Uzer uzer = securityRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + "couldn't be found."));
        return new User(uzer.getEmail(), uzer.getPassword(), uzer.isEnabled(),
                uzer.isAccountNonExpired(), uzer.isCredentialsNonExpired(), uzer.isAccountNonLocked(),
                Collections.singleton(new SimpleGrantedAuthority(uzer.getRole())));
    }
}

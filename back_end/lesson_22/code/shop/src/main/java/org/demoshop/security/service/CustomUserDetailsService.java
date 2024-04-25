package org.demoshop.security.service;

import lombok.RequiredArgsConstructor;
import org.demoshop.repositories.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return usersRepository.findByEmail(email)
                .map(UserToUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("manager with email " + email + " not found"));
    }
}

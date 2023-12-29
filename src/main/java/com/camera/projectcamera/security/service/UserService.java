package com.camera.projectcamera.security.service;

import com.camera.projectcamera.entity.Accounts;
import com.camera.projectcamera.repository.AccountRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder
@Slf4j
public class UserService implements UserDetailsService {
    private final AccountRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Accounts user = null;

        try {
            user = userRepository.findByUserName(email);
        } catch (Exception ex) {
            throw new UsernameNotFoundException("User is not found");
        }

//        CustomUserDetails userDetail = CustomUserDetails.create(user);
        return UserDetailsImpl.build(user);
    }
}
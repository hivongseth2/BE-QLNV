//package com.camera.projectcamera.service.impl;
//
//import com.camera.projectcamera.entity.Accounts;
//import com.camera.projectcamera.repository.AccountRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService implements UserDetailsService {
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        // Kiểm tra xem user có tồn tại trong database không?
//        Accounts user = accountRepository.findByUserName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new CustomUserDetails(user);
//    }
//
//
//}
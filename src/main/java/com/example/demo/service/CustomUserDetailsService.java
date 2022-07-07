package com.example.demo.service;

import com.example.demo.exception.ApplicationError;
import com.example.demo.entity.CurrentUser;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service used by the AuthenticationManager.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

   @Autowired
   private UserRepository userRepository;

   @Override
   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      User user = userRepository.findByEmail(email);

      if (user == null) {
         throw new ApplicationError("No user found", HttpStatus.UNAUTHORIZED);
      } else {
         return new CurrentUser(user);
      }
   }
}
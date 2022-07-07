package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.example.demo.exception.ApplicationError;
import com.example.demo.entity.CurrentUser;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

   private final PasswordEncoder passwordEncoder;

   private final UserRepository userRepository;

   private final RoleRepository roleRepository;

   public AuthServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
      this.passwordEncoder = passwordEncoder;
      this.userRepository = userRepository;
      this.roleRepository = roleRepository;
   }

   public void registerUser(User user, Collection<String> roles) {
      if (user == null || roles == null) {
         throw new ApplicationError("Invalid input", HttpStatus.BAD_REQUEST);
      }

      if (this.userRepository.existsByEmail(user.getEmail())) {
         throw new ApplicationError("User exists", HttpStatus.BAD_REQUEST);
      }

      List<Role> userRoles = new ArrayList<>();
      for (String role : roles) {
         Role currentRole = new Role(role);

         if (!this.roleRepository.existsByName(role)) {
            this.roleRepository.save(currentRole);
         } else {
            currentRole = this.roleRepository.findByName(role);
         }

         userRoles.add(currentRole);
      }

      user.setRoles(userRoles);

      user.setPassword(this.passwordEncoder.encode(user.getPassword()));

      this.userRepository.save(user);
   }

   public CurrentUser getCurrentUser() {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      return (CurrentUser) authentication.getPrincipal();
   }

   public boolean isInRole(String role) {
      Collection<? extends GrantedAuthority> authorities = this.getCurrentUser().getAuthorities();

      return authorities.contains(new SimpleGrantedAuthority(role));
   }

   public boolean doestAdminExists() {
      Role role = this.roleRepository.findFirstByName("ROLE_ADMIN");
      if (role == null) {
         return false;
      }
      return this.userRepository.existsByRoles(role);
   }

   public void createAdmin(User admin) {
      if (admin == null) {
         throw new ApplicationError("Invalid input", HttpStatus.BAD_REQUEST);
      }

      if (this.doestAdminExists()) {
         throw new ApplicationError("User already exists", HttpStatus.BAD_REQUEST);
      }

      this.registerUser(admin, Arrays.asList("ROLE_ADMIN"));
   }
}
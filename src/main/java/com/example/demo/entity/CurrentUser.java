package com.example.demo.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class CurrentUser implements UserDetails {

   private User user;
   private Collection<GrantedAuthority> authorities;

   public CurrentUser(User user) {
      this.user = user;

      String[] userRoles = user.getRoles().stream().map(Role::getName).toArray(String[]::new);
      this.authorities = AuthorityUtils.createAuthorityList(userRoles);
   }

   public String getEmail() {
      return this.user.getEmail();
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return this.authorities;
   }

   @Override
   public String getPassword() {
      return this.user.getPassword();
   }

   @Override
   public String getUsername() {
      return this.user.getFirstName() + " " + this.user.getLastName();
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }
}
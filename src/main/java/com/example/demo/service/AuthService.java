package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entity.CurrentUser;
import com.example.demo.entity.User;

/**
 * Interface for working with users.
 */
public interface AuthService {

   /**
    * Register user.
    *
    * @param user {@link User} new user
    * @param roles {@link Collection<String>} collection containing the user roles
    */
   void registerUser(User user, Collection<String> roles);

   /**
    * Get current user.
    *
    * @return {@link CurrentUser} instance of the current user.
    */
   CurrentUser getCurrentUser();

   /**
    * Is in role
    *
    * @param role {@link String} role
    * @return {@link boolean} true if it is role
    */
   boolean isInRole(String role);

   /**
    * Create admin.
    *
    * @param user {@link User} new user
    */
   void createAdmin(User user);
}
package com.example.demo.repository;

import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
   boolean existsByName(String name);

   Role findByName(String name);

   Role findFirstByName(String name);
}
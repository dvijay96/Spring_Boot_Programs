package com.sasken.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sasken.model.Role;

//@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}

package com.klef.fsad.springbootbackendproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.fsad.springbootbackendproject.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>
{
  Admin findByUsernameAndPassword(String username, String password);
  
}
package com.example.springbootvue.Repository;

import com.example.springbootvue.Entity.CleanUp;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource  
public interface CleanUpRepository extends JpaRepository<CleanUp, Long> {
    CleanUp findById(long id);
}
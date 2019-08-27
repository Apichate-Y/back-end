package com.example.springbootvue.Repository;  
  
import com.example.springbootvue.Entity.TypeTime;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource  
public interface TypeTimeRepository extends JpaRepository<TypeTime, Long> {
    TypeTime findById(long id);
}
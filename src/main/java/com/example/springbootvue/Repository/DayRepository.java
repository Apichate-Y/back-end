package com.example.springbootvue.Repository;  
  
import com.example.springbootvue.Entity.DayClean;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource  
public interface DayRepository extends JpaRepository<DayClean, Long> {
    DayClean findById(long id);
}
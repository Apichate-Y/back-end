package com.example.springbootvue.Repository;  
  
import com.example.springbootvue.Entity.TimeOfDay;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource  
public interface TimeOfDayRepository extends JpaRepository<TimeOfDay, Long> {
    TimeOfDay findById(long id);
}
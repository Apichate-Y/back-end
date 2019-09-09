package com.example.springbootvue.Repository;  
  
import com.example.springbootvue.Entity.DayOfWeek;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource  
public interface DayOfWeekRepository extends JpaRepository<DayOfWeek, Long> {
    DayOfWeek findById(long id);
}
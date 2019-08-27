package com.example.springbootvue.Repository;  
  
import com.example.springbootvue.Entity.MemberClub;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource  
public interface MemberClubRepository extends JpaRepository<MemberClub, Long> {
    MemberClub findById(long id);
}
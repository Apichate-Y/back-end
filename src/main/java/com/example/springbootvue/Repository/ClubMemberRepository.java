package com.example.springbootvue.Repository;  
  
import com.example.springbootvue.Entity.ClubMember;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource  
public interface ClubMemberRepository extends JpaRepository<ClubMember, Long> {
    ClubMember findById(long id);
}
package com.example.springbootvue.Controller;

import com.example.springbootvue.Entity.ClubMember;
import com.example.springbootvue.Repository.ClubMemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ClubMemberController{

    @Autowired
    private final ClubMemberRepository clubMemberRepository;

    public ClubMemberController(ClubMemberRepository clubMemberRepository) {
        this.clubMemberRepository = clubMemberRepository;
    }

    @GetMapping("/clubmember")
    public Collection<ClubMember> ClubMembers() {
        return clubMemberRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/clubmember/{username}/{password}")
    public Collection<ClubMember> ClubMembers(@PathVariable String username,@PathVariable String password) {
        return clubMemberRepository.findAll().stream().filter(s -> s.getUsername().equals(username) && s.getPassword().equals(password)).collect(Collectors.toList());
    }

    @GetMapping("/clubmember/{id}")
    public Optional<ClubMember> ClubMembers(@PathVariable Long id) {
        Optional<ClubMember> clubmember = clubMemberRepository.findById(id);
        return clubmember;
    }
 
}

 
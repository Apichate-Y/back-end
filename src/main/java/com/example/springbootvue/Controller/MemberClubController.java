package com.example.springbootvue.Controller;

import com.example.springbootvue.Entity.MemberClub;
import com.example.springbootvue.Repository.MemberClubRepository;

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
public class MemberClubController{

    @Autowired
    private final MemberClubRepository memberClubRepository;

    public MemberClubController(MemberClubRepository memberClubRepository) {
        this.memberClubRepository = memberClubRepository;
    }

    @GetMapping("/memberclub")
    public Collection<MemberClub> MemberClubs() {
        return memberClubRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/memberclub/{id}")
    public Optional<MemberClub> Customers(@PathVariable Long id) {
        Optional<MemberClub> memberclub = memberClubRepository.findById(id);
        return memberclub;
    }
}
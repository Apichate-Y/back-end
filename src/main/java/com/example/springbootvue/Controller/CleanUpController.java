package com.example.springbootvue.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import com.example.springbootvue.Entity.*;
import com.example.springbootvue.Repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CleanUpController{

    @Autowired
    private final CleanUpRepository cleanUpRepository;
    @Autowired
    private DayRepository dayRepository;
    @Autowired
    private MemberClubRepository memberClubRepository;
    @Autowired
    private TypeTimeRepository typeTimeRepository;

    CleanUpController(CleanUpRepository cleanUpRepository) {
        this.cleanUpRepository = cleanUpRepository;
    }

    @GetMapping("/cleanup")
    public Collection<CleanUp> CleanUps(){
        return cleanUpRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/cleanup/{memberclub_id}/{dayclean_id}/{typetime_id}/{note}")
    public CleanUp newCleanUp(CleanUp newCleanUp,
    @PathVariable long memberclub_id,
    @PathVariable long dayclean_id,
    @PathVariable long typetime_id,
    @PathVariable String note){
        
        MemberClub memberClub = memberClubRepository.findById(memberclub_id);
        DayClean dayClean = dayRepository.findById(dayclean_id);
        TypeTime typeTime = typeTimeRepository.findById(typetime_id);

        newCleanUp.setMemberClub(memberClub);
        newCleanUp.setDayClean(dayClean);
        newCleanUp.setTypeTime(typeTime);
        newCleanUp.setNote(note);
        newCleanUp.setCleanupDate(new Date());

        return cleanUpRepository.save(newCleanUp);
    }
}
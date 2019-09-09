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
    private DayOfWeekRepository dayOfWeekRepository;
    @Autowired
    private ClubMemberRepository clubMemberRepository;
    @Autowired
    private TimeOfDayRepository timeOfDayRepository;

    CleanUpController(CleanUpRepository cleanUpRepository) {
        this.cleanUpRepository = cleanUpRepository;
    }

    @GetMapping("/cleanup")
    public Collection<CleanUp> CleanUps(){
        return cleanUpRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/cleanup/{clubmember_id}/{dayofweek_id}/{timeofday_id}/{note}")
    public CleanUp newCleanUp(CleanUp newCleanUp,
    @PathVariable long clubmember_id,
    @PathVariable long dayofweek_id,
    @PathVariable long timeofday_id,
    @PathVariable String note){
        
        ClubMember clubMember = clubMemberRepository.findById(clubmember_id);
        DayOfWeek dayOfWeek = dayOfWeekRepository.findById(dayofweek_id);
        TimeOfDay timeOfDay = timeOfDayRepository.findById(timeofday_id);

        newCleanUp.setClubMember(clubMember);
        newCleanUp.setDayOfWeek(dayOfWeek);
        newCleanUp.setTimeOfDay(timeOfDay);
        newCleanUp.setNote(note);
        newCleanUp.setCleanupDate(new Date());

        return cleanUpRepository.save(newCleanUp);
    }
}
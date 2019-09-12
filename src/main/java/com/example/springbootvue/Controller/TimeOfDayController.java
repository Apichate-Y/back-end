package com.example.springbootvue.Controller;

import com.example.springbootvue.Entity.TimeOfDay;
import com.example.springbootvue.Repository.TimeOfDayRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TimeOfDayController{

    @Autowired
    private final TimeOfDayRepository timeOfDayRepository;

    public TimeOfDayController(TimeOfDayRepository timeofDayRepository){
        this.timeOfDayRepository = timeofDayRepository;
    }

    @GetMapping("/timeofday")
    public Collection<TimeOfDay> TimeOfDays(){
        return timeOfDayRepository.findAll().stream().collect(Collectors.toList());
    }

}
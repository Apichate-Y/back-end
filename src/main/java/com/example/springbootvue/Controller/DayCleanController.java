package com.example.springbootvue.Controller;

import com.example.springbootvue.Entity.DayClean;
import com.example.springbootvue.Repository.DayRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class DayCleanController{
    
    @Autowired
    private final DayRepository dayRepository;

    public DayCleanController(DayRepository dayRepository){
        this.dayRepository = dayRepository;
    }

    @GetMapping("/day")
    public Collection<DayClean> DayCleans(){
        return dayRepository.findAll().stream().collect(Collectors.toList());
    }

}
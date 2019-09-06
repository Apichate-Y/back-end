package com.example.springbootvue.Controller;

import com.example.springbootvue.Entity.TypeTime;
import com.example.springbootvue.Repository.TypeTimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TypeTimeController{

    @Autowired
    private final TypeTimeRepository timeRepository;

    public TypeTimeController(TypeTimeRepository timeRepository){
        this.timeRepository = timeRepository;
    }

    @GetMapping("/typetime")
    public Collection<TypeTime> TypeTimes(){
        return timeRepository.findAll().stream().collect(Collectors.toList());
    }

}
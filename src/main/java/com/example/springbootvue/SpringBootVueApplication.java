package com.example.springbootvue;

import java.util.stream.Stream;

import com.example.springbootvue.Entity.DayClean;
import com.example.springbootvue.Entity.TypeTime;
import com.example.springbootvue.Repository.DayRepository;
import com.example.springbootvue.Repository.TypeTimeRepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootVueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVueApplication.class, args);
	}

	@Bean
	ApplicationRunner init(DayRepository dayRepository, TypeTimeRepository typetimeRepository) {
		return args -> {
			Stream.of("จันทร์", "อังคาร", "พุธ", "พฤหัสบดี", "ศุกร์").forEach(days -> {
				DayClean day = new DayClean();
				day.setDay(days);
				dayRepository.save(day);
			});

			Stream.of("เช้า", "บ่าย", "เย็น").forEach(timetype -> {
				TypeTime typeTime = new TypeTime();
				typeTime.setTimetype(timetype);
				typetimeRepository.save(typeTime);
			});

			dayRepository.findAll().forEach(System.out::println);
			typetimeRepository.findAll().forEach(System.out::println);
		};
	}
}

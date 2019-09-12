package com.example.springbootvue;

import java.util.stream.Stream;

import com.example.springbootvue.Entity.DayOfWeek;
import com.example.springbootvue.Entity.TimeOfDay;
import com.example.springbootvue.Entity.ClubMember;
import com.example.springbootvue.Repository.DayOfWeekRepository;
import com.example.springbootvue.Repository.TimeOfDayRepository;
import com.example.springbootvue.Repository.ClubMemberRepository;

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
	ApplicationRunner init(DayOfWeekRepository dayOfWeekRepository, TimeOfDayRepository timeOfDayRepository, ClubMemberRepository clubMemberRepository) {
		return args -> {
			Stream.of("จันทร์", "อังคาร", "พุธ", "พฤหัสบดี", "ศุกร์").forEach(days -> {
				DayOfWeek day = new DayOfWeek();
				day.setDay(days);
				dayOfWeekRepository.save(day);
			});

			Stream.of("เช้า", "บ่าย", "เย็น").forEach(timeofd -> {
				TimeOfDay timeofDay = new TimeOfDay();
				timeofDay.setTimetype(timeofd);
				timeOfDayRepository.save(timeofDay);
			});

			ClubMember clubMember1 = new ClubMember();
			clubMember1.setBoard("ชมรมคอมพิวเตอร์");
			clubMember1.setUsername("Apichate");
			clubMember1.setPassword("123456");
			clubMember1.setUser("B5917099");
			clubMember1.setPosition_club("กรรมการ");
			clubMemberRepository.save(clubMember1);

			ClubMember clubMember2 = new ClubMember();
			clubMember2.setBoard("ชมรมคอมพิวเตอร์");
			clubMember2.setUsername("Noparat");
			clubMember2.setPassword("123456");
			clubMember2.setUser("B5917440");
			clubMember2.setPosition_club("กรรมการ");
			clubMemberRepository.save(clubMember2);

			ClubMember clubMember3 = new ClubMember();
			clubMember3.setBoard("ชมรมคอมพิวเตอร์");
			clubMember3.setUsername("Eatrnny");
			clubMember3.setPassword("123456");
			clubMember3.setUser("B6001025");
			clubMember3.setPosition_club("กรรมการ");
			clubMemberRepository.save(clubMember3);

			ClubMember clubMember4 = new ClubMember();
			clubMember4.setBoard("ชมรมคอมพิวเตอร์");
			clubMember4.setUsername("Mayka2727");
			clubMember4.setPassword("123456");
			clubMember4.setUser("B6005900");
			clubMember4.setPosition_club("กรรมการ");
			clubMemberRepository.save(clubMember4);

			ClubMember clubMember5 = new ClubMember();
			clubMember5.setBoard("ชมรมคอมพิวเตอร์");
			clubMember5.setUsername("Jirawan");
			clubMember5.setPassword("123456");
			clubMember5.setUser("B6005924");
			clubMember5.setPosition_club("กรรมการ");
			clubMemberRepository.save(clubMember5);

			ClubMember clubMember6 = new ClubMember();
			clubMember6.setBoard("ชมรมคอมพิวเตอร์");
			clubMember6.setUsername("Rak160");
			clubMember6.setPassword("123456");
			clubMember6.setUser("B6010256");
			clubMember6.setPosition_club("กรรมการ");
			clubMemberRepository.save(clubMember6);

			dayOfWeekRepository.findAll().forEach(System.out::println);
			timeOfDayRepository.findAll().forEach(System.out::println);
			clubMemberRepository.findAll().forEach(System.out::println);
		};
	}
}

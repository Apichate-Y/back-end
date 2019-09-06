package com.example.springbootvue;

import java.util.stream.Stream;

import com.example.springbootvue.Entity.DayClean;
import com.example.springbootvue.Entity.TypeTime;
import com.example.springbootvue.Entity.MemberClub;
import com.example.springbootvue.Repository.DayRepository;
import com.example.springbootvue.Repository.TypeTimeRepository;
import com.example.springbootvue.Repository.MemberClubRepository;

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
	ApplicationRunner init(DayRepository dayRepository, TypeTimeRepository typetimeRepository, MemberClubRepository memberClubRepository) {
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

			MemberClub memberClub1 = new MemberClub();
			memberClub1.setBoard("ชมรมคอมพิวเตอร์");
			memberClub1.setUsername("Apichate");
			memberClub1.setPassword("123456");
			memberClub1.setUser("อภิเชษฐ์");
			memberClub1.setPosition_club("กรรมการ");
			memberClubRepository.save(memberClub1);

			MemberClub memberClub2 = new MemberClub();
			memberClub2.setBoard("ชมรมคอมพิวเตอร์");
			memberClub2.setUsername("Noparat");
			memberClub2.setPassword("123456");
			memberClub2.setUser("นพรัตน์");
			memberClub2.setPosition_club("กรรมการ");
			memberClubRepository.save(memberClub2);

			MemberClub memberClub3 = new MemberClub();
			memberClub3.setBoard("ชมรมคอมพิวเตอร์");
			memberClub3.setUsername("Eatrnny");
			memberClub3.setPassword("123456");
			memberClub3.setUser("วิทวัส");
			memberClub3.setPosition_club("กรรมการ");
			memberClubRepository.save(memberClub3);

			MemberClub memberClub4 = new MemberClub();
			memberClub4.setBoard("ชมรมคอมพิวเตอร์");
			memberClub4.setUsername("Mayka2727");
			memberClub4.setPassword("123456");
			memberClub4.setUser("กนกพร");
			memberClub4.setPosition_club("กรรมการ");
			memberClubRepository.save(memberClub4);

			MemberClub memberClub5 = new MemberClub();
			memberClub5.setBoard("ชมรมคอมพิวเตอร์");
			memberClub5.setUsername("Jirawan");
			memberClub5.setPassword("123456");
			memberClub5.setUser("จิรวรรณ");
			memberClub5.setPosition_club("กรรมการ");
			memberClubRepository.save(memberClub5);

			MemberClub memberClub6 = new MemberClub();
			memberClub6.setBoard("ชมรมคอมพิวเตอร์");
			memberClub6.setUsername("Rak160");
			memberClub6.setPassword("123456");
			memberClub6.setUser("ศิริลักษณ์");
			memberClub6.setPosition_club("กรรมการ");
			memberClubRepository.save(memberClub6);

			dayRepository.findAll().forEach(System.out::println);
			typetimeRepository.findAll().forEach(System.out::println);
			memberClubRepository.findAll().forEach(System.out::println);
		};
	}
}

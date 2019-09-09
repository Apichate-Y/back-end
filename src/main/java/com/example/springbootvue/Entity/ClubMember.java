package com.example.springbootvue.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Collection;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "CLUB_MEMBER")
public class ClubMember {

    @Id
    @SequenceGenerator(name = "CLUB_MEMBER_SEQ", sequenceName = "CLUB_MEMBER_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLUB_MEMBER_SEQ")
    @Column(name = "CLUB_MEMBER_ID", unique = true, nullable = true)

    private @NonNull Long id;
    private @NonNull String username;
    private @NonNull String password;

    /*@Column(name = "REGISTER_DATE")
    private @NonNull Date registerDate;*/

    private @NonNull String board;
    private @NonNull String position_club;
    private @NonNull String user;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<CleanUp> clean;
}
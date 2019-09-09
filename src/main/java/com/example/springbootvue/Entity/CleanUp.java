package com.example.springbootvue.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;

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
@Table(name = "CLEAN_UP")
public class CleanUp {

  @Id
  @SequenceGenerator(name = "CLEAN_UP_SEQ", sequenceName = "CLEAN_UP_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLEAN_UP_SEQ")
  @Column(name = "CLEAN_UP_ID", unique = true, nullable = true)

  private @NonNull Long id;

  @Column(name = "CLEANUP_DATE")
  private @NonNull Date cleanupDate;

  private @NonNull String note;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = DayOfWeek.class)
  @JoinColumn(name = "DAY_ID", insertable = true)
  private DayOfWeek dayOfWeek;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = TimeOfDay.class)
  @JoinColumn(name = "TYPE_TIME_ID", insertable = true)
  private TimeOfDay timeOfDay;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = ClubMember.class)
  @JoinColumn(name = "MEMBER_CLUB_ID", insertable = true)
  private ClubMember clubMember;

}
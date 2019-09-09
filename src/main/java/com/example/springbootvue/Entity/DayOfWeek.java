package com.example.springbootvue.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Collection;

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
@Table(name = "DAY_OF_WEEK")
public class DayOfWeek {

  @Id
  @SequenceGenerator(name = "DAY_OF_WEEK_SEQ", sequenceName = "DAY_OF_WEEK_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAY_OF_WEEK_SEQ")
  @Column(name = "DAY_OF_WEEK_ID", unique = true, nullable = true)

  private @NonNull Long id;

  private @NonNull String day;

  @OneToMany(fetch = FetchType.EAGER)
  private Collection<CleanUp> clean;
}
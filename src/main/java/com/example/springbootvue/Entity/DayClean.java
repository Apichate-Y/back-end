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
@Table(name = "DAY_CLEAN")
public class DayClean {

  @Id
  @SequenceGenerator(name = "DAY_SEQ", sequenceName = "DAY_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAY_SEQ")
  @Column(name = "DAY_ID", unique = true, nullable = true)

  private @NonNull Long id;

  private @NonNull String day;

  @OneToMany(fetch = FetchType.EAGER)
  private Collection<CleanUp> clean;
}
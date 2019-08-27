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
@Table(name = "TYPE_TIME")
public class TypeTime {

  @Id
  @SequenceGenerator(name = "TYPE_TIME_SEQ", sequenceName = "TYPE_TIME_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TYPE_TIME_SEQ")
  @Column(name = "TYPE_TIME_ID", unique = true, nullable = true)

  private @NonNull Long id;

  private @NonNull String timetype;

  @OneToMany(fetch = FetchType.EAGER)
  private Collection<CleanUp> clean;

}
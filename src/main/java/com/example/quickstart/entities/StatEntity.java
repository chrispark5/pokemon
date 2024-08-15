package com.example.quickstart.entities;

import com.example.quickstart.dto.Pokemon;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pokemon_stats")
public class StatEntity {
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long id;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name = "stat_name")
private String name;

@Column(name = "base_stat")
private int baseStat;

// @Column(name = "pokemon_id")
// private int pokemonId;

@ManyToOne
@JoinColumn(name = "pokemon_id")
private PokemonEntity pokemon;

// Getters and setters

public Pokemon.Stats convertToDto() {
return Pokemon.Stats.builder()
.baseStat(this.baseStat)
.stat(Pokemon.Stats.IndStat.builder().name(this.name).build())
.build();
}
}
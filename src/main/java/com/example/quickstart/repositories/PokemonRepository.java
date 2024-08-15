package com.example.quickstart.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quickstart.entities.PokemonEntity;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {
    Optional<PokemonEntity> findById(Integer id);
}
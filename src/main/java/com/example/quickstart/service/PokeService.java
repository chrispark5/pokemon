package com.example.quickstart.service;

// import com.example.quickstart.entities.PokemonEntity;
import java.util.List;

import com.example.quickstart.dto.Pokemon;

public interface PokeService {
    Pokemon getPokemon(String nameOrId);

    String createPost(String title, String body);

    List<Pokemon> getAllInstances();

    void deleteById(Integer id);

}
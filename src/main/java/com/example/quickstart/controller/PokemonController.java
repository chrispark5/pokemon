package com.example.quickstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.quickstart.dto.Pokemon;
import com.example.quickstart.service.PokeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PokemonController {

    @Autowired
    private final PokeService pokeService;

    // private final PokemonRepository pokemonRepository;
    // , PokemonRepository pokemonRepository
    public PokemonController(PokeService pokeService) {
        this.pokeService = pokeService;
        // this.pokemonRepository = pokemonRepository;
    }

    @GetMapping(value = "/pokemon/{name}")
    public Pokemon getPokemon(@PathVariable String name) {
        return pokeService.getPokemon(name);
        // PokemonEntity pokemonEntity = convertToEntity(pokemonDTO);
        // pokemonRepository.save(pokemonEntity);
    }

    @GetMapping("/pokemon")
    public Iterable<Pokemon> getAllPokemon() {
        return pokeService.getAllInstances();
        // return this.pokemonRepository.findAll();
    }

    @DeleteMapping("/pokemon/{id}")
    public void deletePokemon(@PathVariable Integer id) {
        pokeService.deleteById(id);
        // this.pokemonRepository.deleteById(id);
    }

    // private PokemonEntity convertToEntity(PokemonDTO pokemonDTO) {
    // // Convert DTO/model to Entity
    // PokemonEntity pokemonEntity = new PokemonEntity();
    // pokemonEntity.setId(pokemonDTO.getId());
    // pokemonEntity.setName(pokemonDTO.getName());
    // pokemonEntity.setTypes(pokemonDTO.getTypes());
    // // Map other properties as needed
    // return pokemonEntity;
    // }

}

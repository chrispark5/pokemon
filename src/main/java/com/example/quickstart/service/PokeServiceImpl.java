package com.example.quickstart.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.quickstart.dto.Pokemon;
import com.example.quickstart.entities.PokemonEntity;
import com.example.quickstart.entities.StatEntity;
import com.example.quickstart.repositories.PokemonRepository;

@Service
public class PokeServiceImpl implements PokeService {
    private static final String BASE_URL = String.format("https://pokeapi.co/api/v2/pokemon/");
    private static final Logger logger = LoggerFactory.getLogger(PokeServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokeServiceImpl(RestTemplate restTemplate, PokemonRepository pokemonRepository) {
        this.restTemplate = restTemplate;
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public Pokemon getPokemon(String nameOrId) {
        String apiUrl = BASE_URL + nameOrId;
        logger.info("Calling PokeAPI with URL: {}", apiUrl);
        try {
            Pokemon pokemon = restTemplate.getForObject(apiUrl, Pokemon.class);
            PokemonEntity pokemonEntity = convertToEntity(pokemon);
            pokemonRepository.save(pokemonEntity);
            return pokemon; // or do ResponseEntity<PokemonDTO> -> getForEntity() -> return pokemon.body
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().value() == 404) {
                logger.error("Pokemon not found: {}", nameOrId);
                // Handle the not found case, maybe return null or throw a custom exception
                return null;
            }
            throw e; // Re-throw other HttpClientErrorExceptions
        }
    }

    private PokemonEntity convertToEntity(Pokemon pokemonDTO) { //this is all for one Pokemon
        // Convert DTO/model to Entity
        PokemonEntity pokemonEntity = new PokemonEntity();
        pokemonEntity.setId(pokemonDTO.getId());
        pokemonEntity.setName(pokemonDTO.getName());
        pokemonEntity.setHeight(pokemonDTO.getHeight());
        pokemonEntity.setWeight(pokemonDTO.getWeight());
        List<String> typeNames = pokemonDTO.getTypes().stream().map(type -> type.getType().getName()).toList();
        List<String> moveNames = pokemonDTO.getMoves().stream().map(move -> move.getMove().getName()).toList();
        List<StatEntity> statEntities = new ArrayList<>();
        for (Pokemon.Stats stat : pokemonDTO.getStats()) {
            System.out.println(stat);
        StatEntity statEntity = new StatEntity();
        statEntity.setName(stat.getStat().getName()); //correct
        statEntity.setBaseStat(stat.getBaseStat()); 
        statEntity.setPokemon(pokemonEntity); // Set the Pokemon for the stat
        statEntities.add(statEntity); //adds new Stat object to the List
        }
        pokemonEntity.setTypes(typeNames);
        pokemonEntity.setMoves(moveNames);
        pokemonEntity.setStats(statEntities); //all Stat objects are in a list now and set in entity's var

        // Map other properties as needed
        return pokemonEntity;
    }

    @Override
    public String createPost(String title, String body) {
        // Define the API endpoint URL
        String apiUrl = "https://jsonplaceholder.typicode.com/posts";

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create JSON body
        String jsonBody = String.format("{\"title\": \"%s\", \"body\": \"%s\", \"userId\": 1}", title, body);

        // Create the request entity
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);

        // Make the POST request and get the response
        String response = restTemplate.postForObject(apiUrl, requestEntity, String.class);

        return response;
    }

    @Override
    public List<Pokemon> getAllInstances() {
        List<PokemonEntity> entities = pokemonRepository.findAll();
        return entities.stream()
                .map(PokemonEntity::convertToResponse)
                .toList();

    }

    @Override
    public void deleteById(Integer id) {
        pokemonRepository.deleteById(id);
    }

}

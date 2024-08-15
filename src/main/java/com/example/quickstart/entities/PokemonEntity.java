package com.example.quickstart.entities;

import java.util.List;

import com.example.quickstart.dto.Pokemon;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "pokemon")
public class PokemonEntity {

        // @GeneratedValue(strategy = GenerationType.IDENTITY)
        // @Column(name = "pokemon_id") // Specify the column name in the database table
        @Id
        @Column(name = "pokemon_id") // Specify the column name in the database table
        private Integer id;

        private String name;

        private int height;

        private int weight;

        @ElementCollection
        @CollectionTable(name = "pokemon_moves", joinColumns = @JoinColumn(name = "pokemon_id"))
        @Column(name = "move_name")
        private List<String> moves;

        @ElementCollection
        @CollectionTable(name = "pokemon_types", joinColumns = @JoinColumn(name = "pokemon_id"))
        @Column(name = "type_name")
        private List<String> types;

        @OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL) // cascade watch for
        private List<StatEntity> stats;

        public Pokemon convertToResponse() {
                List<Pokemon.PokemonType> pokemonTypes = this.types.stream()
                                .map(typeName -> Pokemon.PokemonType.builder()
                                                .type(Pokemon.PokemonType.IndType.builder().name(typeName).build())
                                                .build())
                                .toList();

                List<Pokemon.Moves> pokemonMoves = this.moves.stream()
                                .map(moveName -> Pokemon.Moves.builder()
                                                .move(Pokemon.Moves.IndMove.builder().name(moveName).build())
                                                .build())
                                .toList();

                List<Pokemon.Stats> pokemonStats = this.stats.stream()
                                .map(StatEntity::convertToDto)
                                .toList();

                return Pokemon.builder()
                                .id(this.id)
                                .name(this.name)
                                .types(pokemonTypes)
                                .height(this.height)
                                .weight(this.weight)
                                .moves(pokemonMoves)
                                .stats(pokemonStats)
                                .build();
        }

        // public void addStat(StatEntity stat) {
        // if (stats == null) {
        // stats = new ArrayList<>();
        // }
        // stats.add(stat);
        // stat.setPokemon(this);
        // }

}
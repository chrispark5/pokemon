package com.example.quickstart.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {
    private int id;

    private String name;

    private int height;

    private int weight;

    private List<Stats> stats;

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Stats {

        @JsonProperty(value = "base_stat")
        private int baseStat;

        private IndStat stat;

        @Builder
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class IndStat {
            private String name;
        }
    }

    private List<Moves> moves;

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Moves {
        private IndMove move;

        @Builder
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class IndMove {
            private String name;
        }
    }

    // @JsonProperty("types")
    private List<PokemonType> types;

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PokemonType {
        private IndType type;

        @Builder
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class IndType {
            private String name;
        }
    }

}

package br.com.backendchallenges.pokedex.pokemon.dtos;

import br.com.backendchallenges.pokedex.pokemon.domain.Pokemon;
import br.com.backendchallenges.pokedex.pokemon.domain.Type;

public record ListAllPokemonsDTO(String name, Type type, String description, String photo) {

    public ListAllPokemonsDTO(Pokemon pokemon) {
        this(pokemon.getName(), pokemon.getType(), pokemon.getDescription(), pokemon.getPhoto());
    }
}

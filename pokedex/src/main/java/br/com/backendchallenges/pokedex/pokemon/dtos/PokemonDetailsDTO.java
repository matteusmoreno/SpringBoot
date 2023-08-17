package br.com.backendchallenges.pokedex.pokemon.dtos;

import br.com.backendchallenges.pokedex.pokemon.domain.Pokemon;
import br.com.backendchallenges.pokedex.pokemon.domain.Type;

public record PokemonDetailsDTO(Long id, String name, Type type, String description, String photo, Boolean status) {

    public PokemonDetailsDTO(Pokemon pokemon) {
        this(pokemon.getId(), pokemon.getName(), pokemon.getType(), pokemon.getDescription(), pokemon.getPhoto(), pokemon.getStatus());
    }
}

package br.com.backendchallenges.pokedex.pokemon.dtos;

import br.com.backendchallenges.pokedex.pokemon.domain.Type;
import jakarta.validation.constraints.NotNull;

public record UpdatePokemonDTO(
        @NotNull
        Long id,
        String name,
        String photo,
        Type type,
        String description) {
}

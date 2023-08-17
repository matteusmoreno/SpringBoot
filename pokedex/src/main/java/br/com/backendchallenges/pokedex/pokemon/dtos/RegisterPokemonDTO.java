package br.com.backendchallenges.pokedex.pokemon.dtos;

import br.com.backendchallenges.pokedex.pokemon.domain.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterPokemonDTO(
        @NotBlank
        String name,
        @NotNull
        Type type,
        @NotBlank
        String description,
        @NotBlank
        String photo) {
}

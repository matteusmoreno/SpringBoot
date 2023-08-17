package br.com.backendchallenges.pokedex.pokemon.repository;

import br.com.backendchallenges.pokedex.pokemon.domain.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Page<Pokemon> findAllByStatusTrue(Pageable page);

    Pokemon findByName(String name);
}

package br.com.backendchallenges.pokedex.pokemon.controller;

import br.com.backendchallenges.pokedex.pokemon.domain.Pokemon;
import br.com.backendchallenges.pokedex.pokemon.dtos.ListAllPokemonsDTO;
import br.com.backendchallenges.pokedex.pokemon.dtos.PokemonDetailsDTO;
import br.com.backendchallenges.pokedex.pokemon.dtos.RegisterPokemonDTO;
import br.com.backendchallenges.pokedex.pokemon.dtos.UpdatePokemonDTO;
import br.com.backendchallenges.pokedex.pokemon.repository.PokemonRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonRepository repository;

    public PokemonController(PokemonRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterPokemonDTO data, UriComponentsBuilder uriBuilder) {
        var pokemon = new Pokemon(data);
        repository.save(pokemon);

        var uri = uriBuilder.path("/pokemon/{id}").buildAndExpand(pokemon.getId()).toUri();

        return ResponseEntity.created(uri).body(new PokemonDetailsDTO(pokemon));
    }

    @GetMapping("/listall")
    public ResponseEntity<Page<ListAllPokemonsDTO>> listAll(@PageableDefault(size = 10, sort = {"name"})Pageable pagination) {
        var page = repository.findAllByStatusTrue(pagination).map(ListAllPokemonsDTO::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/getpokemonbyid/{id}")
    public ResponseEntity pokemonDetails(@PathVariable Long id) {
        var pokemon = repository.getReferenceById(id);

        return ResponseEntity.ok().body(new PokemonDetailsDTO(pokemon));
    }

    @GetMapping("/getpokemonbyname/{name}")
    public ResponseEntity pokemonDetails(@PathVariable String name) {
        var pokemon = repository.findByName(name);

        if (pokemon == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(new PokemonDetailsDTO(pokemon));
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdatePokemonDTO data) {
        var pokemon = repository.getReferenceById(data.id());
        pokemon.updatePokemon(data);

        return ResponseEntity.ok().body(new PokemonDetailsDTO(pokemon));
    }

    @DeleteMapping("/desactivate/{id}")
    @Transactional
    public ResponseEntity desactivate(@PathVariable Long id) {
        var pokemon = repository.getReferenceById(id);
        pokemon.desactivatePokemon();

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/activate/{id}")
    @Transactional
    public ResponseEntity activate(@PathVariable Long id) {
        var pokemon = repository.getReferenceById(id);
        pokemon.activatePokemon();

        return ResponseEntity.ok().body(new PokemonDetailsDTO(pokemon));
    }
}

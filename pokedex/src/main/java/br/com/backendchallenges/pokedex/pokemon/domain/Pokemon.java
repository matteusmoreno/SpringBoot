package br.com.backendchallenges.pokedex.pokemon.domain;

import br.com.backendchallenges.pokedex.pokemon.dtos.RegisterPokemonDTO;
import br.com.backendchallenges.pokedex.pokemon.dtos.UpdatePokemonDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Pokemon")
@Table(name = "pokemons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Pokemon {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String description;
    private String photo;
    private Boolean status;

    public Pokemon(RegisterPokemonDTO data) {
        this.name = data.name();
        this.type = data.type();
        this.description = data.description();
        this.photo = data.photo();
        this.status = true;
    }

    public void updatePokemon(UpdatePokemonDTO data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.photo() != null) {
            this.photo = data.photo();
        }
        if (data.type() != null) {
            this.type = data.type();
        }
        if (data.description() != null) {
            this.description = data.description();
        }
    }

    public void desactivatePokemon() {
        this.status = false;
    }

    public void activatePokemon() {
        this.status = true;
    }
}

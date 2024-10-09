package pokemon;

import java.util.List;

public class PokemonGymOwner extends PokemonTrainer {
    private final String town;
    public PokemonGymOwner(String playerName,String town, List<Pokemon> pokemons) {
        super(playerName, pokemons);
        this.town = town;
    }

    public String getTown() {
        return town;
    }

}

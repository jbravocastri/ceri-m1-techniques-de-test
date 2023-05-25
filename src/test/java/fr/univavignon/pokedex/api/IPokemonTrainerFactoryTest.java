package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {

        public IPokemonTrainerFactory getMock(){
            doReturn(IPokemonTrainerFactory.class);
            return null;
        }

    @Test
    public void testAddPokemonTrainerWithMockito() {
        IPokemonTrainerFactory pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class); //objet Mock
        PokemonTrainer pokemonTrainer = Mockito.mock(PokemonTrainer.class); //nouveau objet - simulation.
        //expected from test : return the pokemonTrainer
        Mockito.when(pokemonTrainerFactory.createTrainer(Mockito.anyString(), Mockito.any(Team.class))).thenReturn(pokemonTrainer);
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Ash", Team.VALOR);
        assertEquals(pokemonTrainer,trainer);

        }
    @Test
    public void testAddPokemonTrainerWithoutName() {
        IPokemonTrainerFactory pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class); //objet Mock
        PokemonTrainer pokemonTrainer = Mockito.mock(PokemonTrainer.class); //nouveau objet - simulation.
        //expected from test : return the pokemonTrainer
        assertThrows(IllegalArgumentException.class, () ->{pokemonTrainerFactory.createTrainer(null,Team.MYSTIC);});
    }

}

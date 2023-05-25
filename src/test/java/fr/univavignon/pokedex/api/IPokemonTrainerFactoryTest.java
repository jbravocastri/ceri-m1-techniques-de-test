package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    @Mock
    private PokemonTrainer trainer;
    private IPokedex iPokedex;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        trainer = new PokemonTrainer("Ash", Team.MYSTIC, iPokedex);
    }

    @Test
    public void testGetName(){
        assertEquals("Ash", trainer.getName());
    }

    @Test
    public void testGetTeam() {
        assertEquals(Team.MYSTIC, trainer.getTeam());
    }

    @Test
    public void testGetPokedex() {
        assertEquals(iPokedex, trainer.getPokedex());
    }
    @Test
    public void testAddPokemonToTeam() throws PokedexException {
        when(iPokedex.getPokemon(25)).thenReturn(null); // Assuming the iPokedex returns null for an invalid ID
        trainer.addPokemonToTeam(25);
        verify(iPokedex).getPokemon(25);
    }
}

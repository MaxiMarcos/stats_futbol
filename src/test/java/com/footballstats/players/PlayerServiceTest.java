package com.footballstats.players;


import com.footballstats.players.model.Player;
import com.footballstats.players.repository.IPlayerRepository;
import com.footballstats.players.service.PlayerService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PlayerServiceTest {

    @Mock
    private IPlayerRepository jugadorRepoMock; // Mock de IPlayerRepository

    @InjectMocks
    private PlayerService playerService; // Se inyectará el mock en PlayerService
    
    public PlayerServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void getPlayers() {
 
        List<Player> players = List.of(new Player(), new Player());
        
        when(jugadorRepoMock.findAll()).thenReturn(players);
        
        List<Player> result = playerService.getPlayers();
        
        assertEquals(players,result);
    } 
    
    public void createPlayer(Player player) {
        
        when(jugadorRepoMock.save(player)).thenReturn(player);
     
        playerService.createPlayer(player);
   
        verify(jugadorRepoMock, times(1)).save(player);
       
    }
}
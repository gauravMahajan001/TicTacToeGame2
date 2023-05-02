package com.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.game.service.BoardGame;
import com.game.util.ApplicationConstant;

class TictactoeApplicationTests {
	
	@InjectMocks
	private TictactoeApplication application;
	
	@Mock
	private BoardGame game;
	private String draw ="Match draws between players";
	private String win = "Player X wins the game.";
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	@DisplayName("game draw between players")
	public void gameDraw() {
		
		Map<String, String> map = new HashMap<>();
		map.put(ApplicationConstant.GAME, ApplicationConstant.DRAW);
		
		doReturn(map).when(game).playGame(application.getBoard());
		
		String result = application.playGame();
		
		assertEquals(draw, result);
	}
	
	@Test
	@DisplayName("Player wins the game")
	public void gameWin() {
		
		Map<String, String> map = new HashMap<>();
		map.put(ApplicationConstant.GAME, ApplicationConstant.WIN);
		map.put(ApplicationConstant.PLAYER_NAME, ApplicationConstant.PLAYER_X);
		
		doReturn(map).when(game).playGame(application.getBoard());
		
		String result = application.playGame();
		
		assertEquals(win, result);
	}
	


}

package com.game.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.game.util.ApplicationConstant;

public class BoardGameTest {
	
	@InjectMocks
	private BoardGame boardGame;

	@Spy
	private PlayerInput input;

	@Spy
	private PatternMatch patternMatch;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("game win")
	public void testGamePlayWin() {
		String board[][] = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };
		gameWin();

		Map<String, String> result = boardGame.playGame(board);
		assertEquals(ApplicationConstant.WIN, result.get(ApplicationConstant.GAME));
		assertEquals(ApplicationConstant.PLAYER_X, result.get(ApplicationConstant.PLAYER_NAME));
	}
	
	@Test
	@DisplayName("game draw")
	public void testGamePlayDraw() {
		String board[][] = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };
		gameDraw();

		Map<String, String> result = boardGame.playGame(board);
		assertEquals(ApplicationConstant.DRAW, result.get(ApplicationConstant.GAME));
	}
	
	
	private void gameWin() {
		Map<String, String> mapFirstPosition = new HashMap<>();
		mapFirstPosition.put(ApplicationConstant.PLAYER_NAME, ApplicationConstant.PLAYER_X);	
		mapFirstPosition.put(ApplicationConstant.BOARD_POSITION, "1");
		
		doReturn(mapFirstPosition).when(input).boardPosition(1);
		
		Map<String, String> mapSecondPosition = new HashMap<>();
		mapSecondPosition.put(ApplicationConstant.PLAYER_NAME, ApplicationConstant.PLAYER_O);	
		mapSecondPosition.put(ApplicationConstant.BOARD_POSITION, "2");
		
		doReturn(mapSecondPosition).when(input).boardPosition(2);
		
		Map<String, String> mapThirdPosition = new HashMap<>();
		mapThirdPosition.put(ApplicationConstant.PLAYER_NAME, ApplicationConstant.PLAYER_X);	
		mapThirdPosition.put(ApplicationConstant.BOARD_POSITION, "4");
		
		doReturn(mapThirdPosition).when(input).boardPosition(3);
		
		Map<String, String> mapFourthPosition = new HashMap<>();
		mapFourthPosition.put(ApplicationConstant.PLAYER_NAME, ApplicationConstant.PLAYER_O);	
		mapFourthPosition.put(ApplicationConstant.BOARD_POSITION, "9");
		
		doReturn(mapFourthPosition).when(input).boardPosition(4);
		
		Map<String, String> mapFifthPosition = new HashMap<>();
		mapFifthPosition.put(ApplicationConstant.PLAYER_NAME, ApplicationConstant.PLAYER_X);	
		mapFifthPosition.put(ApplicationConstant.BOARD_POSITION, "7");
		
		doReturn(mapFifthPosition).when(input).boardPosition(5);
	}
	
private void gameDraw() {
		
		Map<String, String> mapFirstPosition = new HashMap<>();
		mapFirstPosition.put(ApplicationConstant.PLAYER_NAME, ApplicationConstant.PLAYER_X);	
		mapFirstPosition.put(ApplicationConstant.BOARD_POSITION, "1");
		
		doReturn(mapFirstPosition).when(input).boardPosition(1);
		
		Map<String, String> mapSecondPosition = new HashMap<>();
		mapSecondPosition.put(ApplicationConstant.PLAYER_NAME, ApplicationConstant.PLAYER_O);	
		mapSecondPosition.put(ApplicationConstant.BOARD_POSITION, "2");
		
		doReturn(mapSecondPosition).when(input).boardPosition(2);
		
		Map<String, String> mapThirdPosition = new HashMap<>();
		mapThirdPosition.put(ApplicationConstant.PLAYER_NAME, ApplicationConstant.PLAYER_X);	
		mapThirdPosition.put(ApplicationConstant.BOARD_POSITION, "7");
		
		doReturn(mapThirdPosition).when(input).boardPosition(3);
		
		Map<String, String> mapFourthPosition = new HashMap<>();
		mapFourthPosition.put(ApplicationConstant.PLAYER_NAME, ApplicationConstant.PLAYER_O);	
		mapFourthPosition.put(ApplicationConstant.BOARD_POSITION, "4");
		
		doReturn(mapFourthPosition).when(input).boardPosition(4);
		
		Map<String, String> mapFifthPosition = new HashMap<>();
		mapFifthPosition.put(ApplicationConstant.PLAYER_NAME, ApplicationConstant.PLAYER_X);	
		mapFifthPosition.put(ApplicationConstant.BOARD_POSITION, "6");
		
		doReturn(mapFifthPosition).when(input).boardPosition(5);
		
		Map<String, String> mapSixthPosition = new HashMap<>();
		mapSixthPosition.put(ApplicationConstant.PLAYER_NAME, ApplicationConstant.PLAYER_O);	
		mapSixthPosition.put(ApplicationConstant.BOARD_POSITION, "9");
		
		doReturn(mapSixthPosition).when(input).boardPosition(6);
		
		Map<String, String> mapSeventhPosition = new HashMap<>();
		mapSeventhPosition.put(ApplicationConstant.PLAYER_NAME, ApplicationConstant.PLAYER_X);	
		mapSeventhPosition.put(ApplicationConstant.BOARD_POSITION, "8");
		
		doReturn(mapSeventhPosition).when(input).boardPosition(7);
		
		Map<String, String> mapEightPosition = new HashMap<>();
		mapEightPosition.put(ApplicationConstant.PLAYER_NAME, ApplicationConstant.PLAYER_O);	
		mapEightPosition.put(ApplicationConstant.BOARD_POSITION, "5");
		
		doReturn(mapEightPosition).when(input).boardPosition(8);
		
		Map<String, String> mapNinethPosition = new HashMap<>();
		mapNinethPosition.put(ApplicationConstant.PLAYER_NAME, ApplicationConstant.PLAYER_X);	
		mapNinethPosition.put(ApplicationConstant.BOARD_POSITION, "3");
		
		doReturn(mapNinethPosition).when(input).boardPosition(9);


	}

}

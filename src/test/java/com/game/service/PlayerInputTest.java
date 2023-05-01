package com.game.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.game.util.ApplicationConstant;
import com.game.util.InputScanner;

public class PlayerInputTest {
	
	private int player_first_turn =1;
	private int player_second_turn = 2;
	
	@InjectMocks
	private PlayerInput input;
	
	@Mock
	private InputScanner inputScanner;
	
	private String boardPosition = "1";
	private int expectedBoardPosition = 1;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		
	}
	
	@Test
	@DisplayName("Check player X plays")
	public void testPlayer_X() {
		
		String result = input.getPlayer(player_first_turn);
		assertEquals(ApplicationConstant.PLAYER_X, result);
	}
	
	@Test
	@DisplayName("Check player O plays")
	public void testPlayer_O() {

		String result = input.getPlayer(player_second_turn);
		assertEquals(ApplicationConstant.PLAYER_O, result);
	}
	
	@Test
	@DisplayName("check board position")
	public void test_validBoardPosition() {
		doReturn(boardPosition).when(inputScanner).getInput();

		Map<String, String> result= input.boardPosition(player_first_turn);
		assertEquals(expectedBoardPosition, Integer.valueOf(result.get(ApplicationConstant.BOARD_POSITION)));
	}

	

}

package com.game.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.game.util.ApplicationConstant;

public class PlayerInputTest {
	
	private int player_first_turn =1;
	private int player_second_turn = 2;
	
	@InjectMocks
	private PlayerInput input;
	
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

	

}

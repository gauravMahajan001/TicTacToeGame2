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

	private int player_first_turn = 1;
	private int player_second_turn = 2;
	private String invalid_boardPosition = "T";
	private String invalid_boardPosition_zero = "0";
	private String invalid_boardPosition_ten = "10";
	private String boardPosition_exist = "5";
	private int position_exist = 5;

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

		Map<String, String> result = input.boardPosition(player_first_turn);
		assertEquals(expectedBoardPosition, Integer.valueOf(result.get(ApplicationConstant.BOARD_POSITION)));
	}

	@Test
	@DisplayName("invalid board postion i.e alphabet or special char or arithmetic operation")
	public void test_invalidBoardPosition() {
		doReturn(invalid_boardPosition).when(inputScanner).getInput();

		int result = input.check_boardPosition(ApplicationConstant.INVALID_BOARD_POSITION,
				ApplicationConstant.PLAYER_X);
		assertEquals(ApplicationConstant.INVALID_BOARD_POSITION, result);
	}

	@Test
	@DisplayName(" invalid board postion i.e less than 1")
	public void test_invalidPositionLessThan1() {
		doReturn(invalid_boardPosition_zero).when(inputScanner).getInput();

		int result = input.check_boardPosition(ApplicationConstant.INVALID_ZERO_POSITION, ApplicationConstant.PLAYER_X);
		assertEquals(ApplicationConstant.INVALID_BOARD_POSITION, result);
	}

	@Test
	@DisplayName(" invalid board postion i.e  greater than 9")
	public void test_invalidPositionGreaterThan9() {
		doReturn(invalid_boardPosition_ten).when(inputScanner).getInput();

		int result = input.check_boardPosition(ApplicationConstant.INVALID_TEN_POSITION, ApplicationConstant.PLAYER_X);
		assertEquals(ApplicationConstant.INVALID_BOARD_POSITION, result);
	}

	@Test
	@DisplayName(" board position already eist")
	public void test_boardPositionAlreadyExist() {
		doReturn(boardPosition_exist).when(inputScanner).getInput();
		input.getBoardPositionList().add(position_exist);

		int result = input.check_boardPosition(position_exist, ApplicationConstant.PLAYER_X);
		assertEquals(ApplicationConstant.INVALID_BOARD_POSITION, result);
	}

}

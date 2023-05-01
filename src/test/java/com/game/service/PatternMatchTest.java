package com.game.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.game.util.ApplicationConstant;

public class PatternMatchTest {
	
	@InjectMocks
	private PatternMatch patternMatch;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);

	}

	@Test
	@DisplayName("pattern match horizontal")
	public void testPassHorizontalMatch() {

		String board[][] = { { "1", "O", "3" }, { "O", "5", "6" }, { "X", "X", "X" } };

		Map<String, String> result = patternMatch.horizontalMatch(board);

		assertEquals(result.get(ApplicationConstant.GAME), ApplicationConstant.WIN);
	}
	
	@Test
	@DisplayName("pattern match fail horizontal")
	public void testFailHorizontalMatch() {

		String board[][] = { { "O", "X", "O" }, { "O", "X", "O" }, { "X", "X", "O" } };

		Map<String, String> result = patternMatch.horizontalMatch(board);

		assertTrue(result.isEmpty());
	}
	
	@Test
	@DisplayName("pattern match vertical")
	public void testPassVerticalMatch() {

		String board[][] = { { "X", "X", "O" }, { "4", "5", "O" }, { "7", "X", "O" } };

		Map<String, String> result = patternMatch.verticalMatch(board);

		assertEquals(result.get(ApplicationConstant.GAME), ApplicationConstant.WIN);
	}
	
	@Test
	@DisplayName("pattern match fail vertical")
	public void testFailVerticalMatch() {

		String board[][] = { { "O", "O", "X" }, { "O", "X", "O" }, { "X", "X", "O" } };

		Map<String, String> result = patternMatch.verticalMatch(board);

		assertTrue(result.isEmpty());
	}

	@Test
	@DisplayName("pattern match diagonal")
	public void testPassDiagonalMatch() {

		String board[][] = { { "O", "2", "O" }, { "X", "O", "X" }, { "X", "X", "O" } };

		Map<String, String> result = patternMatch.diagonalMatch(board);

		assertEquals(result.get(ApplicationConstant.GAME), ApplicationConstant.WIN);
	}
	

}

package com.game.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	

}

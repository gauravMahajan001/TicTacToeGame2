package com.game.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.util.ApplicationConstant;

@Service
public class BoardGame {
	@Autowired
	private PlayerInput input;

	@Autowired
	private PatternMatch patternMatch;

	public Map<String, String> playGame(String board[][]) {

		Map<String, String> result = null;
		Map<String, String> playerMap = null;
		
		for (int playerTurn = 1; playerTurn <= ApplicationConstant.TOTAL_BOARD_POSITONS; playerTurn++) {

			int boardPosition = -1;
			
			while (boardPosition == ApplicationConstant.INVALID_BOARD_POSITION) {

				playerMap = input.boardPosition(playerTurn);

				boardPosition = input.check_boardPosition(
						Integer.valueOf(playerMap.get(ApplicationConstant.BOARD_POSITION)),
						playerMap.get(ApplicationConstant.PLAYER_NAME));

			}
			
			board = replacePositionWithPlayerValue(board, boardPosition,
					playerMap.get(ApplicationConstant.PLAYER_NAME));
			
			result = checkPatternMatchInBoard(board);
			
			if (result.size() > 0) {
			    result.put(ApplicationConstant.PLAYER_NAME, playerMap.get(ApplicationConstant.PLAYER_NAME));
				break;
			}
		}
		
		result = checkGameDraw(result);

		return result;
	}
	
	private Map<String, String> checkPatternMatchInBoard(String[][] board) {
		
		Map<String, String> result = null;
		result = patternMatch.horizontalMatch(board);

		if (result.isEmpty()) {
			result = patternMatch.verticalMatch(board);
		}

		if (result.isEmpty()) {
			result = patternMatch.diagonalMatch(board);
		}
		return result;

	}

	private String[][] replacePositionWithPlayerValue(String[][] board, int position, String player) {
		int positionIndex = 0;
		for (int row = 0; row < ApplicationConstant.TOTAL_ROWS; row++) {

			for (int column = 0; column < ApplicationConstant.TOTAL_COLUMNS; column++) {
				positionIndex++;
				if (positionIndex == position) {
					board[row][column] = player;
					break;
				}

			}
		}
		return board;

	}
	
	private Map<String, String> checkGameDraw(Map<String, String> result){
		if (result.isEmpty()) {
			result.put(ApplicationConstant.GAME, ApplicationConstant.DRAW);
		}
		
		return result;
		
	}

}

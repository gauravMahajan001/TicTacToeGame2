package com.game.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.game.util.ApplicationConstant;

@Service
public class PatternMatch {
	
	private int firstColumn = 0;
	private int secondColumn = 1;
	private int thirdcolumn = 2;
	private int firstRow = 0;
	private int secondRow = 1;
	private int thirdRow = 2;
	
	/**
	 * 
	 * @param board
	 * @return Map Check the horizontal row one by one . if match then player win.
	 */
	public Map<String, String> horizontalMatch(String[][] board) {
		Map<String, String> result = new HashMap<>();

		for (int roxIndex = 0; roxIndex < ApplicationConstant.TOTAL_ROWS; roxIndex++) {

			if (board[roxIndex][firstColumn] ==board[roxIndex][secondColumn] 
					&& board[roxIndex][firstColumn]==board[roxIndex][thirdcolumn]) {

				result.put(ApplicationConstant.GAME, ApplicationConstant.WIN);
			
				break;
			}

		}
		return result;
	}	
	
	/**
	 * 
	 * @param board
	 * @return Map 
	 * Check the vertical column one by one . if match then player win.
	 */
	public Map<String, String> verticalMatch(String[][] board) {
		Map<String, String> result = new HashMap<>();

		for (int columnIndex = 0; columnIndex < ApplicationConstant.TOTAL_COLUMNS; columnIndex++) {

			if (board[firstRow][columnIndex] == board[secondRow][columnIndex] 
					&& board[firstRow][columnIndex] ==board[thirdRow][columnIndex] ) {

				result.put(ApplicationConstant.GAME, ApplicationConstant.WIN);
				
				break;
			}
		}

		return result;
	}
	
	/**
	 * 
	 * @param board
	 * @return Map 
	 * Check the diagonal. if match then player win.
	 */
	public  Map<String, String> diagonalMatch(String[][] board) {
		Map<String, String> result = new HashMap<>();

		if (board[firstRow][firstColumn] == board[secondRow][secondColumn]
				&& board[firstRow][firstColumn]==board[thirdRow][thirdcolumn]) {

			result.put(ApplicationConstant.GAME, ApplicationConstant.WIN);
			

		} else if (board[firstRow][thirdcolumn] == board[secondRow][secondColumn]
				&& board[firstRow][thirdcolumn]==board[thirdRow][firstColumn]) {

			result.put(ApplicationConstant.GAME, ApplicationConstant.WIN);
			
		}
		return result;
	}

}

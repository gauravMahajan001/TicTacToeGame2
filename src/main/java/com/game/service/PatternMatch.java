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
	
	/**
	 * 
	 * @param board
	 * @return Map Check the horizontal row one by one . if match then player win.
	 */
	Map<String, String> horizontalMatch(String[][] board) {
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

}

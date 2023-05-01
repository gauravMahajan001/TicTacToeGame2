package com.game.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.util.ApplicationConstant;
import com.game.util.InputScanner;

@Service
public class PlayerInput {
	
	private static final Logger logger = LoggerFactory.getLogger(PlayerInput.class);
	private Map<String, String> playerMap = new HashMap<>();
	
	@Autowired
	private InputScanner inputScanner;

	public String getPlayer(int playerTurn) {
		String player = null;

		if (playerTurn % 2 != 0) {
			player = ApplicationConstant.PLAYER_X;

		}else {
			player = ApplicationConstant.PLAYER_O;
		}
		return player;
	}
	
	public Map<String, String> boardPosition(int playerTurn) {

		String player = getPlayer(playerTurn);

		logger.info("\n Please player " + player + " enter digit which is in the board?");
		int boardPosition = scanInput();
		playerMap.put(ApplicationConstant.PLAYER_NAME, player);
		playerMap.put(ApplicationConstant.BOARD_POSITION, String.valueOf(boardPosition));

		return playerMap;
	}
	
	private int scanInput() {
		int position = 0;

		String number = inputScanner.getInput();
		try {
			position = Integer.parseInt(number);

		} catch (NumberFormatException e) {
			position = -1;
		}
		return position;
	}

}

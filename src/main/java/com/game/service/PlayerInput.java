package com.game.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	private List<Integer> boardPositionList = new ArrayList<>();

	@Autowired
	private InputScanner inputScanner;

	public String getPlayer(int playerTurn) {
		String player = null;

		if (playerTurn % 2 != 0) {
			player = ApplicationConstant.PLAYER_X;

		} else {
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

	public int check_boardPosition(int boardPosition, String player) {

		if (boardPosition == ApplicationConstant.INVALID_BOARD_POSITION) {
			logger.info("\n Please player " + player + " enter digit for board position?");
			boardPosition = -1;
		} else if (boardPosition <= ApplicationConstant.INVALID_ZERO_POSITION
				|| boardPosition >= ApplicationConstant.INVALID_TEN_POSITION) {
			logger.info("\n Please player " + player + " enter valid board position ?");
			boardPosition = -1;
		} else if (getBoardPositionList().contains(boardPosition)) {
			logger.info("\n This position has already exist. Please player " + player + " enter board position again ?");
			boardPosition = -1;
		}
		if (boardPosition > 0) {
			getBoardPositionList().add(boardPosition);
		}
		return boardPosition;
	}

	public List<Integer> getBoardPositionList() {
		return boardPositionList;
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

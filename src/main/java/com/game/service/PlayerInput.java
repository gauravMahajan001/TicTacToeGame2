package com.game.service;

import org.springframework.stereotype.Service;

import com.game.util.ApplicationConstant;

@Service
public class PlayerInput {

	public String getPlayer(int playerTurn) {
		String player = null;

		if (playerTurn % 2 != 0) {
			player = ApplicationConstant.PLAYER_X;

		}else {
			player = ApplicationConstant.PLAYER_O;
		}
		return player;
	}

}

package com.game;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.game.service.BoardGame;
import com.game.util.ApplicationConstant;

@SpringBootApplication
public class TictactoeApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(TictactoeApplication.class);

	@Autowired
	private BoardGame boardGame;
	private String board[][] = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };

	public static void main(String[] args) {
		SpringApplication.run(TictactoeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String result = playGame();
		logger.info(result);
	}

	public String playGame() {

		String result = null;
		Map<String, String> playerMap = boardGame.playGame(getBoard());

		if (playerMap.size() == 1) {

			result = "Match draws between players";
		} else {
			result = "Player " + playerMap.get(ApplicationConstant.PLAYER_NAME) + " wins the game.";
		}

		return result;
	}

	public String[][] getBoard() {
		return board;
	}

}

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
public class TictactoeApplication implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(TictactoeApplication.class);
	
	@Autowired
	private BoardGame boardGame;
	
	public static void main(String[] args)  {
		SpringApplication.run(TictactoeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String result =playGame();
		logger.info(result);
	}

	private String playGame() {

		String result = null;
		String board[][] = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };
		Map<String, String> playerMap = boardGame.playGame(board);

		if (playerMap.size() == 1) {
			
			result = "Match draws between players";
		} else {
			result = "Player " + playerMap.get(ApplicationConstant.PLAYER_NAME) + " wins the game.";
		}

		return result;
	}



}

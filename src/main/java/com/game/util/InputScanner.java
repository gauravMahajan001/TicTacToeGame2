package com.game.util;

import java.util.Scanner;

import org.springframework.stereotype.Component;

/**
 * 
 * This class used for scan user input
 *
 */
@Component
public class InputScanner {

	private Scanner scanner;

	public InputScanner() {
		this(new Scanner(System.in));
	}

	public InputScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public String getInput() {
		return scanner.next();
	}

}

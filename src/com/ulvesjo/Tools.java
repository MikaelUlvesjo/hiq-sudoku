package com.ulvesjo;

import java.util.Random;

public class Tools {
	/**
	 * Generate a random int from 0 to max
	 * @param max
	 * @return a random int
	 */
	public static int randInt(int max) {
		Random rand = new Random();
	    int randomNum = rand.nextInt(max + 1);
	    return randomNum;
	}
}

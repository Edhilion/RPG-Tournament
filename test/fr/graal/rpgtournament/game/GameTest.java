package fr.graal.rpgtournament.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.BeforeClass;
import org.junit.Test;

public class GameTest {
	
	private static Game game1;
	private static Game game1bis;
	private static Game game2;
	
	private final static String GAME_1 = "Game1";
	private final static String GAME_2 = "Game2";
	
	@BeforeClass
	public static void initialize() {
		game1 = new Game(GAME_1);
		game1bis = new Game(GAME_1);
		game2 = new Game(GAME_2);
	}

	@Test
	public void checkOneGameEqualsItself() {
		assertEquals(game1, game1);
	}

	@Test
	public void checkTwoDifferentGames() {
		assertNotSame(game1, game2);
	}
	
	@Test
	public void checkTwoEqualGames() {
		assertEquals(game1, game1bis);
	}

}
